package com.openfinance.security;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import org.json.JSONObject;

import java.text.ParseException;
import java.time.Instant;

/**
 * Record to represent the cryptographic result
 */
record CryptoResult(String token, String operation, Instant timestamp) {
    @Override
    public String toString() {
        return """
               Operation: %s
               Timestamp: %s
               Token: %s
               """.formatted(operation, timestamp, token);
    }
}

/**
 * Handles JWS (signing) and JWE (encryption) operations between two entities
 */
public class JWSJWEHandler {
    private final RSAKey senderSigningKey;      // Entity A's signing key pair
    private final RSAKey receiverEncryptionKey; // Entity B's encryption key pair

    public JWSJWEHandler() throws JOSEException {
        // Generate RSA key pairs for demonstration
        // In production, these would be loaded from secure storage
        this.senderSigningKey = new RSAKeyGenerator(2048)
                .keyID("sender-signing-key")
                .generate();
        
        this.receiverEncryptionKey = new RSAKeyGenerator(2048)
                .keyID("receiver-encryption-key")
                .generate();
    }

    /**
     * Signs and encrypts the payload
     * @param payload The payload to sign and encrypt
     * @return A CryptoResult containing the signed and encrypted token
     */
    public CryptoResult signAndEncrypt(String payload) throws JOSEException {
        // Step 1: Create the JWS
        var jwsHeader = new JWSHeader.Builder(JWSAlgorithm.RS256)
                .keyID(senderSigningKey.getKeyID())
                .build();

        var jwsObject = new JWSObject(jwsHeader, new Payload(payload));
        var signer = new RSASSASigner(senderSigningKey);
        jwsObject.sign(signer);

        // Step 2: Create the JWE
        var jweHeader = new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A256GCM)
                .contentType("JWS") // indicates that the payload is a JWS
                .build();

        var jweObject = new JWEObject(jweHeader, new Payload(jwsObject.serialize()));
        var encrypter = new RSAEncrypter(receiverEncryptionKey.toPublicJWK());
        jweObject.encrypt(encrypter);

        return new CryptoResult(
            jweObject.serialize(),
            "SIGN_AND_ENCRYPT",
            Instant.now()
        );
    }

    /**
     * Decrypts and verifies the token
     * @param token The token to decrypt and verify
     * @return A CryptoResult containing the decrypted and verified payload
     */
    public CryptoResult decryptAndVerify(String token) throws JOSEException, ParseException {
        // Step 1: Decrypt the JWE using receiver's private key
        var jweObject = JWEObject.parse(token);
        var decrypter = new RSADecrypter(receiverEncryptionKey);
        jweObject.decrypt(decrypter);

        // Step 2: Verify the JWS using sender's public key
        var jwsObject = JWSObject.parse(jweObject.getPayload().toString());
        var verifier = new RSASSAVerifier(senderSigningKey.toPublicJWK());
        
        if (!jwsObject.verify(verifier)) {
            throw new JOSEException("JWS signature verification failed");
        }

        return new CryptoResult(
            jwsObject.getPayload().toString(),
            "DECRYPT_AND_VERIFY",
            Instant.now()
        );
    }

    public static void main(String[] args) {
        try {
            // Create handler instance
            var handler = new JWSJWEHandler();

            // Create sample payload using text block (Java 17 feature)
            var payload = new JSONObject("""
                {
                    "message": "Hello, World!",
                    "timestamp": "%s",
                    "sender": "Entity A"
                }
                """.formatted(Instant.now()));

            // Sign and encrypt
            var signedAndEncrypted = handler.signAndEncrypt(payload.toString());
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
