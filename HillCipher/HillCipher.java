package CryptoLab.HillCipher;
import java.util.ArrayList;

public class HillCipher {
    public static void main(String[] args) {
        // ? Hill Cipher
        int[][] key = {{2, 3}, {3, 6}}; // * It will be always square matrix.

        String plainText = "attack";

        // ? just pass key.length (total no. of rows) because if there are n-no.of row then n-no.of column exist
        System.out.println("Plain Text: " + plainText);

        ArrayList<ArrayList<Integer>> plainVector = makeVector(plainText, key.length);
        System.out.println("Plain Vector of (N x 1) size: " + plainVector);
        
        ArrayList<ArrayList<Integer>> cipherVector = encrypt(plainVector, key);
        System.out.println("Cipher Vector of (N x 1) size: " + cipherVector);

        String cipherText = makeString(cipherVector);
        System.out.println("Cipher Text: " + cipherText);
    }

    public static ArrayList<ArrayList<Integer>> makeVector(String s, int n){
        // ! If key is of N x N sized matrix then we have to make N x 1 sized vector.

        ArrayList<ArrayList<Integer>> allVectors = new ArrayList<>();

        int sSize = s.length();
        ArrayList<Integer> vec = new ArrayList<>();
        int x = 0; // * A Point to reset.
        for(int i = 0; i < sSize; i++){
            int ascii = s.charAt(i);
            if(x == n - 1 || i == sSize - 1){
                vec.add(ascii - 97);
                allVectors.add(vec); // adding vector
                vec = new ArrayList<>(); // reset vector
                x = 0; // * A Point to reset.
            }else{
                vec.add(ascii - 97);
                x++; // * A Point to reset.
            }
        }

        //* for remain unfilled place: Padding extra letter 'x' to make complete (n x 1) vector
        for(int i = allVectors.get(allVectors.size() - 1).size(); i < n; i++){
            allVectors.get(allVectors.size() - 1).add('x' - 97);
        }

        return allVectors;
    }

    public static ArrayList<ArrayList<Integer>> encrypt(ArrayList<ArrayList<Integer>> vector, int[][] key){
        ArrayList<ArrayList<Integer>> cipherVector = new ArrayList<>();

        for(int i = 0; i < vector.size(); i++){
            // * for every plainText vector we have to perform following things:
            // * C = Key * Vector % 26
            ArrayList<Integer> finalVector = kpmod26(vector.get(i), key); 
            cipherVector.add(finalVector);
        }

        return cipherVector;
    }

    public static ArrayList<Integer> kpmod26(ArrayList<Integer> vect, int[][] matrix){
        ArrayList<Integer> finalVec = new ArrayList<>();

        int n = matrix.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += matrix[i][j] * vect.get(j) % 26;
            }
            finalVec.add(sum);
        }

        return finalVec;
    }

    public static String makeString(ArrayList<ArrayList<Integer>> vec){
        String text = "";

        for(int i = 0; i < vec.size(); i++){
            for(int j = 0; j < vec.get(0).size(); j++){
                int ascii = vec.get(i).get(j) + 97;
                text += (char) ascii;
            }
        }
        
        return text;
    }
}
