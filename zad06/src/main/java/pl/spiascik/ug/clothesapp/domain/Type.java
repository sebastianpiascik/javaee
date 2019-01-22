package pl.spiascik.ug.clothesapp.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "type.all", query = "Select t from Type t"),
        @NamedQuery(name = "type.deleteAll", query="Delete from Type")
})
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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

}
