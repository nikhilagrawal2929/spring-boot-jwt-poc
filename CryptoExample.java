import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CryptoExample {

    public static void main(String[] args) throws Exception {
        String encryptedText = "your_encrypted_string_here";
        String key = "your_key_here";

        // Decode the Base64-encoded key
        byte[] decodedKey = Base64.getDecoder().decode(key);

        // Create a SecretKeySpec from the key
        SecretKeySpec secretKeySpec = new SecretKeySpec(decodedKey, "AES");

        // Initialize the Cipher with the key and the algorithm
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        // Decode the Base64-encoded encrypted text
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);

        // Decrypt the text
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Convert the decrypted bytes to a String
        String decryptedText = new String(decryptedBytes);

        System.out.println("Decrypted Text: " + decryptedText);
    }
}
