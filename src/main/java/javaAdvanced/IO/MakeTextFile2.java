package javaAdvanced.IO;

import java.io.*;
import java.nio.file.Files;

public class MakeTextFile2 {
    public static void main(String[] args) {

        System.out.println("RUN.....");
        String content = "AA This is not very good!! the content is wrote in English22222我";
        String fileName ="my_file_test_2.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
//        try (BufferedWriter writer = Files.newBufferedWriter(Paths.of(fileName)));
         {
            writer.write(content);
        }catch (IOException ex) {
            // Report
            ex.printStackTrace();
        }
        System.out.println("RUN.....END");

    }
}
