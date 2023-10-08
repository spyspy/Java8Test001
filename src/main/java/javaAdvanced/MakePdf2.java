package javaAdvanced;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Base64;
import java.util.List;

public class MakePdf2 {

    public static void main(String[] args) {
        try {
            //For Java 8 Date Time
            LocalDate localdate = LocalDate.now();
            LocalTime localtime = LocalTime.now();
            LocalDateTime localDatetime = LocalDateTime.now();
            System.out.println(localdate.toString());
            System.out.println(localtime.toString());
            System.out.println("O:" + localDatetime.toString());

            //Original :2019-09-19T13:44:49.806
            //Changed  :2019-09-19T13_44_49_806
            String localDateTimeStr = localDatetime.toString().replaceAll("[.:]", "_");
            System.out.println("R:" + localDateTimeStr);
            //Destination Path of PDF
            String filepath = "D://test" + localDateTimeStr + ".pdf";

            //Source of base64 encoding PDF
            //C:\XXXXX\OOOOO\TestProject\doc\pdf-source.txt
            String base64String = "";
            Path path = Paths.get("C:/XXXXX/OOOOO/TestProject/doc/", "pdf-source.txt");
            Charset charset = Charset.forName("UTF-8");
            List<String> lines = Files.readAllLines(path, charset);
            for (String line : lines) {
                base64String += line;
            }

            FileOutputStream fos = new FileOutputStream(filepath);
            fos.write(Base64.getDecoder().decode(base64String));
            fos.close();
            //If no error.....
            System.out.println("Successfully make pdf!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}
