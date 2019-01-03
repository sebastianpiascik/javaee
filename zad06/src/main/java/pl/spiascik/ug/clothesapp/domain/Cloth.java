package pl.spiascik.ug.clothesapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@NamedQueries({
        @NamedQuery(name = "cloth.all", query = "Select c from Cloth c"),
        @NamedQuery(name = "cloth.byId", query = "Select c from Cloth c where c.id = :id"),
        @NamedQuery(name = "cloth.deleteAll", query="Delete from Cloth")
//        @NamedQuery(name = "cloth.clothWearers", query="Select w.name from Wearer where ")
})
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date productionDate;
    private double price;
    private boolean isWaterproof;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Wearer_Cloth",
            joinColumns = { @JoinColumn(name = "wearer_id") },
            inverseJoinColumns = { @JoinColumn(name = "cloth_id") }
    )
    private Set<Wearer> wearers = new HashSet<Wearer>();
    @ManyToOne(cascade = {CascadeType.ALL})
    private Type type;

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

    public Set<Wearer> getWearers() {
        return wearers;
    }

    public void setWearers(Set<Wearer> wearers) {
        this.wearers = wearers;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getId() + ". " + this.getName() +
                ", data: " + this.getProductionDate().toString() +
                ", cena: " + this.getPrice() +
                ", wodoodporność: " + this.isWaterproof();
    }

}

