package CryptoLab.MonoAlphabetic;
public class MonoAlpha {
    // ? Mono-alphabetic cipher
    public static void main(String[] args) {
        char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

        char[] codes = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
        'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K',
        'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };

        String plainText = "hello";
        String cipherText = encrypt(plainText, letters, codes);
        System.out.println("Cipher Text: " + cipherText);
        String cryptAttack = decrypt(cipherText, letters, codes);
        System.out.println("Plain Text: " + cryptAttack);
    }

    public static String encrypt(String plainText, char[] letters, char[] codes){
        String encryptedText = "";
        
        for(int j = 0; j < plainText.length(); j++){
            for(int i = 0; i < letters.length; i++){
                if(plainText.charAt(j) == letters[i]){
                    encryptedText += codes[i];
                    break;
                }
            }
        }

        return encryptedText;
    }

    public static String decrypt(String cipherText, char[] letters, char[] codes){
        String decryptedText = "";
        
        for(int j = 0; j < cipherText.length(); j++){
            for(int i = 0; i < codes.length; i++){
                if(cipherText.charAt(j) == codes[i]){
                    decryptedText += letters[i];
                    break;
                }
            }
        }

        return decryptedText;
    }
}
