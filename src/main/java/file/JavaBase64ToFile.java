package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class JavaBase64ToFile {
    public static void main(String[] args) throws IOException {


        // Specify the path to the text file containing Base64 content
        File inputFile = new File("pdf.txt");

        // Specify the path to output the PDF file
        File outputFile = new File("output.pdf");




        // Base64 encoded string (replace this with your Base64 string)
        String base64EncodedString = "your_base64_string_here";

        // Step 1: Read the Base64 content from text.txt
        String base64Content = new String(Files.readAllBytes(inputFile.toPath()));
        base64EncodedString = base64Content;

        // Specify the file path where the decoded file should be saved
//        File outputFile = new File("CAT.png");

        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            // Decode the Base64 string back to bytes
            byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedString);

            // Write the decoded bytes to the file
            fos.write(decodedBytes);

            System.out.println("File successfully written: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
