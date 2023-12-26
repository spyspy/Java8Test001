package javaAdvanced.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MakeStringToFile {
    public static void main(String[] args) {
        {

            System.out.println("MakeStringToFile RUN.....");
            String content = "gogobabegogobabegogobabegogobabegogobabe我想吃";
            String fileName = "gogobabe.txt";

            try (Writer writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(content);
            } catch (IOException ex) {
                // Report
                ex.printStackTrace();
            }
            System.out.println("MakeStringToFile RUN.....END");

        }

    }
}
