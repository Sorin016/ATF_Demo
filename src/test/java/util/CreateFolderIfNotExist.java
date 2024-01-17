package util;

import java.io.File;

public class CreateFolderIfNotExist {
    public static void createDirectoryIfNotExists(String filePath){
        File f=new File(filePath);
        f.mkdir();
    }
}
