package pl.spiascik.ug.clothesapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Wearer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int yob;


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "wearers", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Cloth> clothes = new HashSet<Cloth>();

    public Wearer(String name, int yob) {
        this.name = name;
        this.yob = yob;
    }

    public Wearer(){
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

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public Set<Cloth> getClothes() {
        return clothes;
    }

    public void setClothes(Set<Cloth> clothes) {
        this.clothes = clothes;
    }
}
