package pl.spiascik.ug.store.domain;

import java.util.Date;

public class Cloth {

    private int id;
    private String name;
    private Date productionDate;
    private double price;
    private boolean isWaterproof;


    public Cloth(String name, Date productionDate, double price, boolean isWaterproof) {
        this.name = name;
        this.productionDate = productionDate;
        this.price = price;
        this.isWaterproof = isWaterproof;
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

    public boolean isWaterproof() {
        return isWaterproof;
    }

    public void setWaterproof(boolean waterproof) {
        isWaterproof = waterproof;
    }

}

