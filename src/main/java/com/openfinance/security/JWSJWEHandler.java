package com.openfinance.security;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import org.json.JSONObject;

import java.text.ParseException;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Sealed interface to represent cryptographic operations
 */
sealed interface CryptoOperation permits CryptoOperation.SignAndEncrypt, CryptoOperation.DecryptAndVerify {
    record SignAndEncrypt() implements CryptoOperation {}
    record DecryptAndVerify() implements CryptoOperation {}
}

/**
 * Record to represent the cryptographic result with enhanced validation
 * @param token The resulting token from the operation
 * @param operation The type of operation performed
 * @param timestamp The timestamp of when the operation was performed
 */
record CryptoResult(String token, CryptoOperation operation, Instant timestamp) {
    public CryptoResult {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Token cannot be null or blank");
        }
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
    }

    /**
     * Returns a JSON representation of this result
     * @return JSONObject containing the operation, timestamp, and token
     */
    public JSONObject toJson() {
        return new JSONObject()
            .put("operation", operation.getClass().getSimpleName())
            .put("timestamp", timestamp.toString())
            .put("token", token);
    }

    @Override
    public String toString() {
        return toJson().toString(2); // return formatted JSON string with 2-space indentation
    }
}

/**
 * Handles JWS (signing) and JWE (encryption) operations between two entities
 * Enhanced with Java 21 features and improved error handling
 */
public final class JWSJWEHandler implements AutoCloseable {
    private final RSAKey senderSigningKey;
    private final RSAKey receiverEncryptionKey;
    private final ExecutorService executorService;

    public JWSJWEHandler() throws JOSEException {
        // Use virtual threads for async operations
        this.executorService = Executors.newVirtualThreadPerTaskExecutor();
        
        // Generate RSA key pairs with enhanced security
        this.senderSigningKey = new RSAKeyGenerator(4096)
                .keyID("sender-signing-key")
                .generate();
        
        this.receiverEncryptionKey = new RSAKeyGenerator(4096)
                .keyID("receiver-encryption-key")
                .generate();
    }

    /**
     * Signs and encrypts the payload asynchronously
     * @param payload The payload to sign and encrypt
     * @return A Future containing the CryptoResult
     * @throws IllegalArgumentException if payload is null or empty
     */
    public Future<CryptoResult> signAndEncryptAsync(String payload) {
        if (payload == null || payload.isBlank()) {
            throw new IllegalArgumentException("Payload cannot be null or empty");
        }

        return executorService.submit(() -> {
            try {
                return signAndEncrypt(payload);
            } catch (JOSEException e) {
                throw new SecurityException("Failed to sign and encrypt payload", e);
            }
        });
    }

    /**
     * Signs and encrypts the payload synchronously
     * @param payload The payload to sign and encrypt
     * @return A CryptoResult containing the signed and encrypted token
     * @throws JOSEException if signing or encryption fails
     * @throws IllegalArgumentException if payload is null or empty
     */
    public CryptoResult signAndEncrypt(String payload) throws JOSEException {
        if (payload == null || payload.isBlank()) {
            throw new IllegalArgumentException("Payload cannot be null or empty");
        }

        var jwsHeader = new JWSHeader.Builder(JWSAlgorithm.RS512) // Enhanced to RS512
                .keyID(senderSigningKey.getKeyID())
                .build();

        var jwsObject = new JWSObject(jwsHeader, new Payload(payload));
        var signer = new RSASSASigner(senderSigningKey);
        jwsObject.sign(signer);

        var jweHeader = new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A256GCM)
                .contentType("JWS")
                .compressionAlgorithm(CompressionAlgorithm.DEF) // Added compression
                .build();

        var jweObject = new JWEObject(jweHeader, new Payload(jwsObject.serialize()));
        var encrypter = new RSAEncrypter(receiverEncryptionKey.toPublicJWK());
        jweObject.encrypt(encrypter);

        return new CryptoResult(
            jweObject.serialize(),
            new CryptoOperation.SignAndEncrypt(),
            Instant.now()
        );
    }

    /**
     * Decrypts and verifies the token asynchronously
     * @param token The token to decrypt and verify
     * @return A Future containing the CryptoResult
     * @throws IllegalArgumentException if token is null or empty
     */
    public Future<CryptoResult> decryptAndVerifyAsync(String token) {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Token cannot be null or empty");
        }

        return executorService.submit(() -> {
            try {
                return decryptAndVerify(token);
            } catch (Exception e) {
                throw new SecurityException("Failed to decrypt and verify token", e);
            }
        });
    }

    /**
     * Decrypts and verifies the token synchronously
     * @param token The token to decrypt and verify
     * @return A CryptoResult containing the decrypted and verified payload
     * @throws JOSEException if decryption or verification fails
     * @throws ParseException if token parsing fails
     * @throws IllegalArgumentException if token is null or empty
     */
    public CryptoResult decryptAndVerify(String token) throws JOSEException, ParseException {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Token cannot be null or empty");
        }

        try {
            var jweObject = JWEObject.parse(token);
            var decrypter = new RSADecrypter(receiverEncryptionKey);
            jweObject.decrypt(decrypter);

            var jwsObject = JWSObject.parse(jweObject.getPayload().toString());
            var verifier = new RSASSAVerifier(senderSigningKey.toPublicJWK());
            
            if (!jwsObject.verify(verifier)) {
                throw new JOSEException("JWS signature verification failed");
            }

            return new CryptoResult(
                jwsObject.getPayload().toString(),
                new CryptoOperation.DecryptAndVerify(),
                Instant.now()
            );
        } catch (ParseException e) {
            throw new JOSEException("Unexpected error: Failed to parse token", e);
        } catch (JOSEException e) {
            if (e.getMessage().contains("JWS signature verification failed")) {
                throw e;
            }
            throw new JOSEException("Unexpected error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new JOSEException("Unexpected error during decryption/verification", e);
        }
    }

    @Override
    public void close() {
        executorService.shutdown();
    }

    public static void main(String[] args) {
        try {
            // Create handler instance
            var handler = new JWSJWEHandler();

            // Create sample payload using text block (Java 17 feature)
            var payload = """
                {
                    "message": "Hello, World!",
                    "timestamp": "%s",
                    "sender": "Entity A"
                }
                """.formatted(Instant.now());

            // Sign and encrypt
            var signedAndEncrypted = handler.signAndEncrypt(payload);
            System.out.println("Signed and Encrypted Result:");
            System.out.println(signedAndEncrypted);

            // Decrypt and verify
            var decryptedAndVerified = handler.decryptAndVerify(signedAndEncrypted.token());
            System.out.println("Decrypted and Verified Result:");
            System.out.println(decryptedAndVerified);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
