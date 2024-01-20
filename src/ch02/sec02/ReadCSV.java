package ch02.sec02;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class ReadCSV {
    public static void main(String[] args) throws Exception{
        File csvData = new File("src/ch02/sec02/CSVFile.csv");
        try{
            CSVParser parser = CSVParser.parse(csvData, Charset.defaultCharset(), CSVFormat.RFC4180);
            for(CSVRecord csvRecord: parser ){
                System.out.println(csvRecord.toString());
            }
        }catch(Exception e){
            System.out.println(e.toString());

        }


    }
}
