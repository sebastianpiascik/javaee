package pl.spiascik.ug.clothesapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "manufacturer.all", query = "Select m.id, m.name from Manufacturer m"),
        @NamedQuery(name = "manufacturer.deleteAll", query="Delete from Manufacturer"),
        @NamedQuery(name = "manufacturer.clothesWithTypeBetweenWearerYob", query="Select c.name, c.price, c.type.name, m.name, cw.yob from Manufacturer m JOIN m.clothes c JOIN c.wearers cw WHERE m.id = :id AND c.type.name = :name AND cw.yob BETWEEN :yob_from AND :yob_to")
})
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonManagedReference(value="cloth-manufacturer")
    @OneToMany(mappedBy = "manufacturer",cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Cloth> clothes = new ArrayList<Cloth>();

    public Manufacturer(String name) {
        this.name = name;
    }

    public Manufacturer(){
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

    public List<Cloth> getClothes() {
        return clothes;
    }

    public void setClothes(List<Cloth> clothes) {
        this.clothes = clothes;
    }


}
