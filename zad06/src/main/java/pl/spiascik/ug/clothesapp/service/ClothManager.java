package pl.spiascik.ug.clothesapp.service;

import pl.spiascik.ug.clothesapp.domain.Cloth;
import pl.spiascik.ug.clothesapp.domain.Type;
import pl.spiascik.ug.clothesapp.domain.Wearer;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Singleton
@Stateless
public class ClothManager {

    @PersistenceContext
    EntityManager em;

    public void addCloth(Cloth cloth) {
        Type type1 = new Type("t-shirt");
        Wearer wearer = new Wearer("Jan", 1990);
        cloth.getWearers().add(wearer);
        cloth.setType(type1);
        em.persist(cloth);
    }

    @SuppressWarnings("unchecked")
    public List<Cloth> getAllClothes() {
        return em.createNamedQuery("cloth.all").getResultList();
    }

    public void clearClothes() {
        em.createNamedQuery("cloth.deleteAll").executeUpdate();
    }

    public void updateCloth(Cloth cloth) {
        em.merge(cloth);
    }

    public Cloth getClothById(Long id) {
        return em.find(Cloth.class, id);
//        return em.createNamedQuery("cloth.byId").setParameter("id", id).getFirstResult();
    }

    public List<Cloth> getAllClothWearers(Long id){
        return em.createNamedQuery("cloth.all").getResultList();
    }

    public List<Cloth> getAllClothOfType(String name){
        return em.createNamedQuery("cloth.all").getResultList();
    }
}
