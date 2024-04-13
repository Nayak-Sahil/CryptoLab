# 🔠 Poly-Alphabetic Cipher Algorithm

The Poly-Alphabetic cipher, utilizing the "One Time Pad" technique, provides enhanced encryption by employing a key that changes for each letter in the plaintext.

## 🔑 Key Generation
- The base key is established, which should ideally be of equal or lesser length than the plaintext.
- If the base key is shorter than the plaintext, it is extended by repeating the key until it matches the length of the plaintext.

## 🔐 Encryption Process
1. Each letter in the plaintext is combined with the corresponding letter in the key.
2. The combined values are shifted to produce the ciphertext, maintaining the circular nature of the alphabet.

## 🔓 Decryption Process
1. Each letter in the ciphertext is combined with the corresponding letter in the key.
2. The original plaintext is reconstructed by reversing the encryption process.

## 🛡️ Strengths
The Poly-Alphabetic cipher offers increased security by varying the encryption key for each letter, making it resistant to frequency analysis attacks.
