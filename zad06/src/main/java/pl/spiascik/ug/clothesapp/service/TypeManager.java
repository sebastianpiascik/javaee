package pl.spiascik.ug.clothesapp.service;

import pl.spiascik.ug.clothesapp.domain.Type;
import pl.spiascik.ug.clothesapp.domain.Type;
import pl.spiascik.ug.clothesapp.domain.Wearer;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Singleton
@Stateless
public class TypeManager {

    @PersistenceContext
    EntityManager em;

    public void addType(Type type) {
        em.persist(type);
    }

    public List<Type> getAllTypes() {
        return em.createNamedQuery("type.all").getResultList();
    }

    public void clearTypes() {
        em.createNamedQuery("type.deleteAll").executeUpdate();
    }

    public void updateType(Type type) {
        em.merge(type);
    }

    public Type getTypeById(Long id) {
        return em.find(Type.class, id);
    }
}
