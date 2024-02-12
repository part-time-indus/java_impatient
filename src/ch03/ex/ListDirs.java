package ch03.ex;

import java.io.File;
import java.io.FileFilter;

public class ListDirs {

    public static void main(String[] varargs){
        File[] dirs = ListDirs.FetchSubDirsLambdaExp("D:\\documents");
        for(File f:  dirs){
            System.out.println(f.getName());
        }
    }
    public static File[] FetchSubDirsMethodExp(String dirPath){
        File[] subdirs = null;
        File parentDir = new File(dirPath);
        FileFilter filter = File::isDirectory;
        if(parentDir.exists() && parentDir.isDirectory()){
            subdirs = parentDir.listFiles(filter);
        }
        return subdirs;
    }

    public static File[] FetchSubDirsLambdaExp(String dirPath){
        File[] subDirs = null;
        File parentDir = new File(dirPath);
        if(parentDir.exists() && parentDir.isDirectory()) subDirs = parentDir.listFiles((f) -> f.isDirectory());
        return subDirs;
    }
    public static File[] FetchSubDirsAnonCls(String dirPath){
        File[] subDirs = null;
        File parentDir = new File(dirPath);
        if(parentDir.exists() && parentDir.isDirectory()) {
            subDirs = parentDir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory();
                }
            });
        }

        return null;

    }
}
