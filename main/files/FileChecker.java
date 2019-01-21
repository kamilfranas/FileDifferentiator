package main.files;

import java.io.File;

public class FileChecker {

    public static boolean checkFile(String filePath){
        if(filePath == null) return false;
        File file = new File(filePath);
        return file.exists() && !file.isDirectory() && file.isFile() && file.canRead();
    }
}
