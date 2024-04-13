# 🔑 Diffie-Hellman Key Exchange
- It isn't an cipher algorithm.
- It's a key exchange algorithm that allows two parties to securely establish a shared secret key over an insecure channel.

## 📄 Process Overview:
<img src="https://github.com/Nayak-Sahil/CryptoLab/blob/main/Diffi_Hellmen/Diffi_Hellmen_Process.jpg" alt="DiffiHellmen Process" width="200" style="transform: rotate(-90deg);">

## 👬 Key Exchange Process:
Diffie-Hellman operates as follows:
1. **Prime Number Generation**: Choose a prime number 'q' and find primitive roots 'a' of 'q'.
2. **Private Key Generation**: Each party generates a private key ('xA' and 'xB') in the range (1, q - 1).
   
   ```java
   // Private key for person 'A'
   int xA = getNum(1, q - 1, 0);
   // Private key for person 'B'
   int xB = getNum(1, q - 1, xA);
   ```
4. **Public Key Calculation**: Calculate the public key ('yA' and 'yB') for each party using the formula y = (a^x) mod q.
   ```java
   // Public Key for person 'A'
   int yA = ((int) Math.pow(a, xA)) % q;
   // Public Key for person 'B'
   int yB = ((int) Math.pow(a, xB)) % q;
   ```
6. **Secret Key Exchange**: Each party calculates the secret key using the other party's public key and its own private key.
   ```java
   // Secret key generated at person 'A'
   int k1 = ((int) Math.pow(yB, xA)) % q;
   // Secret Key generated at person 'B'
   int k2 = ((int) Math.pow(yA, xB)) % q;
   ```
Hence, This is how both parties arrive at the same secret key 😀 (k1 = k2). 

This process ensures that both parties possess identical secret keys without directly transmitting them over the insecure channel, thereby enabling secure communication 🤝🔑.

## 🛡️ Strengths
Diffie-Hellman provides secure key exchange without the need for pre-shared secrets. It is resistant to eavesdropping attacks and allows parties to establish a shared secret key over an unsecured channel.



