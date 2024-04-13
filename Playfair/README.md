# 🔠 Playfair Cipher
The Playfair cipher is a cryptographic technique that encrypts pairs of letters at a time, providing a stronger encryption than simple substitution ciphers.
- In the Playfair cipher, a 5x5 matrix of letters ('i/j' should be placed in single cell) is created based on a keyword provided by the user. 
- This matrix is used for encryption and decryption.

## 🔑 Key Generation
1. The keyword is used to fill the initial entries of the matrix, excluding duplicates.
2. The remaining letters of the alphabet are filled in the matrix in order, avoiding duplicates.
3. For Example: Key is " MONARCHY" then, 5*5 Matrix look like,

   ```java
    M   O   N   A   R
    C   H   Y   B   D
    E   F   G   I/J K
    L   P   Q   S   T
    U   V   W   X   Z
   ```

## 🔒 Encryption Process:
1. The plaintext is divided into pairs of letters.
2. Each pair is then encrypted using the Playfair algorithm, based on the positions of the letters in the matrix.
3. Encryption rules:
   
    - Case 1: If both letters are in the same row, replace each letter with the letter to its right (circularly).
    - Case 2: If both letters are in the same column, replace each letter with the letter below it (circularly).
    - Case 3: If the letters form a rectangle in the matrix, replace each letter with the letter on the same row but in the column of the other letter.

## 🔓 Decryption Process:

1. The ciphertext is divided into pairs of letters.
3. Each pair is decrypted using the reverse process of encryption, based on the positions of the letters in the matrix.

## 🛡️ Strengths:

1. Playfair cipher provides stronger encryption than simple substitution ciphers due to its handling of letter pairs.
2. It is resistant to frequency analysis attacks due to the encryption of pairs instead of individual letters.
