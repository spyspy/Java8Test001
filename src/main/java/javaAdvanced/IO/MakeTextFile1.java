package javaAdvanced.IO;

import java.io.*;

public class MakeTextFile1 {
    public static void main(String[] args) {

        System.out.println("RUN.....");
        String content = "AA This is not very good!! the content is wrote in English";
        String fileName ="my_file_test1.txt";

        // 使用 BufferedWriter ==> OutputStreamWriter ==> FileOutputStream
        // 使用 OutputStream 才能設定 encoding?
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                // 如果沒有資料夾會掛掉
//                new FileOutputStream("c:/awow/wfilename.txt"), "utf-8"))) {
                // 直接寫檔案名稱，產生再專案內部
                // C:\xcode\Java8Test001\wfilename.txt
                new FileOutputStream(fileName), "utf-8")))
        {
            writer.write(content);
        }catch (IOException ex) {
            // Report
            ex.printStackTrace();
        }
        System.out.println("RUN.....END");

    }
}
