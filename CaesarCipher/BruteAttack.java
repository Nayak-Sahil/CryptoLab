package CryptoLab.CaesarCipher;
public class BruteAttack {
    // ? Brute Force attack on Caesar cipher

    static String systemKey = "sahil";
    public static void main(String[] args) {
        String decrypt = "vdklo";
        int n = decrypt.length();
        String password  = "";
        for (int i = 1; i <= 26; i++) {
            password = "";
            for (int j = 0; j < n; j++) {
                int ascii = decrypt.charAt(j) - 'a';
                // To handle reverse negative circular, it is important to add +26 then %26 with an entire answer ((ascii - i) % 26).
                int encAscii = (((ascii - i) % 26) + 26) % 26; 
                password += (char) (encAscii + 97);
            }
            // System.out.println(password);
            if(system(password)){
                System.out.println("You Hacked it using key: " + i);
                break;
            }
        }
    }

    public static boolean system(String passsword) {
        if (passsword.equals(systemKey))
            return true;

        return false;
    }
}
