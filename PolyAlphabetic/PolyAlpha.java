package CryptoLab.PolyAlphabetic;
public class PolyAlpha {
    public static void main(String[] args) {
        // ? Poly-Alphabetic Cipher
        // * Here we are using "One Time Pad" technique.
        // ! Remember that in this technique,  key_size should <= plaintext_size
        String plainText = "Hi Hello How are you?";
        String baseKey = "ksz";
        
        System.out.println("# Plain Text: " + plainText);
        System.out.println("# Base Key: " + baseKey);
        
        String finalKey = "";
        if(baseKey.length() > plainText.length()){
            finalKey = makeSmallKey(baseKey, plainText.length());
        }else{
            finalKey = makeLargeKey(baseKey, plainText.length());
        }
        
        System.out.println("# Final Key: " + finalKey);
        
        String cipherText = encrypt(plainText, finalKey);
        System.out.println("# Cipher Text: " + cipherText);

        String cryptAttackString = decrypt(plainText, finalKey);
        System.out.println("# Plain Text: " + cryptAttackString);
    }

    public static String makeSmallKey(String baseKey, int n){
        return baseKey.substring(0, n);
    }

    public static String makeLargeKey(String baseKey, int n){
        String finalKey = baseKey;
        int baseKeyLength = baseKey.length();

        int charIdx = 0;
        for(int i = baseKeyLength; i < n; i++){
            if(charIdx == baseKeyLength) charIdx = 0;
            finalKey += baseKey.charAt(charIdx);
            charIdx += 1;
        }

        return finalKey;
    }

    public static String encrypt(String s, String key){
        String cipherText = "";

        int n = s.length();

        for(int i = 0; i < n; i++){
            // ? PlainText letter i = pI, Key letter i =  kI, CipherText letter i = cI;

            int pI = s.charAt(i) - 97;
            int kI = key.charAt(i) - 97;

            int cI = pI + kI;

            if(cI > 26) cI -= 26;

            cipherText += (char) (cI + 97);
        }

        return cipherText;
    }
        
    public static String decrypt(String s, String key){
        String plainText = "";

        int n = s.length();

        for(int i = 0; i < n; i++){
            // ? PlainText letter i = pI, Key letter i =  kI, CipherText letter i = cI;

            int cI = s.charAt(i) - 97;
            int kI = key.charAt(i) - 97;

            int pI = Math.abs(cI - kI);

            plainText += (char) (cI + 97);
        }

        return plainText;
    }
}
