package pl.spiascik.ug.clothesapp.service;

import pl.spiascik.ug.clothesapp.domain.*;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Singleton
@Stateless
public class ClothManager {

    @PersistenceContext
    EntityManager em;

    @EJB
    TypeManager tm;
    @EJB
    WearerManager wm;
    @EJB
    ManufacturerManager mm;

    public void addCloth(Cloth cloth) {
//        Type type = tm.getTypeById((long) 3);
//        Wearer wearer = wm.getWearerById((long) 3);
//        Fabric fabric = em.find(Fabric.class,(long) 1);
//        Manufacturer manufacturer = mm.getManufacturerById((long) 1);
//        cloth.getWearers().add(wearer);
//        cloth.setType(type);
//        cloth.setFabric(fabric);
//        cloth.setManufacturer(manufacturer);
        em.persist(cloth);
    }

    @SuppressWarnings("unchecked")
    public List<Cloth> getAllClothes() {
        return em.createNamedQuery("cloth.all").getResultList();
    }

    public void clearClothes() {
        em.createNamedQuery("cloth.deleteAll").executeUpdate();
    }

    public void deleteCloth(Long id) {
        em.createNamedQuery("cloth.deleteCloth").setParameter("id", id).executeUpdate();
    }

    public void deleteClothByTypeByManufacturer(Long tId) {
        em.createNamedQuery("cloth.deleteClothesByTypeByManufacturer").setParameter("tId", tId).executeUpdate();
    }

    public void updateCloth(Cloth cloth) {
        em.merge(cloth);
    }

    public Cloth getClothById(Long id) {
        return (Cloth) em.createNamedQuery("cloth.byId").setParameter("id", id).getSingleResult();
    }

    public List<Cloth> getClothWearers(Long id) {
        return em.createNamedQuery("cloth.allWearers").setParameter("id", id).getResultList();
    }

    public List<Cloth> getAllClothByType(Long id) {
        return em.createNamedQuery("cloth.byType").setParameter("id", id).getResultList();
    }

    public long getNumberOfClothesByType(Long id) {
        return (Long) em.createNamedQuery("cloth.amountByType").setParameter("id", id).getSingleResult();
    }

    public void addClothWearer(Long clothId, Long wearerId) {
        Wearer wearer = wm.getWearerById(wearerId);
        Cloth retrieved = em.find(Cloth.class, clothId);
        retrieved.getWearers().add(wearer);
        em.merge(retrieved);
    }
}
