public class Cipher {
    
    final String plaintextAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Plaintext
// Alphabet
private String keyword; // The Secret Keyword
private String ciphertextAlphabet; // Ciphertext Alphabet

/**
 * Class constructor initializes the keyword and creates the Ciphertext Alphabet
 * 
 * @param key the secret keyword used to create the ciphertext alphabet
 */
public Cipher(String key) {
    keyword = key;
    ciphertextAlphabet = initCiphertextAlphabet();
}

/**
 * removes all duplicate occurrences of characters from a String
 * 
 * @param s String with duplicate occurrences of characters
 * @return String with no duplicate characters in it
 */
public static String removeDups(String s) {
    
    char tmp;
    String result = "";

    for (int i=0; i < s.length(); i++){
        tmp = s.charAt(i);
        String str = String.valueOf(tmp);
        if(result.contains(str) == false) result += str;
    }
    return result;
}

/**
 * generates the ciphertext alphabet from the keyword
 * 
 * @return String of ciphertext alphabet generated from the keyword
 */
public String initCiphertextAlphabet() {

    String tmp = keyword.toUpperCase();
    tmp = tmp.concat(plaintextAlphabet);
    tmp = removeDups(tmp);
    return tmp;

}

/**
 * Encrypts a message in plaintext
 * 
 * @param message the message to be encrypted in ciphertext alphabet
 * @return the encrypted message in ciphertext alphabet
 */
public String encrypt(String message) {

    String tmp= "";
    message = message.toUpperCase();
    for (int i=0; i < message.length(); i++){
        if( plaintextAlphabet.contains(String.valueOf(message.charAt(i))) == false )
        tmp += message.charAt(i);
        else {
            int j = plaintextAlphabet.indexOf(message.charAt(i));
        tmp += ciphertextAlphabet.charAt(j);
        }
    }
    return tmp;
}

/**
 * Encrypts a message in plaintext
 * 
 * @param ciphertext ciphertext in ciphertext alphabet
 * @return the decrypted message in plaintext alphabet
 */
public String decrypt(String ciphertext) {

    String tmp= "";
    ciphertext = ciphertext.toUpperCase();
    for (int i=0; i < ciphertext.length(); i++){
        if( ciphertextAlphabet.contains(String.valueOf(ciphertext.charAt(i))) == false )
        tmp += ciphertext.charAt(i);
        else {
            int j = ciphertextAlphabet.indexOf(ciphertext.charAt(i));
        tmp += plaintextAlphabet.charAt(j);
        }
    }
    return tmp;

}
    public static void main(String[] args) {

        String key ="sado";
        Cipher cip = new Cipher(key);
        System.out.println(cip.encrypt(""));
    }
}
