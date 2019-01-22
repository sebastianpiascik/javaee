package pl.spiascik.ug.clothesapp.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@NamedQueries({
        @NamedQuery(name = "cloth.all", query = "Select c.id, c.name, c.price, c.productionDate, c.isWaterproof, c.type.name, c.fabric.name from Cloth c"),
        @NamedQuery(name = "cloth.byId", query = "Select c.id, c.name, c.price, c.productionDate, c.isWaterproof, c.type.name, c.fabric.name from Cloth c where c.id = :id"),
        @NamedQuery(name = "cloth.deleteAll", query="Delete from Cloth"),
        @NamedQuery(name = "cloth.byType", query="SELECT c.id, c.name, c.price, c.productionDate, c.isWaterproof, c.type.name, c.fabric.name FROM Cloth c WHERE c.type.id = :id"),
        @NamedQuery(name = "cloth.allWearers", query="SELECT w FROM Wearer w JOIN w.clothes c WHERE c.id = :id"),
        @NamedQuery(name = "cloth.addWearer", query="SELECT w FROM Wearer w JOIN w.clothes c WHERE c.id = :id")
})
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date productionDate;
    private double price;
    private boolean isWaterproof;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "cloth_wearer",
            joinColumns = { @JoinColumn(name = "cloth_id") },
            inverseJoinColumns = { @JoinColumn(name = "wearer_id") }
    )
    private Collection<Wearer> wearers = new ArrayList<Wearer>();
    @ManyToOne(cascade = {CascadeType.ALL})
    private Type type;

    @OneToOne(cascade = {CascadeType.ALL})
    private Fabric fabric;

    public Cloth(String name, String productionDate, double price, boolean isWaterproof, Type type, Fabric fabric) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.name = name;
        this.productionDate = new Date(dateFormat.parse(productionDate).getTime());
        this.price = price;
        this.isWaterproof = isWaterproof;
        this.type = type;
        this.fabric = fabric;
    }

    public Cloth(String name, String productionDate, double price, boolean isWaterproof, Type type) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.name = name;
        this.productionDate = new Date(dateFormat.parse(productionDate).getTime());
        this.price = price;
        this.isWaterproof = isWaterproof;
        this.type = type;
    }

    public Cloth(String name, String productionDate, double price, boolean isWaterproof) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.name = name;
        this.productionDate = new Date(dateFormat.parse(productionDate).getTime());
        this.price = price;
        this.isWaterproof = isWaterproof;
    }

    public Cloth(String name, String productionDate, double price) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.name = name;
        this.productionDate = new Date(dateFormat.parse(productionDate).getTime());
        this.price = price;
    }

    public Cloth() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Collection<Wearer> getWearers() {
        return wearers;
    }

    public void setWearers(Collection<Wearer> wearers) {
        this.wearers = wearers;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return this.getId() + ". " + this.getName() +
                ", data: " + this.getProductionDate().toString() +
                ", cena: " + this.getPrice() +
                ", wodoodporność: " + this.isWaterproof();
    }

}

