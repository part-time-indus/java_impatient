package ch03.ex;

import java.io.File;
import java.io.FileFilter;

public class ListDirs {
    public static File[] FetchSubDirs(String dirPath){
        File[] subdirs = null;
        File parentDir = new File(dirPath);
        FileFilter filter = File::isDirectory;
        if(parentDir.exists() && parentDir.isDirectory()){
            subdirs = parentDir.listFiles(filter);
        }
        return subdirs;
    }
}
