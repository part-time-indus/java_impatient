package ch05.ex;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class One {
    public static void main(String[] varargs){
        try{
            var result = readValue("src/ch05/ex/num.txt");
            System.out.println(sumValue(result));
        }catch(Exception e){
            System.out.println("Error "+ e.toString());
        }
    }

    public static double sumValue(ArrayList<Double> values){
        double result = 0.0;
        for(Double value: values){
            result = result + value;
        }
        return result;
    }
    public static ArrayList<Double> readValue(String filename)throws IOException, NullPointerException, NumberFormatException {
        File f = new File(filename);
        ArrayList<Double> result = new ArrayList<Double>();

        try(FileReader reader = new FileReader(f)){
            var buf = new char[512];
            int charsRead = reader.read(buf);
            StringBuilder word = new StringBuilder();
            while(charsRead != -1){
                for(int i = 0; i < charsRead ; i++){
                    if(buf[i] == '\n'){
                        var dbl = Double.parseDouble(word.toString());
                        result.add(dbl);
                        word.delete(0, charsRead);
                    }
                    word.append(buf[i]);
                }
                result.add(Double.parseDouble(word.toString()));
                word.delete(0, charsRead);
                charsRead = reader.read(buf);
            }

        }catch(FileNotFoundException ex){
            System.out.println(ex.toString());
        }
         return result;
    }
}
