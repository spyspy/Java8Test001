package examples.tobytearray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StringToByteArray {
    public static void main(String[] args) throws IOException {

        // Email List
        // Use \n to make a newline
        String emailList = "abc@gmail.com\nxyz@gmail.com";

        // String to byteArray
        byte[] targetBytes = createTargetBytes(emailList);

        // byteArray to String
        String str = new String(targetBytes);

        System.out.printf(str);
    }


    // String to byteArray
    private static byte[] createTargetBytes(String target) throws IOException{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] array = target.getBytes(StandardCharsets.UTF_8);
        outputStream.write(array);
        return outputStream.toByteArray();
    }
}
