# 🔠 RSA Algorithm
RSA (Rivest-Shamir-Adleman) is a widely used asymmetric encryption algorithm that ensures secure communication over insecure channels.

## 🔑 Key Generation Algorithm 

To generate the RSA keys, the following components need to be found:
```java
1. Public key: {e, n} 
2. Private Key: {d, n}
```
RSA key generation involves the following steps:
1. **Choose Two Prime Numbers**: Select two distinct prime numbers, p and q.
2. **Compute n**: Calculate n = p * q.
3. **Compute Euler's Totient Function**: Compute φ(n), the number of integers less than n that are coprime with n.
4. **Choose Public Exponent (e)**: Select a value for e such that 1 < e < φ(n) and gcd(e, φ(n)) = 1.
5. **Compute Private Exponent (d)**: Find a value for d such that (d * e) % φ(n) = 1.

## Find d's Value, Extended Euclidean Algorithm:
- What is the Extended Euclidean Algorithm and why it is used here?
  
  ![EEA](https://github.com/Nayak-Sahil/CryptoLab/blob/main/RSA/Extended_Euclidean_Algorithm.jpg)
- How to find the coefficient value? The algorithm that used in RSA to find the value of D is based on the following steps.
  
  ![EEA Steps](https://github.com/Nayak-Sahil/CryptoLab/blob/main/RSA/Multiplicative_Inverse_Under_Modulo.jpg)

## 🔐 Encryption
Each plaintext block is encrypted using the **public key (e, n)** by computing
  ```
  for every character:
  C = m^e % n
  ```

## 🔓 Decryption 
Each ciphertext block is decrypted using the **private key (d, n)** by computing
  ```
  for every character:
  p = c^d % n
  ```

## 🛡️ Strengths
RSA offers strong security features due to the complexity of factorizing large numbers, making it resistant to brute-force attacks. Additionally, it provides digital signatures and key exchange functionalities.
