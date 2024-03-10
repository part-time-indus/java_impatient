package ch05.ex;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.FileHandler;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class One {
    public static void main(String[] varargs){
//        try{
//            double[] result = new double[1];
//            var err = sumValue("src/ch05/ex/num.txt", result);
//            if(err == 0){
//                System.out.println(result[0]);
//            }else{
//                System.out.println("An error occured");
//            }
//        }catch(NumberFormatException e){
//            System.out.println("Please recheck the file. All data must be in decimal point number format");
//        }catch(IOException e){
//            System.out.println("File could not be read for unknown reasons");
//        }

//        System.out.println(factorial(5));
//        Exception ex = new Exception("Random Exception");
//        StackTraceElement[] stackEl = ex.getStackTrace();
//        System.out.println("\nStack trace of the custom exception:");
//        for(StackTraceElement e: stackEl){
//            System.out.println(e.toString());
//        }

        System.out.println(min(new int[]{20, 30, 65, 554, 6, 231, 2}));
    }

    public static int sumValue(String fileName, double[] out)throws IOException{

        ArrayList<Double> values = new ArrayList<>();
        int err = readValue(fileName,values);
        if(err != 0){
            return err;
        }
        double result = 0.0;
        for(Double value: values){
            result = result + value;
        }
        out[0] = result;
        return 0;
    }
    public static int readValue(String filename, ArrayList<Double> out)throws FileNotFoundException, IOException, NullPointerException, NumberFormatException {
        if(out == null){
            out = new ArrayList<Double>();
        }
        if(filename == null){
            return -1;
        }
        File f = new File(filename);
        if(!f.exists() || f.isDirectory()){
            return -2;
        }
        var reader = new FileReader(f);
        var buf = new char[512];
        int charsRead = reader.read(buf);
        StringBuilder word = new StringBuilder();
        while(charsRead != -1){
            for(int i = 0; i < charsRead ; i++){
                var currChar = buf[i];
                var notNum = Character.getType(currChar) != Character.DECIMAL_DIGIT_NUMBER;
                var notDot = currChar != '.';
                if(notNum &&
                        notDot &&
                        currChar != '\r' &&
                        currChar != '\n'
                ){
                    return -3;
                }
                if(currChar == '\n'){
                    var dbl = Double.parseDouble(word.toString());
                    out.add(dbl);
                    word.delete(0, charsRead);
                }

                word.append(buf[i]);
            }
            out.add(Double.parseDouble(word.toString()));
            word.delete(0, charsRead);
            charsRead = reader.read(buf);
        }
        reader.close();
        return 0;
    }

    static public void ScanAndWriteWithException(String src, String dest){
        Scanner in = null;
        PrintWriter out = null;
        try{
            in = new Scanner(Path.of(src));
            out = new PrintWriter(dest);
            try{
                while(in.hasNext()){
                    out.println(in.next().toLowerCase());
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }

        } catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch(IOException ex){
            System.out.println(ex.toString());

        } finally{
            if(in != null){
                try{
                    in.close();
                }catch(IllegalStateException ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(out != null){
                try{
                    out.close();
                }catch(IllegalStateException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public static void ReadFileWithException(String src){
        BufferedReader in = null;
        try{
            in = Files.newBufferedReader(Path.of(src), StandardCharsets.UTF_8);
        }catch(IOException ex){
            System.err.println("Caught IO Exception" + ex.getMessage());
        }finally{
            if(in != null){
                try{
                    in.close();
                }catch(IOException ex){
                    System.err.println(ex.getMessage());
                }
            }
        }
    }
    public static void ReadFileWithException2(String src){
        BufferedReader in = null;
        try{
            try{
                in = Files.newBufferedReader(Path.of(src), StandardCharsets.UTF_8);
            }finally {
                if(in != null){
                    in.close();
                }

            }
        }catch(IOException ex){
            System.err.println("Caught IO Exception" + ex.getMessage());
        }
    }
    public static void ReadFileWithException3(String src){
        try(var in = Files.newBufferedReader(Path.of(src), StandardCharsets.UTF_8);){
            System.out.println(in.readLine());

        }catch(IOException ex){
            System.err.println("Caught IO Exception" + ex.getMessage());
        }
    }

    public static AutoCloseable ReentrantWithCloseable(ReentrantLock r){
        r.lock();
        return new AutoCloseable() {
            @Override
            public void close(){
                r.unlock();
            }
        };

    }

    public static int factorial(int n){
        var result = 0;
        try {
            if (n == 0 || n == 1) {
                System.out.println("Reached the base of this factorial: ");
                return 1;
            }
            System.out.println("Getting the next number in factorial: " + (n-1));
            result = n * factorial(n - 1);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static int min(int[] values){
        int minVal = values[0];
        for(int val: values){
            if(minVal > val){
                minVal = val;
            }
        }
        for (int value : values) {
            assert (minVal < value);
        }
        return minVal;

    }

    public static void FilterRecord(String[] badWords) throws IOException{
        var logger = Logger.getLogger("Whatever");
        var fileHandler = new FileHandler();
        logger.addHandler(fileHandler);
        Filter BadWordsFilter = (LogRecord record) -> {
            boolean result = false;
            var recordStr = record.getMessage();
            if(recordStr != null){
                var recordStrNormalized = recordStr.toLowerCase();
                for(var word: badWords){
                    result = recordStrNormalized.contains(word);
                }
            }
            return result;
        };
        logger.setFilter(BadWordsFilter);



    }

}


