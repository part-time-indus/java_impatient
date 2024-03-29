package ch03.ex;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class ListDirs {

    public static void main(String[] varargs){
        File[] dirs = ListDirs.FetchSubDirsMethodExp("C:\\flutter\\flutter");
//        for(File f:  dirs){
//            System.out.println(f.getName());
//        }
        ListDirs.SortFiles(dirs);
        for(File f: dirs){
            System.out.println(f.getAbsolutePath());
        }
    }
    public static File[] FetchSubDirsMethodExp(String dirPath){
        File[] subdirs = null;
        File parentDir = new File(dirPath);
        FileFilter filter = File::isDirectory;
        if(parentDir.exists() && parentDir.isDirectory()){
            subdirs = parentDir.listFiles();
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

    public static File[] FetchFilesWithEx(String dirPath, String fileExt){
        File[] files = null;
        File ParentDir = new File(dirPath);
        if(ParentDir.exists() && ParentDir.isDirectory()){
            files = ParentDir.listFiles((f) -> {
                String name = f.getName();
                int extInd = name.lastIndexOf(".") + 1;
                String ext = name.substring(extInd);
                return f.isFile() && ext.compareToIgnoreCase(fileExt) == 0;
            });
        }
        return files;
    }
    public static void SortFiles(File[] files){
        Arrays.sort(files, (fa, fb) -> {
            if(fa.isDirectory() && fb.isFile()){
                return -1;
            }
            if(fa.isFile() && fb.isDirectory()){
                return 1;
            }
            if((fa.isDirectory() && fb.isDirectory()) || (fa.isFile() && fb.isFile())){
                return fa.getAbsolutePath().length() - fb.getAbsolutePath().length();
            }
            return 0;
        });
    }
}
