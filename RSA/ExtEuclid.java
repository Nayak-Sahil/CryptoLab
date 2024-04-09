package CryptoLab.RSA;
import java.util.ArrayList;

public class ExtEuclid {
    public static void main(String[] args) {
        // ? Extended Euclidean Algorithm:
        int prime_1 = 3;
        int prime_2 = 5;

        // ! Since we have to select A > B from these prime number;
        // * Initially Required Parameters are as follow:
        /**
         * ? A and B prime number, 
         * ? Q - Quotient,
         * ? R - Remainder,
         * * To find just Multiplicative inverse under modulo T is used but To find two coefficient then we required T and S as well.
         * ? T1 and T2
         * ? T - T1 - T2 * Q
         * 
        */
        int A, B;
        if(prime_1 > prime_2){
            A = prime_1;
            B = prime_2;
        }else{
            A = prime_2;
            B = prime_1;
        }

        int T1 = 0;
        int T2 = 1;
        int Q = A / B;
        int R = A % B;
        int T = T1 - T2 * Q;

        ArrayList<Integer> ans = new ArrayList<>();
        extendedEuclidean(A, B, Q, R, T1, T2, T, ans);
        System.out.println(ans);
    }

    public static void extendedEuclidean(int A, int B, int Q, int R, int T1, int T2, int T, ArrayList<Integer> ans){
        if(R == 0){
            ans.add(B); // G.C.D
            ans.add(T2); // Multiplicative Inverse of A % B. 
            return;
        }

        A = B;
        B = R;
        T1 = T2;
        T2 = T;
        Q = A / B;
        R =  A % B;
        T = T1 - T2 * Q;
        extendedEuclidean(A, B, Q, R, T1, T2, T, ans);
    }
}
