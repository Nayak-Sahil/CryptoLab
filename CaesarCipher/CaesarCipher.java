package CryptoLab.CaesarCipher;
public class CaesarCipher{
    // ? Caesar cipher
    public static void main(String[] args) {
        String text = "sahil";
        int key = 3;

        // for encryption;
        String encText = ceaser(text, key);
        System.out.println(encText);
        
        // for descryption:
        String decText = ceaser(encText, -key);
        System.out.println(decText);        
    }

    // ! This function will going to encrypt the plain text and decrypt text as well.
    public static String ceaser(String text, int key){
        int n = text.length();
        
        String encText = "";
        
        int base = 97;
        for(int i = 0; i < n; i++){
           int ascii = text.charAt(i) - 'a'; // when plaintext is in small letter then subtract 'a' otherwise 'A'
           int encAscii = (((ascii + key) % 26) + 26) % 26; // To handle reverse negative circular, it is important to add +26 then %26 with an entire answer.
           encText += (char) (encAscii + base);
        }
        
        return encText;
    }
}
