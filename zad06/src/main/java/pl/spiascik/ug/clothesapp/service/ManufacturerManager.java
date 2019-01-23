package pl.spiascik.ug.clothesapp.service;

import pl.spiascik.ug.clothesapp.domain.Manufacturer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ManufacturerManager {

    @PersistenceContext
    EntityManager em;

    public void addManufacturer(Manufacturer manufacturer) {
        em.persist(manufacturer);
    }

    public List<Manufacturer> getAllManufacturers() {
        return em.createNamedQuery("manufacturer.all").getResultList();
    }

    public void clearManufacturers() {
        em.createNamedQuery("manufacturer.deleteAll").executeUpdate();
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        em.merge(manufacturer);
    }

    public Manufacturer getManufacturerById(Long id) {
        return (Manufacturer) em.createNamedQuery("manufacturer.byId").setParameter("id", id).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> getManufacturerClothesWithTypeBetweenWearerYob(Long id, String typeName, int yob_from, int yob_to){
        return em.createNamedQuery("manufacturer.clothesWithTypeBetweenWearerYob").setParameter("id", id).setParameter("name", typeName).setParameter("yob_from", yob_from).setParameter("yob_to", yob_to).getResultList();
    }
}
