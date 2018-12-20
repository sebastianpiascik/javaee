package pl.spiascik.ug.store.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chocolate {

    private int id;
    private String name;
    private Date productionDate;
    private double price;
    private boolean isWhite;
    private boolean isBlack;

    public Chocolate(int id, String name, String productionDate, double price, boolean isWhite, boolean isBlack) throws ParseException {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isWhite = isWhite;
        this.isBlack = isBlack;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.productionDate = new java.sql.Date(dateFormat.parse(productionDate).getTime());
    }

    public Chocolate() {
        super();
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

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }


}

