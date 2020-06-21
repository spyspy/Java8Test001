package javaAdvanced;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class BinaryArrayToBase64String {

    public static void main(String[] args) {

        try {

            // convert file to byte[]
            //byte[] bFile = readBytesFromFile("C:\\temp\\wow.pdf");
            byte[] bFile = readBytesFromFile("C:\\temp\\test-image.jpg");

            //java nio
            //byte[] bFile = Files.readAllBytes(new File("C:\\temp\\testing1.txt").toPath());
            //byte[] bFile = Files.readAllBytes(Paths.get("C:\\temp\\testing1.txt"));

            // save byte[] into a file
            Path path = Paths.get("C:\\temp\\abc3.txt");
            Files.write(path, bFile);

            System.out.println("Save File Done");

            final Base64.Decoder decoder = Base64.getDecoder();
            final Base64.Encoder encoder = Base64.getEncoder();
            final String text = "字串文字";
            final byte[] textByte = text.getBytes("UTF-8");
            //編碼
            final String encodedText = encoder.encodeToString(bFile);
            System.out.println("Encoded Text:");
            System.out.println(encodedText);
            //解碼
            //System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
            decoder.decode(encodedText);

            //解碼輸出
            Path path2 = Paths.get("C:\\temp\\abc3.jpg");
            Files.write(path2, decoder.decode(encodedText));

            //Print bytes[]
//            for (int i = 0; i < bFile.length; i++) {
//                System.out.print((char) bFile[i]);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }

}