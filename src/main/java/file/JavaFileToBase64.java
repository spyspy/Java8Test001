package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class JavaFileToBase64 {
    public static void main(String[] args) {
        // Specify the file path
        File file = new File("path/to/your/file");

        try {
            // Read file content as bytes
            byte[] fileContent = Files.readAllBytes(file.toPath());

            // Encode file bytes to Base64
            String encodedString = Base64.getEncoder().encodeToString(fileContent);

            // Output the encoded string
            System.out.println("Base64 Encoded String: " + encodedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
