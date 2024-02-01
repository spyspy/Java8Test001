package examples.getfilename;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileNameFilter {
    public static void main(String[] args) {
        List<String> filePaths = new ArrayList<>();
        filePaths.add("C:/wow/wow/abc/xyz/kokoko/temp/ABC1988_20240124989898_BOYO.pdf");
        filePaths.add("C:/wow/wow/abc/xyz/kokoko/temp/WOWXYA_20240124987777_BOYO.pdf");
        filePaths.add("C:/wow/wow/abc/xyz/kokoko/temp/WOWXYA_20240124984545.pdf");

        // Step 1: Filter filenames with "_BOYO.pdf"
        List<String> filteredFileNames = filterFileNames(filePaths);

        // Step 2: Extract filenames without path
        List<String> fileNamesWithoutPath = extractFileNames(filteredFileNames);

        // Display the results
        System.out.println("Filtered File Names: " + filteredFileNames);
        System.out.println("File Names without Path: " + fileNamesWithoutPath);
    }

    private static List<String> filterFileNames(List<String> filePaths) {
        List<String> filteredFileNames = new ArrayList<>();
        for (String filePath : filePaths) {
            Path path = FileSystems.getDefault().getPath(filePath);
            String fileName = path.getFileName().toString();
            if (fileName.contains("_BOYO.pdf")) {
                filteredFileNames.add(fileName);
            }
        }
        return filteredFileNames;
    }

    private static List<String> extractFileNames(List<String> filePaths) {
        List<String> fileNamesWithoutPath = new ArrayList<>();
        for (String filePath : filePaths) {
            Path path = FileSystems.getDefault().getPath(filePath);
            String fileName = path.getFileName().toString();
            fileNamesWithoutPath.add(fileName);
        }
        return fileNamesWithoutPath;
    }
}