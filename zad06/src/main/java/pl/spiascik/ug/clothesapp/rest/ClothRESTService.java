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
    public Response getAllClothByType(@PathParam("typeId") Long id) {
        List<Cloth> clothes = cm.getAllClothByType(id);
        return Response.status(200).entity(clothes).build();
    }

    @GET
    @Path("/typeAmount/{typeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNumberOfClothesByType(@PathParam("typeId") Long id) {
//        List<Cloth> clothes = cm.getNumberOfClothesByType(id);
        long amount = cm.getNumberOfClothesByType(id);
        return Response.status(200).entity(amount).build();
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
        System.out.println("dodaje");
        System.out.println(cloth);
        cm.addCloth(cloth);
        return Response.status(201).entity("Added new cloth").build();
    }

    @POST
    @Path("/query/{clothId}/{wearerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addClothWearer(@PathParam("clothId") Long clothId, @PathParam("wearerId") Long wearerId) {
        cm.addClothWearer(clothId,wearerId);
        return Response.status(201).entity("Added wearer to cloth").build();
    }

    @DELETE
    public Response clearClothes() {
        cm.clearClothes();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{clothId}")
    public Response deleteCloth(@PathParam("clothId") Long id) {
        cm.deleteCloth(id);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/query/{tId}")
    public Response deleteClothByTypeByManufacturer(@PathParam("tId") Long tId) {
        System.out.println(tId);;
        cm.deleteClothByTypeByManufacturer(tId);
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
