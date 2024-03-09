package ch05.ex;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.Scanner;

public class One {
    public static void main(String[] varargs){
        try{
            double[] result = new double[1];
            var err = sumValue("src/ch05/ex/num.txt", result);
            if(err == 0){
                System.out.println(result[0]);
            }else{
                System.out.println("An error occured");
            }
        }catch(NumberFormatException e){
            System.out.println("Please recheck the file. All data must be in decimal point number format");
        }catch(IOException e){
            System.out.println("File could not be read for unknown reasons");
        }
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

}
