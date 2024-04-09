package CryptoLab.Playfair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Playfair {
    // ? Play-fair cipher.
    public static void main(String[] args) {
        String[][] matrix = new String[5][5];
        String Key = "monarchy";

        fillMatrix(matrix, Key);
        printMatrix(matrix);

        String plainText = "rxx";
        // * Encryption:
        ArrayList<ArrayList<Character>> plainPairs = makePair(plainText);
        System.out.println("\nPlainText Pairs: " + plainPairs);

        String cipherText = encrypt(plainText, plainPairs, matrix);
        System.out.println("Cipher Text: " + cipherText);
        
        // * Decryption:
        ArrayList<ArrayList<Character>> cipherPairs = makePair(cipherText);
        System.out.println("\nCipherText Pairs: " + cipherPairs);
        
        String cryptAttackString = decrypt(cipherText, cipherPairs, matrix);
        System.out.println("Plain Text: " + cryptAttackString);
    }

    public static void fillMatrix(String[][] matrix, String key) {
        HashSet<String> set = new HashSet<>();
        int k = 0, idx = 97;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (k == key.length()){
                    // * Fill Remain character (except key's char and already used char)
                    while(idx == 106 || set.contains((char)idx + "")){
                        idx++;
                    }

                    if(idx == 105){
                        String iJ = (char) idx + "/" + ((char)((int)idx + 1));
                        matrix[i][j] = iJ;
                    }else{
                        matrix[i][j] = (char)idx + "";
                    }
                    set.add(matrix[i][j]);
                    idx++;
                }else{
                    // * Fill key's character first
                    if (set.contains(key.charAt(k) + ""))
                        continue;
    
                    matrix[i][j] = key.charAt(k) + "";
                    set.add(matrix[i][j]);
                    k++;
                }
            }
        }

    }

    public static ArrayList<ArrayList<Character>> makePair(String s){
        ArrayList<ArrayList<Character>> pairs = new ArrayList<>();

        int n = s.length();
        int i = 0;
        while(i < n){
            ArrayList<Character> singlePair = new ArrayList<>();
            if(i + 1 == n){
                // * when last just 1 letter remain left. no furthur letter to make pair
                singlePair.add(s.charAt(i));
                if(s.charAt(i) == 'x'){
                    singlePair.add('z');
                }else{
                    singlePair.add('x');
                }
                i++;
            }else if(s.charAt(i) == 'x' && s.charAt(i) == s.charAt(i + 1)){
                System.out.println("#########");
                // * Same contiguous char with 'x' letter
                singlePair.add(s.charAt(i));
                singlePair.add('z');
                i++;
            }else if(s.charAt(i) == s.charAt(i + 1)){
                // * Same contiguous char with any other than 'x' letter 
                singlePair.add(s.charAt(i));
                singlePair.add('x');
                i++;
            }else{
                singlePair.add(s.charAt(i));
                singlePair.add(s.charAt(i + 1));
                i += 2;
            }
            pairs.add(singlePair);
        }

        return pairs;
    }

    public static String encrypt(String s, ArrayList<ArrayList<Character>> pairs, String[][] matrix){
        String cipherText = "";

        for(int i = 0; i < pairs.size(); i++){
            ArrayList<ArrayList<Integer>> rowColOfPairs = findRowCol(pairs.get(i), matrix);
            System.out.println(rowColOfPairs);
            ArrayList<Integer> rowColOfChar1st = rowColOfPairs.get(0);
            ArrayList<Integer> rowColOfChar2nd = rowColOfPairs.get(1);

            if(rowColOfChar1st.get(0) == rowColOfChar2nd.get(0)){
                // ? same row
                cipherText += matrix[rowColOfChar1st.get(0)][(rowColOfChar1st.get(1) + 1) % 5] + "";
                cipherText += matrix[rowColOfChar2nd.get(0)][(rowColOfChar2nd.get(1) + 1) % 5] + "";

            }else if(rowColOfChar1st.get(1) == rowColOfChar2nd.get(1)){
                // ? same column
                cipherText += matrix[(rowColOfChar1st.get(0) + 1) % 5][rowColOfChar1st.get(1)] + "";
                cipherText += matrix[(rowColOfChar2nd.get(0) + 1) % 5][rowColOfChar2nd.get(1)] + "";
            }else{
                // ? neither same row nor same column
                cipherText += matrix[rowColOfChar1st.get(0)][rowColOfChar2nd.get(1)] + "";
                cipherText += matrix[rowColOfChar2nd.get(0)][rowColOfChar1st.get(1)] + "";
            }
        }

        return cipherText;
    }

    public static String decrypt(String s, ArrayList<ArrayList<Character>> pairs, String[][] matrix){
        String plainText = "";

        for(int i = 0; i < pairs.size(); i++){
            ArrayList<ArrayList<Integer>> rowColOfPairs = findRowCol(pairs.get(i), matrix);
            System.out.println(rowColOfPairs);
            ArrayList<Integer> rowColOfChar1st = rowColOfPairs.get(0);
            ArrayList<Integer> rowColOfChar2nd = rowColOfPairs.get(1);

            if(rowColOfChar1st.get(0) == rowColOfChar2nd.get(0)){
                // ? same row
                int idxFrom1stChar = (rowColOfChar1st.get(1) - 1) % 5;
                int idxFrom2ndChar = (rowColOfChar2nd.get(1) - 1) % 5;
                plainText += matrix[rowColOfChar1st.get(0)][(idxFrom1stChar == -1) ? idxFrom1stChar + 5 : idxFrom1stChar] + "";
                plainText += matrix[rowColOfChar2nd.get(0)][(idxFrom2ndChar == -1) ? idxFrom2ndChar + 5 : idxFrom2ndChar] + "";

            }else if(rowColOfChar1st.get(1) == rowColOfChar2nd.get(1)){
                // ? same column
                int idxFrom1stChar = (rowColOfChar1st.get(0) - 1) % 5;
                int idxFrom2ndChar = (rowColOfChar2nd.get(0) - 1) % 5;
                plainText += matrix[(idxFrom1stChar == -1) ? idxFrom1stChar + 5 : idxFrom1stChar][rowColOfChar1st.get(1)] + "";
                plainText += matrix[(idxFrom2ndChar == -1) ? idxFrom2ndChar + 5 : idxFrom2ndChar][rowColOfChar2nd.get(1)] + "";
            }else{
                // ? neither same row nor same column
                plainText += matrix[rowColOfChar1st.get(0)][rowColOfChar2nd.get(1)] + "";
                plainText += matrix[rowColOfChar2nd.get(0)][rowColOfChar1st.get(1)] + "";
            }
        }

        return plainText;
    }

    public static ArrayList<ArrayList<Integer>> findRowCol(ArrayList<Character> pair, String[][] matrix){
        ArrayList<ArrayList<Integer>> rowCol = new ArrayList<>();
        
        for(int k = 0; k < pair.size(); k++){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if(pair.get(k).toString().equals("i") || pair.get(k).toString().equals("j")){
                        if(matrix[i][j].equals("i/j")){
                            rowCol.add(new ArrayList<>(Arrays.asList(i, j)));
                        }
                    }else if(pair.get(k).toString().equals(matrix[i][j])){
                        rowCol.add(new ArrayList<>(Arrays.asList(i, j)));
                    }
                }
            }
        }
        
        return rowCol;
    }

    public static void printMatrix(String[][] matrix) {
        System.out.println("5 X 5 Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println("");
        }
    }
}
