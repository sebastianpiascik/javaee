package pl.spiascik.ug.clothesapp.rest;

import pl.spiascik.ug.clothesapp.domain.Cloth;
import pl.spiascik.ug.clothesapp.service.ClothManager;

import javax.ejb.EJB;
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

    @EJB
    ClothManager cm;

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "REST API is working!";
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public Response getAllClothes() {
        List<Cloth> clothes = cm.getAllClothes();
        return Response.status(200).entity(clothes).build();
    }

    @GET
    @Path("/{clothId}")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public Response getClothById(@PathParam("clothId") Long id) {
        Cloth cloth = cm.getClothById(id);
        return Response.status(200).entity(cloth).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCloth(Cloth cloth) {
        cm.addCloth(cloth);
        return Response.status(201).entity("Added new cloth").build();
    }

    @DELETE
    public Response clearClothes() {
        cm.clearClothes();
        return Response.status(200).build();
    }

    @PUT
    @Path("/{clothId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCloth(Cloth cloth) {
        cm.updateCloth(cloth);
        return Response.status(202).build();
    }

}
