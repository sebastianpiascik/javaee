package pl.spiascik.ug.clothesapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NamedQueries({
        @NamedQuery(name = "wearer.all", query = "Select w from Wearer w"),
        @NamedQuery(name = "wearer.allClothes", query = "Select w from Wearer w join fetch w.clothes wc"),
        @NamedQuery(name = "wearer.deleteAll", query="Delete from Wearer")
})
public class Wearer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int yob;

    @ManyToMany(mappedBy = "wearers", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Cloth> clothes = new ArrayList<Cloth>();

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

    public Collection<Cloth> getClothes() {
        return clothes;
    }

    public void setClothes(Collection<Cloth> clothes) {
        this.clothes = clothes;
    }
}
