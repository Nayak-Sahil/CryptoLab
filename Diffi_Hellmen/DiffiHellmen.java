package Diffi_Hellmen;

import java.util.ArrayList;
import Diffi_Hellmen.PrimitiveChecker;

public class DiffiHellmen {
    public static void main(String[] args) {
        // Step - 1: Find Prime Number 'q';
        int q = getPrime(1, 10);

        if(q == -1) {
            System.out.println("Prime can't possible in specified range");
            return;
        }

        // Step - 2: Find primitive roots of 'q';
        int a = PrimitiveChecker.findPrimitiveRoot(q);

        if(a == -1){
            System.out.println("PrimitiveRoot can't possible for "+  q);
            return;
        }
        
        System.out.println("Publicly accessible component: q = " + q + " a = " + a);

        // Step - 3: Find Private Key for Person A and B.
        int xA = getNum(1, q - 1, 0); // since private key < q
        int xB = getNum(1, q - 1, xA); // since private key < q
        
        System.out.println("Private key of Person A: " + xA);
        System.out.println("Private key of Person B: " + xB);

        // Step - 4: Find Public Key
        int yA = ((int) Math.pow(a, xA)) % q;
        int yB = ((int) Math.pow(a, xB)) % q;
        
        System.out.println("Public key of Person A: " + yA);
        System.out.println("Public key of Person B: " + yB);
        
        // Step - 5: Find Secret Key
        int k1 = ((int) Math.pow(yB, xA)) % q;
        int k2 = ((int) Math.pow(yA, xB)) % q;
        System.out.println("Secret Key of person A: " + k1);
        System.out.println("Secret Key of person B: " + k2);
    }

    public static int getPrime(int lowLimit, int highLimit){
        if(lowLimit >= highLimit) return -1; //! when range is wrong
        
        ArrayList<Integer> allPrimeNum = new ArrayList<>(); 

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

        return allPrimeNum.get(allPrimeNum.size() - 1); // largest prime number from range
    }

    public static int getNum(int low, int high, int except){
        int range = high - low + 1;
        int randomNum = (int)(Math.random() * range) + low;
        while(randomNum == except){
            randomNum = (int)(Math.random() * range) + low;
        }

        return randomNum;
    }
}
