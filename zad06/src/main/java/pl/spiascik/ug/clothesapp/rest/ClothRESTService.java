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
    @Path("/wearers/{clothId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClothWearers(@PathParam("clothId") Long id) {
        List<Cloth> clothes = cm.getClothWearers(id);
        return Response.status(200).entity(clothes).build();
    }

    @GET
    @Path("/type/{typeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClothOfType(@PathParam("typeId") Long id) {
        List<Cloth> clothes = cm.getAllClothOfType(id);
        return Response.status(200).entity(clothes).build();
//        return Response.status(200).entity("getAllClothOfType : " + name).build();
    }

    @GET
    @Path("/{clothId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClothById(@PathParam("clothId") Long id) {
        Cloth cloth = (Cloth) cm.getClothById(id);
        System.out.println(cloth);
        return Response.status(200).entity(cloth).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCloth(Cloth cloth) {
        cm.addCloth(cloth);
        return Response.status(201).entity("Added new cloth").build();
    }

    @POST
    @Path("/wearer/{wearerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addClothWearer(Cloth cloth, @PathParam("wearerId") Long id) {
        cm.addClothWearer(cloth,id);
        return Response.status(201).entity("Added wearer to cloth").build();
    }

    @DELETE
    public Response clearClothes() {
        cm.clearClothes();
        return Response.status(200).build();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCloth(Cloth cloth) {
        cm.updateCloth(cloth);
        return Response.status(202).build();
    }

}