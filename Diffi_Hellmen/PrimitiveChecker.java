package Diffi_Hellmen;

import java.util.ArrayList;

public class PrimitiveChecker {
    public static void main(String[] args) {
        int prime = 7;
        int primitive_root = findPrimitiveRoot(prime);
    }

    public static int findPrimitiveRoot(int p){
        // Step - 1: Find Euler's Totient funciton phi(p)
        int phiP = p - 1; // for prime_number phi(p) = p - 1
        
        // Step - 2: Find all factors of phi(P)
        ArrayList<Integer> factors = getFactor(phiP);
        
        // Step - 3: Filter all prime factors from above factorlist
        ArrayList<Integer> primeFactors = getPrimeFactor(factors);
        ArrayList<Integer> nIValues = getNiValue(phiP, primeFactors);

        int primitiveRoot = getPrimitive(p, nIValues);

        // System.out.println(factors + " " + primeFactors + nIValues + " " + primitiveRoot);
        return primitiveRoot;
    }

    public static ArrayList<Integer> getFactor(int phiP){
        ArrayList<Integer> factors = new ArrayList<>();

        for(int i = 2; i <= phiP; i++){
            if(phiP % i == 0){
                factors.add(i);
            }
        }

        return factors;
    }
    
    public static ArrayList<Integer> getPrimeFactor(ArrayList<Integer> getFactor){
        ArrayList<Integer> primeFactors = new ArrayList<>();

        for(int idx = 0; idx < getFactor.size(); idx++){
            int factor = getFactor.get(idx);
            
            boolean isPrime = true;
            for(int i = 2; i <= Math.sqrt(factor); i++){
                if(factor % i == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                primeFactors.add(factor);
            }
        }

        return primeFactors;
    }

    public static ArrayList<Integer> getNiValue(int phiP, ArrayList<Integer> pi){
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < pi.size(); i++){
            result.add((int)(phiP / pi.get(i)));
        }

        return result;
    }

    public static int getPrimitive(int p, ArrayList<Integer> nIValues){
        ArrayList<Integer> list = new ArrayList<>();
        int primitiveRoot = -1;
        for(int i = 2; i < p; i++){
            boolean isPrimitive = true;
            for(int j = 0; j < nIValues.size(); j++){
                int pow = (int) Math.pow(i, nIValues.get(j));
                int ans =  pow % p;
                if(ans == 1 || list.contains(ans)){
                    list = new ArrayList<>();
                    isPrimitive = false;
                    break;
                }

                list.add(ans);
            }
            if(isPrimitive){
                primitiveRoot = i;
            }
        }

        return primitiveRoot;
    }
}
