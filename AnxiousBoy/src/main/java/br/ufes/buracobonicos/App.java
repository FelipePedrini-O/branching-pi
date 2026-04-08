package br.ufes.buracobonicos;

import java.io.FileReader;
import java.io.Reader;

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

        for (CSVRecord record : records_inp) {
            String entity = record.get("Entity");
            String code = record.get("Code");
            String year = record.get("Year");
            String men = record.get("Men");
            String women = record.get("Women");
            System.out.println(entity + code + year + men + women);
        }

        /* Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
        for (CSVRecord record : records) {
            String columnOne = record.get(0);
            String columnTwo = record.get(1);
        }   */
    }
}
