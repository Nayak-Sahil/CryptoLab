## 🔡 Caesar Cipher Algorithm
The Caesar Cipher is a simple encryption technique 🛡️ that shifts characters in a message by a fixed number of positions down or up the alphabet based on what operation is being performed.

## 🔐 Encryption:
```js
C = E(P) = (P + K) mod 26
```
where,
- C is the Cipher Letter. (Cipher Text)
- E(P) is the encryption function that defines the encrypted position of the plain-letter.
- P is the position of the letter in the alphabet (0-25).
- K is the Key (number of positions to shift).

## 🔓 Decryption :
```js
P = D(C) = (C - K) mod 26
```
where,
- P is the actual letter in readable form. (Plain Text)
- D(C) is the decryption function that defines the decrypted position of the cipher-letter.
- C is the Cipher letter.
- K is the same key that was used in encryption time.

## 🕵️‍♂️ Brute Force Attack:
A brute force attack on Caesar cipher involves systematically trying all possible keys until the correct key is found to decrypt the ciphertext. Since the Caesar cipher has only 26 possible keys (0-25), it is feasible to perform a brute-force attack.

```js
For key From 1 TO 26:
    Set password TO ""
    For Each character In ciphertext:
        Decrypt character Using key
        Add decrypted character TO password
    If password Matches system key:
        Print "Hacked with key: [current key]"
        Exit loop
```
