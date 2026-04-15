package br.ufes.buracobonicos;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        String path = "/home-temp/aluno/branching-pi/AnxiousBoy/csv/file.csv"; 
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

        Comparator<CsvData> femaleComparator = (d1, d2) -> Double.compare(d2.getFemale(), d1.getFemale());

        CsvList.sort(femaleComparator);

        for(CsvData data : CsvList) {
            data.print();
        }

        /* Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
        for (CSVRecord record : records) {
            String columnOne = record.get(0);
            String columnTwo = record.get(1);
        }   */
    }
}
