package com.openfinance.security;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import com.nimbusds.jose.JOSEException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class JWSJWEHandlerTest {

    @Test
    void testSignAndEncryptFlow() throws Exception {
        try (var handler = new JWSJWEHandler()) {
            var payload = """
                {
                    "message": "Hello, World!",
                    "timestamp": "2025-01-17T08:03:45+08:00"
                }""";

            // Test sign and encrypt
            var signedAndEncrypted = handler.signAndEncrypt(payload);
            assertNotNull(signedAndEncrypted);
            
            // Test JSON output
            var json = signedAndEncrypted.toJson();
            assertTrue(json instanceof JSONObject);
            assertEquals("SignAndEncrypt", json.getString("operation"));
            assertNotNull(json.getString("timestamp"));
            assertNotNull(json.getString("token"));
            
            // Test toString format
            var jsonString = signedAndEncrypted.toString();
            assertTrue(jsonString.contains("\"operation\""));
            assertTrue(jsonString.contains("\"timestamp\""));
            assertTrue(jsonString.contains("\"token\""));

            // Test decrypt and verify
            var decrypted = handler.decryptAndVerify(signedAndEncrypted.token());
            assertEquals(payload, decrypted.token());
            assertEquals("DecryptAndVerify", decrypted.toJson().getString("operation"));
        }
    }

    @Test
    void testAsyncOperations() throws Exception {
        try (var handler = new JWSJWEHandler()) {
            var payload = "Test async payload";

            // Test async sign and encrypt
            var futureSignedAndEncrypted = handler.signAndEncryptAsync(payload);
            var signedAndEncrypted = futureSignedAndEncrypted.get(5, TimeUnit.SECONDS);
            assertNotNull(signedAndEncrypted);

            // Test async decrypt and verify
            var futureDecrypted = handler.decryptAndVerifyAsync(signedAndEncrypted.token());
            var decrypted = futureDecrypted.get(5, TimeUnit.SECONDS);
            assertEquals(payload, decrypted.token());
        }
    }

    @Test
    void testInputValidation() {
        assertThrows(IllegalArgumentException.class, () -> new CryptoResult(null, new CryptoOperation.SignAndEncrypt(), java.time.Instant.now()));
        assertThrows(IllegalArgumentException.class, () -> new CryptoResult("", new CryptoOperation.SignAndEncrypt(), java.time.Instant.now()));
        assertThrows(IllegalArgumentException.class, () -> new CryptoResult("token", null, java.time.Instant.now()));
        assertThrows(IllegalArgumentException.class, () -> new CryptoResult("token", new CryptoOperation.SignAndEncrypt(), null));
    }

    @Test
    void testInvalidInputs() throws Exception {
        try (var handler = new JWSJWEHandler()) {
            // Test null and empty inputs for sync methods
            assertThrows(IllegalArgumentException.class, () -> handler.signAndEncrypt(null));
            assertThrows(IllegalArgumentException.class, () -> handler.signAndEncrypt(""));
            assertThrows(IllegalArgumentException.class, () -> handler.decryptAndVerify(null));
            assertThrows(IllegalArgumentException.class, () -> handler.decryptAndVerify(""));

            // Test null and empty inputs for async methods
            assertThrows(IllegalArgumentException.class, () -> handler.signAndEncryptAsync(null));
            assertThrows(IllegalArgumentException.class, () -> handler.signAndEncryptAsync(""));
            assertThrows(IllegalArgumentException.class, () -> handler.decryptAndVerifyAsync(null));
            assertThrows(IllegalArgumentException.class, () -> handler.decryptAndVerifyAsync(""));

            // Test invalid token format
            assertThrows(Exception.class, () -> handler.decryptAndVerify("invalid-token"));
            var futureDecrypted = handler.decryptAndVerifyAsync("invalid-token");
            assertThrows(ExecutionException.class, () -> futureDecrypted.get(5, TimeUnit.SECONDS));
        }
    }

    @Test
    void testAsyncTimeout() throws Exception {
        try (var handler = new JWSJWEHandler()) {
            var payload = "Test timeout";
            var future = handler.signAndEncryptAsync(payload);
            
            // Test that we can get the result within timeout
            assertDoesNotThrow(() -> future.get(5, TimeUnit.SECONDS));
            
            // Test timeout
            var longPayload = "x".repeat(10000); // Large payload to cause longer processing
            var slowFuture = handler.signAndEncryptAsync(longPayload);
            assertThrows(TimeoutException.class, () -> slowFuture.get(1, TimeUnit.MILLISECONDS));
        }
    }

    @Test
    void testCryptoOperations() {
        var signAndEncrypt = new CryptoOperation.SignAndEncrypt();
        var decryptAndVerify = new CryptoOperation.DecryptAndVerify();
        
        assertNotEquals(signAndEncrypt.getClass(), decryptAndVerify.getClass());
        assertEquals("SignAndEncrypt", signAndEncrypt.getClass().getSimpleName());
        assertEquals("DecryptAndVerify", decryptAndVerify.getClass().getSimpleName());
    }

    @Test
    void testExceptionHandling() throws Exception {
        try (var handler = new JWSJWEHandler()) {
            // Test parse exception
            var invalidToken = "not-a-valid-token";
            var exception = assertThrows(ExecutionException.class, 
                () -> handler.decryptAndVerifyAsync(invalidToken).get(5, TimeUnit.SECONDS));
            assertTrue(exception.getCause() instanceof SecurityException);
            assertTrue(exception.getCause().getCause().getMessage().contains("Failed to parse token"));

            // Test verification failure
            var payload = "Test payload";
            var signedAndEncrypted = handler.signAndEncrypt(payload);
            var corruptedToken = signedAndEncrypted.token().replace('a', 'b');
            exception = assertThrows(ExecutionException.class, 
                () -> handler.decryptAndVerifyAsync(corruptedToken).get(5, TimeUnit.SECONDS));
            assertTrue(exception.getCause() instanceof SecurityException);
            assertTrue(exception.getCause().getMessage().contains("Failed to decrypt"));
        }
    }

    @Test
    void testCleanShutdown() throws Exception {
        var handler = new JWSJWEHandler();
        var payload = "Test cleanup";
        
        // Start an async operation
        var future = handler.signAndEncryptAsync(payload);
        
        // Close the handler
        handler.close();
        
        // The operation should still complete
        var result = future.get(5, TimeUnit.SECONDS);
        assertNotNull(result);
        
        // New operations should fail
        assertThrows(Exception.class, () -> handler.signAndEncryptAsync(payload));
    }

    @Test
    void testCompression() throws Exception {
        try (var handler = new JWSJWEHandler()) {
            var largePayload = "x".repeat(1000);
            var compressedResult = handler.signAndEncrypt(largePayload);
            
            // Verify the compressed payload can be decrypted
            var decrypted = handler.decryptAndVerify(compressedResult.token());
            assertEquals(largePayload, decrypted.token());
            
            // Compare sizes (compressed should be smaller)
            var smallPayload = "x".repeat(10);
            var uncompressedResult = handler.signAndEncrypt(smallPayload);
            
            assertTrue(compressedResult.token().length() < largePayload.length() * 2,
                "Compression should reduce size for large payloads");
            assertTrue(uncompressedResult.token().length() > smallPayload.length(),
                "Small payloads should have overhead from encryption");
        }
    }

    @Test
    void testAsyncErrorHandling() throws Exception {
        try (var handler = new JWSJWEHandler()) {
            // Test that errors in async operations are properly propagated
            var exception = assertThrows(IllegalArgumentException.class, 
                () -> handler.signAndEncryptAsync(null));
            assertTrue(exception.getMessage().contains("cannot be null"));
            
            // Test that the executor service is shut down properly
            handler.close();
            assertThrows(RejectedExecutionException.class, () -> handler.signAndEncryptAsync("test"));
        }
    }

    @Test
    void testUnexpectedError() throws Exception {
        try (var handler = new JWSJWEHandler()) {
            // Create a malformed token that will cause an unexpected error
            var signedAndEncrypted = handler.signAndEncrypt("test");
            var malformedToken = signedAndEncrypted.token().substring(10); // Remove header
            
            // This should throw a JOSEException with "Unexpected error" message
            var exception = assertThrows(JOSEException.class, 
                () -> handler.decryptAndVerify(malformedToken));
            assertTrue(exception.getMessage().contains("Unexpected error"));
        }
    }
}
