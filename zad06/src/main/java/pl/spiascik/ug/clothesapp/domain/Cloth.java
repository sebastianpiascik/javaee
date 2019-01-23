package pl.spiascik.ug.clothesapp.domain;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@NamedQueries({
        @NamedQuery(name = "cloth.all", query = "Select c from Cloth c JOIN fetch c.type ct JOIN fetch c.manufacturer"),
        @NamedQuery(name = "cloth.byId", query = "Select c from Cloth c JOIN fetch c.type ct JOIN fetch c.manufacturer cm where c.id = :id"),
        @NamedQuery(name = "cloth.deleteAll", query="Delete from Cloth"),
        @NamedQuery(name = "cloth.deleteCloth", query="Delete from Cloth c WHERE c.id = :id"),
        @NamedQuery(name = "cloth.deleteClothesByTypeByManufacturer", query="Delete from Cloth c WHERE c.type.id = :tId"),
        @NamedQuery(name = "cloth.byType", query="SELECT c.id, c.name FROM Cloth c WHERE c.type.id = :id"),
        @NamedQuery(name = "cloth.allWearers", query="SELECT w FROM Wearer w JOIN w.clothes c WHERE c.id = :id"),
        @NamedQuery(name = "cloth.addWearer", query="SELECT w FROM Wearer w JOIN w.clothes c WHERE c.id = :id"),
        @NamedQuery(name = "cloth.amountByType", query="SELECT count(c) FROM Cloth c WHERE c.type.id = :id")
})
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date productionDate;
    private double price;
    private boolean isWaterproof;
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "cloth_wearer",
            joinColumns = { @JoinColumn(name = "cloth_id") },
            inverseJoinColumns = { @JoinColumn(name = "wearer_id") }
    )
    private Collection<Wearer> wearers = new ArrayList<Wearer>();

    @JsonBackReference(value="cloth-type")
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Type type;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    private Fabric fabric;

    @JsonBackReference(value="cloth-manufacturer")
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Manufacturer manufacturer;

    public Cloth(String name, String productionDate, double price, boolean isWaterproof, Type type, Fabric fabric, Manufacturer manufacturer) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.name = name;
        this.productionDate = new Date(dateFormat.parse(productionDate).getTime());
        this.price = price;
        this.isWaterproof = isWaterproof;
        this.type = type;
        this.fabric = fabric;
        this.manufacturer = manufacturer;
    }

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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return this.getId() + ". " + this.getName() +
                ", data: " + this.getProductionDate().toString() +
                ", cena: " + this.getPrice() +
                ", wodoodporność: " + this.isWaterproof();
    }

}

