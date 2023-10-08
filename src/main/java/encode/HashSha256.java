package encode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashSha256 {
    public static String sha256(String input) {
        try {
            // Create an SHA-256 message digest instance
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

            // Calculate the SHA-256 hash of the input string
            byte[] hashBytes = sha256.digest(input.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                // Convert each byte to a two-digit hexadecimal representation
                String hex = String.format("%02x", hashByte);
                hexString.append(hex);
            }

            // Return the SHA-256 hash as a hexadecimal string
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
//        String input = "Hello, World!"; // Replace with the string you want to hash
        String input = "password1"; // Replace with the string you want to hash
        // SHA-256 Hash: dffd6021bb2bd5b0af676290809ec3a53191dd81c7f70a4b28688a362182986f
        String sha256Hash = sha256(input);
        System.out.println("SHA-256 Hash: " + sha256Hash);
    }
}