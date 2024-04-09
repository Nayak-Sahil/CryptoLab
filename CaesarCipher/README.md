## 🔒 Caesar Cipher Algorithm
The Caesar Cipher is a simple encryption technique 🛡️ that shifts characters in a message by a fixed number of positions down or up the alphabet based on what operation is being performed.

## Encryption:
```js
E(x) = (x + n) mod 26
```
where:
- E(x) is the encrypted position of the letter.
- x is the position of the letter in the alphabet (0-25).
- n is the number of positions to shift.

## Decryption :
```js
D(x) = (x - n) mod 26
```
where:
- D(x) is the decrypted position of the letter.
- x is the position of the letter in the alphabet (0-25).
- n is the number of positions shifted during encryption.
