package br.ufes.buracobonicos;

public class CsvData {
    private String country;
    private Integer year;
    private Double male;
    private Double female;

    public CsvData(String country, Integer year, Double male, Double female) {
        this.country = country;
        this.year = year;
        this.male = male;
        this.female = female;
    }

    public void print() {
        System.out.println(country + " " + year + " " + male + " " + female);
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Double getMale() {
        return male;
    }
    public void setMale(Double male) {
        this.male = male;
    }
    public Double getFemale() {
        return female;
    }
    public void setFemale(Double female) {
        this.female = female;
    }
}
