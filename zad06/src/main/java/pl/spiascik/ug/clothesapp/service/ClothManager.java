package pl.spiascik.ug.clothesapp.service;

import pl.spiascik.ug.clothesapp.domain.Cloth;

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
        em.persist(cloth);
    }

    @SuppressWarnings("unchecked")
    public List<Cloth> getAllClothes() {
        return em.createNamedQuery("cloth.all").getResultList();
    }

    public void clearClothes() {
        em.createNamedQuery("cloth.deleteAll").executeUpdate();
    }

    public Cloth getCloth(Long id) {
        return em.find(Cloth.class, id);
    }

    public Cloth updateCloth(Cloth cloth) {
        return em.merge(cloth);
    }

    public List<Cloth> findById(int id){
        return em.createNamedQuery("cloth.byId").setParameter("id", id).getResultList();
    }

}
