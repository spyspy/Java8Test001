package file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class JavaFileTest001 {
    public static void main(String[] args) throws IOException {
        // Create File
        String FILE_NAME = "FILE002.txt";
        File targetFile = new File(FILE_NAME);
        boolean success = targetFile.createNewFile();
        System.out.println("success: " + success);
        FileUtils.writeStringToFile(targetFile, "TestBABY", "utf-8");


        // Turn file to Base64
        byte[] fileContent = FileUtils.readFileToByteArray(targetFile);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        System.out.println("encodedString Base64: " + encodedString);

        // Turn base64 to byte[]
        String originalInput = encodedString;
        byte[] result = Base64.getDecoder().decode(originalInput);
        System.out.println("result: " + result);

        // Turn byte[] to a new File (應該與原始的檔案內容一致)
        File file2 = new File("NewFile2.txt");
        boolean success2 = file2.createNewFile();
        System.out.println("success2: " + success2);

        FileUtils.writeByteArrayToFile(file2, result);

//        https://www.baeldung.com/java-write-byte-array-file

    }
}
