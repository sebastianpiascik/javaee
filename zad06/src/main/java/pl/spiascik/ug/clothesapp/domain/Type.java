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
        @NamedQuery(name = "type.all", query = "Select t.id, t.name from Type t"),
        @NamedQuery(name = "type.deleteAll", query="Delete from Type"),
        @NamedQuery(name = "type.byId", query = "Select t from Type t JOIN fetch t.clothes tc where t.id = :id"),
})
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonManagedReference(value="cloth-type")
    @OneToMany(mappedBy = "type",cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Cloth> clothes = new ArrayList<Cloth>();

    public Type(String name) {
        this.name = name;
    }

    public Type(){
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
