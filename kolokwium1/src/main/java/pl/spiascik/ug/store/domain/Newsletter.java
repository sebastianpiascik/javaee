package pl.spiascik.ug.store.domain;

public class Newsletter {

    private int id;
    private String name;
    private String dateFrom;
    private String dateTo;
    private String frequency;
    private boolean subject1;
    private boolean subject2;

    public Newsletter(String name, String dateFrom, String dateTo, String frequency, boolean subject1, boolean subject2){
        this.name = name;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.frequency = frequency;
        this.subject1 = subject1;
        this.subject2 = subject2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isSubject1() {
        return subject1;
    }

    public void setSubject1(boolean subject1) {
        this.subject1 = subject1;
    }

    public boolean isSubject2() {
        return subject2;
    }

    public void setSubject2(boolean subject2) {
        this.subject2 = subject2;
    }
}
