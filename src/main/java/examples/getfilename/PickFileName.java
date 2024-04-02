package examples.getfilename;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PickFileName {
    public static void main(String[] args) {

        String path1 = "D:\\IBM\\WebSphere9\\AppServer\\profiles\\AppSrv01\\installedApps\\WOWOWOWO\\JOBJOBJOB.ear\\jobjobjob.war\\WEB-INF\\tmp\\2523ZG000007_20231229175326699_ATTACH.pdf";
        String path2 = "D:\\IBM\\WebSphere9\\AppServer\\profiles\\AppSrv01\\installedApps\\WOWOWOWO\\JOBJOBJOB.ear\\jobjobjob.war\\WEB-INF\\tmp\\AAAAA2523ZG000007_20231229175326699_ATTACH.pdf";

        if(path1.contains("_ATTACH.pdf")){
            System.out.println("It's Attach. You can get file.name");
            System.out.println(filterFileNames(path1));
        }else {
            System.out.println("Not Attach");
            System.out.println(path1);
        }


//        System.out.println(filterFileNames(path1));
//        System.out.println(filterFileNames(path2));
    }

    private static String filterFileNames(String filePath) {
        Path path = FileSystems.getDefault().getPath(filePath);
        System.out.println("path::::"+path);

        String fileName = path.getFileName().toString();
        if (fileName.contains("_ATTACH.pdf")) {
            return fileName;
        }else{
            return "";
        }
    }
}
