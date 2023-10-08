package javaAdvanced;

import java.io.FileOutputStream;
import java.util.Base64;

public class MakePdf {
    public static void main(String[] args) {

        try {
            //How to make pdf from base64
            String filePath = "c://xcode//test.pdf";
            String base64String = "";
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(Base64.getDecoder().decode(base64String));
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
