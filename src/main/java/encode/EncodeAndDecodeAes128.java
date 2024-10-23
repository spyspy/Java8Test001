package encode;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncodeAndDecodeAes128 {
    public static void main(String[] args) {
        try {

            //--------------------------------

            String secretKey = "*****************************"; // Must be exactly 16 characters (128 bits)
            String iv = " ***************************** "; // Must be exactly 16 characters

            // The plaintext message to be encrypted
            String plaintext = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

            // Encrypt the message
            String encryptedText = encrypt(plaintext, secretKey, iv);
            System.out.println("Encrypted Text: " + encryptedText);

            //--------------------------------

            encryptedText = "加密內容";


            String decryptedText = decrypt(encryptedText, secretKey, iv);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String plaintext, String key, String iv) throws Exception {
        // Create a new Cipher instance for AES/CBC/PKCS5Padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Initialize the cipher with the key and IV
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        // Encrypt the plaintext
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));

        // Encode the encrypted bytes to Base64 to get a readable string
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, String secretKey, String iv) throws Exception {
        // Decode the Base64 encoded encrypted text, key, and IV
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] keyBytes = secretKey.getBytes("UTF-8");
        byte[] ivBytes = iv.getBytes("UTF-8");

        // Create SecretKeySpec and IvParameterSpec
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        // Create and initialize the Cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        // Perform the decryption
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, "UTF-8");
    }
}
