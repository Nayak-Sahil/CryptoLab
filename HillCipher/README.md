# 🔠 Hill Cipher Algorithm
The Hill cipher is a cryptographic technique that operates on matrices to encrypt and decrypt messages.

## 🔑 Key Generation
- The key is represented by a square matrix, typically of size N x N.
- In this example, a 2x2 matrix is used as the key:
  ```math
  Key Matrix (2x2): \begin{bmatrix}2, 3 \\\ 3, 6 \end{bmatrix}
  ```
## 🔐 Encryption Process
1. The plaintext message is divided into vectors of size N x 1.
   ```math
   Ciphertext Vector cI = (\begin{bmatrix}2, 3 \\\ 3, 6 \end{bmatrix} * \begin{bmatrix}X \\\ Y \end{bmatrix})\mod  26
   ```
3. Each vector is multiplied by the key matrix, and the result is modulo 26.
4. The resulting vectors form the ciphertext.

## 🔓 Decryption Process
1. The ciphertext vectors are multiplied by the inverse of the key matrix, modulo 26.
2. The resulting vectors are combined to form the plaintext message.
   ```math
    PlainText Vector = (Inverse(Key Matrix) \cdot Ciphertext Vector) \mod 26
   ```

## 🛡️ Strength
- The Hill cipher provides a high level of security due to its reliance on matrix operations, making it resistant to traditional cryptographic attacks such as frequency analysis.
- Its effectiveness is further enhanced by its ability to encrypt multiple letters at once, providing a more complex encryption scheme compared to simple substitution ciphers.





