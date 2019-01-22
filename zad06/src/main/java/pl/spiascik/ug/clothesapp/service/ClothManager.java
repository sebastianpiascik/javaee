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
        Type type = tm.getTypeById((long) 3);
        Wearer wearer = wm.getWearerById((long) 3);
        Fabric fabric = em.find(Fabric.class,1);
        Manufacturer manufacturer = mm.getManufacturerById((long) 1);
        cloth.getWearers().add(wearer);
        cloth.setType(type);
        cloth.setFabric(fabric);
        cloth.setManufacturer(manufacturer);
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
//        Cloth cloth = em.find(Cloth.class, id);
//        em.remove(cloth);
    }

    public void updateCloth(Cloth cloth) {
        em.merge(cloth);
    }

    public Cloth getClothById(Long id) {
//        Query qry= em.createNamedQuery("cloth.byId", Cloth.class).setParameter("id", id);
//        System.out.println(qry);
//        Cloth cloth = (Cloth)qry.getSingleResult();
//        System.out.println(cloth);
//        return cloth;
//        return (Cloth)em.createNamedQuery("cloth.byId").setParameter("id", id).get;
        Cloth retrieved = em.find(Cloth.class, id);
        return retrieved;
    }

    public List<Cloth> getClothWearers(Long id) {
        return em.createNamedQuery("cloth.allWearers").setParameter("id", id).getResultList();
    }

    public List<Cloth> getAllClothOfType(Long id) {
        return em.createNamedQuery("cloth.byType").setParameter("id", id).getResultList();
    }

    public void addClothWearer(Long clothId, Long wearerId) {
        Wearer wearer = wm.getWearerById(wearerId);
        Cloth retrieved = em.find(Cloth.class, clothId);
        retrieved.getWearers().add(wearer);
        em.merge(retrieved);
    }
}
