package javaAdvanced.IO;

import java.io.*;

public class MakeTextFile {
    public static void main(String[] args) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("c:/wow/wfilename.txt"), "utf-8"))) {
            writer.write("something");
        }catch (IOException ex) {
            // Report
            ex.printStackTrace();
        }
    }
}
