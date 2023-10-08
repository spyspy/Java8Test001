package encode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SaltedHashExample {
    public static void main(String[] args) {
        String password = "mySecretPassword"; // Replace with the user's password

        try {
            // Generate a random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Combine the salt and password
            byte[] saltedPassword = new byte[salt.length + password.length()];
            System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
            System.arraycopy(password.getBytes(), 0, saltedPassword, salt.length, password.length());

            // Calculate the salted SHA-256 hash
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = sha256.digest(saltedPassword);

            // Convert the hash and salt to Base64 or hexadecimal strings for storage
            String saltBase64 = Base64.getEncoder().encodeToString(salt);
            String hashBase64 = Base64.getEncoder().encodeToString(hashBytes);

            // Store the salt and hash in the database
            System.out.println("Salt (Base64): " + saltBase64);
            System.out.println("Hash (Base64): " + hashBase64);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
