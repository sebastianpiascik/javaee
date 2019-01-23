package pl.spiascik.ug.clothesapp.service;

import pl.spiascik.ug.clothesapp.domain.Wearer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class WearerManager {
    @PersistenceContext
    EntityManager em;

    public void addWearer(Wearer wearer) {
        em.persist(wearer);
    }

    public List<Wearer> getAllWearers() {
        return em.createNamedQuery("wearer.all").getResultList();
    }

    public List<Wearer> getAllClothesByWearer() {
        return em.createNamedQuery("wearer.allClothes").getResultList();
    }

    public void clearWearers() {
        em.createNamedQuery("wearer.deleteAll").executeUpdate();
    }

    public void updateWearer(Wearer wearer) {
        em.merge(wearer);
    }

    public Wearer getWearerById(Long id) {
        return em.find(Wearer.class, id);
    }
}
