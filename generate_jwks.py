import json
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.x509 import load_pem_x509_certificate
from cryptography.hazmat.backends import default_backend
import base64
import argparse

def load_private_key(private_key_path):
    """Load the private key from a PEM file."""
    with open(private_key_path, "rb") as key_file:
        private_key = serialization.load_pem_private_key(
            key_file.read(),
            password=None,
            backend=default_backend()
        )
    return private_key

def load_certificate(cert_path):
    """Load the certificate from a PEM file."""
    with open(cert_path, "rb") as cert_file:
        cert = load_pem_x509_certificate(cert_file.read(), default_backend())
    return cert

def generate_jwk(private_key, cert, kid=None, use="sig", alg="RS256"):
    """Generate a JWK from the private key and certificate.
    
    Args:
        private_key: The private key
        cert: The certificate
        kid: Optional key ID
        use: Key use, either "sig" (signature) or "enc" (encryption)
        alg: The algorithm for the key
    """
    public_key = private_key.public_key()
    public_numbers = public_key.public_numbers()

    # Base64 URL encode the modulus and exponent
    n = base64.urlsafe_b64encode(public_numbers.n.to_bytes((public_numbers.n.bit_length() + 7) // 8, byteorder="big")).decode("utf-8").rstrip("=")
    e = base64.urlsafe_b64encode(public_numbers.e.to_bytes((public_numbers.e.bit_length() + 7) // 8, byteorder="big")).decode("utf-8").rstrip("=")

    # Extract the certificate in DER format and encode it in Base64
    cert_der = cert.public_bytes(serialization.Encoding.DER)
    x5c = [base64.b64encode(cert_der).decode("utf-8")]
    
    # Calculate x5t#S256 (SHA-256 thumbprint)
    from cryptography.hazmat.primitives import hashes
    digest = hashes.Hash(hashes.SHA256(), backend=default_backend())
    digest.update(cert_der)
    x5t_s256 = base64.urlsafe_b64encode(digest.finalize()).decode("utf-8").rstrip("=")

    # Use the provided kid or default to the certificate fingerprint plus use indicator
    if kid is None:
        kid = f"{cert.fingerprint(cert.signature_hash_algorithm).hex()}-{use}"
    elif use == "enc":
        # Ensure unique kid for encryption key
        kid = f"{kid}-enc"

    # Determine the algorithm based on use
    enc_alg = "RSA-OAEP" if use == "enc" else alg

    # Generate the JWK
    jwk = {
        "kty": "RSA",
        "use": use,
        "alg": enc_alg,
        "n": n,
        "e": e,
        "x5c": x5c,
        "kid": kid,
        "x5t#S256": x5t_s256
    }
    return jwk

def generate_jwks(private_key_path, cert_path, output_path, kid):
    """Generate a JWKS file with both signature and encryption keys."""
    private_key = load_private_key(private_key_path)
    cert = load_certificate(cert_path)
    
    # Generate signature JWK
    sig_jwk = generate_jwk(private_key, cert, kid, use="sig", alg="RS256")
    
    # Generate encryption JWK from the same key
    enc_jwk = generate_jwk(private_key, cert, kid, use="enc", alg="RSA-OAEP")
    
    # Create JWKS with both keys
    jwks = {
        "keys": [sig_jwk, enc_jwk]
    }

    with open(output_path, "w") as jwks_file:
        json.dump(jwks, jwks_file, indent=2)

    print(f"JWKS file generated at {output_path} with signature and encryption keys")

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Generate a JWKS file from a private key and certificate.")
    parser.add_argument("--private-key", default="private_key.pem", help="Path to the private key file (default: private_key.pem)")
    parser.add_argument("--cert", default="certificate.pem", help="Path to the certificate file (default: certificate.pem)")
    parser.add_argument("--output", default="jwks.json", help="Path to the output JWKS file (default: jwks.json)")
    parser.add_argument("--kid", default=None, help="Key ID (kid) for the JWK (default: certificate fingerprint)")

    args = parser.parse_args()

    generate_jwks(args.private_key, args.cert, args.output, args.kid)