package pl.spiascik.ug.clothesapp.rest;

import pl.spiascik.ug.clothesapp.domain.Cloth;
import pl.spiascik.ug.clothesapp.domain.Type;
import pl.spiascik.ug.clothesapp.domain.Wearer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("cloth")
@Stateless
public class ClothRESTService {


    @PersistenceContext
    EntityManager em;

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Cloth is working!";
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Cloth> getAllClothes(){
        return em.createNamedQuery("cloth.all").getResultList();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCloth(Cloth cloth){
        Type type1 = new Type("t-shirt");
        Wearer wearer = new Wearer("Jan",1990);
        cloth.getWearers().add(wearer);
        cloth.setType(type1);
        em.persist(cloth);
        return Response.status(201).entity("Cloth").build();
    }

    @DELETE
    public Response clearClothes() {
        em.createNamedQuery("cloth.deleteAll").executeUpdate();
        return Response.status(200).build();
    }

    @PUT
    @Path("/{clothId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCloth(@PathParam("clothId") Integer id, Cloth cloth) {
//        if(cm.updateCloth(id,cloth)){
//            return Response.ok("Zmodyfikowano").build();
//        }
        return Response.status(404).build();
    }

}
