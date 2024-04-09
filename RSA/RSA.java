package CryptoLab.RSA;
import java.util.ArrayList;

public class RSA {
    public static void main(String[] args) {
        // ? RSA Algorithm:
        
        // * Key Generation Algorithm:
        /**
         ** We required to find following component:
         ** Public key = {e, n}
         ** Private Key = {d, n} 
         */

        //  Step - 1, Find two Prime Number p and q such that p != q.
        int[] primeNums = getTwoPrime(1, 10);

        if(primeNums[0] == -1 || primeNums[1] == -1){
            System.out.println("Please change the range to get prime number");
            return;
        }

        int p = primeNums[0];
        int q = primeNums[1];
        // int p = 11;
        // int q = 13;
        System.out.println("First Prime Number 'p': " + p);
        System.out.println("Second Prime Number 'q': " + q);

        // Step - 2, Find 'n' value:
        long n = p * q;

        // Step - 3, Find ETF:Euler Totient Function value: phi(n)
        long phiN = phi(n);

        // Step - 4, Find 'e' value:
        long e = findEValue(phiN);

        if(e == -1){
            System.out.println("Sorry, There can't be any number that form co-prime of phiN");
            return;
        }

        // step - 5, Find 'd' value:
        long d = findDValue(e, phiN);
        if(d > phiN) d = d % phiN;
        if(d < 0) d = d + phiN;

        System.out.println("phi(N): " + phiN);
        System.out.println("Public Key Component: {e, n}: { " + e + ", " + n + " }");
        System.out.println("Private Key Component: {d, n}: { " + d + ", " + n + " }");

        String plainText = "hello";
        ArrayList<Long> encryptedLetterList = new ArrayList<>();

        String cipherText = encrypt(plainText, e, n, encryptedLetterList);
        System.out.println("cipherText: " + cipherText);

        System.out.println("Encrypted Letter: " + encryptedLetterList);

        String text = decrypt(encryptedLetterList, d, n);
        System.out.println("plainText: " + text);
    }

    public static int[] getTwoPrime(int lowLimit, int highLimit){
        if(lowLimit >= highLimit) return new int[]{-1, -1}; //! when range is wrong
        
        int[] primeNums = new int[2];
        
        ArrayList<Integer> allPrimeNum = new ArrayList<>(); 
        //! When there can't be possible to get 2 prime number within range
        if(allPrimeNum.size() == 1) return new int[]{-1, -1}; 

        for(int n = lowLimit; n <= highLimit; n++){
            if(n == 1) continue; // * 1 can't be prime because it has only one factor. To be a prime, number must have exactly two factors.

            //? Let's check whether current n-th number is prime or not.
            boolean isPrime = true;
            for(int j = 2; j <= Math.sqrt(n); j++){
                if(n % j == 0){
                    // if current n-th number is divisible by any number between range of 2 to sqrt(n) then, it's considered as non-prime.
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) allPrimeNum.add(n);
        }

        int range = allPrimeNum.size() - 1;
        System.out.println(allPrimeNum);
        //! Since both prime number should not be equal:
        int prime1_index = (int)(Math.random() * range);
        int prime2_index = (int)(Math.random() * range);


        while(prime2_index == prime1_index){
            prime2_index = (int)(Math.random() * range) + lowLimit;
        }

        primeNums[0] = allPrimeNum.get(prime1_index); // first prime number 'p'
        primeNums[1] = allPrimeNum.get(prime2_index); // second prime number 'q'

        return primeNums;
    }

    public static long phi(long n){
        long count = 0;
        for(long i = 1; i < n; i++){
            if(((int)gcd(i, n)) == 1) count++;
        }
        
        return count;
    }

    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static long findEValue(long phiN){
        long e = -1;
        
        //* e's value should be withing range of 1 < e < phi(n)
        for(int i = 2; i < phiN; i++){
            if (i == 3) continue;
            long gcd = gcd(i, phiN);
            if(gcd == 1){
                e = i;
                break;
            }
        }
        //* gcd(e, phi(n)) should be = 1

        return e;
    }

    public static long findDValue(long e, long phiN){
        //* d's value: d.e % phiN (should be equal) =  1 
        //? Here, Extended Euclidean Algorithm helps to find d's value:
        //? Here d's value will be multiplicative inverse of (e % phiN).
        long A, B;
        if(e > phiN){
            A = e;
            B = phiN;
        }else{
            A = phiN;
            B = e;
        }

        long T1 = 0;
        long T2 = 1;
        long Q = A / B;
        long R = A % B;
        long T = T1 - T2 * Q;

        long d = extendedEuclidean(A, B, Q, R, T1, T2, T);
        return d;
    }

    public static long extendedEuclidean(long A, long B, long Q, long R, long T1, long T2, long T){
        if(R == 0){
            return T2;
        }

        
        // shift  
        A = B;
        B = R;
        T1 = T2;
        T2 = T;
        
        // operation
        Q = A / B;
        R =  A % B;
        T = T1 - T2 * Q;
        
        return extendedEuclidean(A, B, Q, R, T1, T2, T);
    }

    public static String encrypt(String plainText, long e, long n, ArrayList<Long> encryptedLetterList){
        String cipherText = "";

        for(int i = 0; i < plainText.length(); i++){
            // for every character: C = m^e % n where m is char.
            long m = (long) (plainText.charAt(i) - 'a');
            long cipherLetter = (long) (Math.pow(m, e) % n);
            encryptedLetterList.add(cipherLetter);
            cipherText += (char) cipherLetter;
        }

        return cipherText;
    }

    public static String decrypt(ArrayList<Long> encodedLetter, long d, long n){
        String plainText = "";

        for(int i = 0; i < encodedLetter.size(); i++){
            // for every character: p = c^d % n where m is char.
            long c = encodedLetter.get(i);
            long plainLetter = (long) ((Math.pow(c, d)) % n);
            plainText += (char) (plainLetter + 97);
        }

        return plainText;
    }
}
