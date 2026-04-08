package br.ufes.buracobonicos;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        String path = "/home/fpoliveira/branching-pi/AnxiousBoy/female-and-male-life-expectancy-at-birth-in-years/female-and-male-life-expectancy-at-birth-in-years.csv"; 
        Reader in = new FileReader(path);
        Iterable<CSVRecord> records_inp = CSVFormat.RFC4180.builder()
        .setHeader()
        .setSkipHeaderRecord(true)
        .build()
        .parse(in);

        ArrayList<CsvData> CsvList = new ArrayList<>();

        for (CSVRecord record : records_inp) {
            //String entity = record.get("Entity");
            Integer year = Integer.parseInt(record.get("Year"));
            if(year != 2020) continue;

            String code = record.get("Code");
            Double male = Double.parseDouble(record.get("Men"));
            Double female = Double.parseDouble(record.get("Women"));

            CsvList.add(new CsvData(code, year, male, female));
        }

        for(CsvData data : CsvList) {
            System.err.println(data);
        }

        /* Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
        for (CSVRecord record : records) {
            String columnOne = record.get(0);
            String columnTwo = record.get(1);
        }   */
    }
}
