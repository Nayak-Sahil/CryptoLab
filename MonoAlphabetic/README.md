# 🔠 MonoAlphabetic Algorithm
- It's a simple substitution cipher technique.
- In this algorithm, each letter in the plaintext is replaced with another letter from the alphabet.
- This algorithm operates on the principle of one-to-one mapping between the letters of the plaintext and ciphertext.
- In other words, each letter in the plaintext consistently corresponds to one specific letter in the ciphertext.

## How does it work?
The algorithm primarily consists of two processes: Mapping and Substitution.

1. 📃 Mapping: The plaintext is mapped to the corresponding ciphertext using a predefined substitution table.
   
      ```java
      char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
      'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
      
      char[] codes = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S',
      'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };
      ```
3. 🔀 Substitution: Replacing each letter with it's corresponding letter from the mapping table.
  
## 🔐 Encryption:
```
encrypted_letter = codes[plaintext.indexOf(plaintext_letter)]
```

## 🔓 Decryption:
```
decrypted_letter = letters[codes.indexOf(ciphertext_letter)]
```

## ⭕ Vulnerability:
- It is vulnerable to frequency analysis attacks due to the consistent substitution of letters, making it relatively easy to crack compared to more complex encryption methods.
