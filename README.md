# RSA Encryption, Decryption, and Digital Signature  

This project demonstrates the implementation of RSA encryption, decryption, and digital signature functionality in Java. The program includes operations for encrypting and decrypting messages, as well as generating and validating digital signatures.  

---

## Features  
1. **Key Pair Generation**:  
   - **Public Key**: (e, n)  
   - **Private Key**:(d, n)  

2. **Message Encryption and Decryption**:  
   - Converts a plaintext message into encrypted numeric chunks.  
   - Decrypts the numeric chunks back to the original message using the RSA algorithm.  
   - Verifies that the decrypted message matches the original plaintext.  

3. **Digital Signature**:  
   - Generates a digital signature by hashing the plaintext message and encrypting it with the private key.  
   - Verifies the signature by decrypting it with the public key and comparing it to the original hash.  

---

