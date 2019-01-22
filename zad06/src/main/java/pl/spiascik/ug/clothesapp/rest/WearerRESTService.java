package pl.spiascik.ug.clothesapp.rest;

import pl.spiascik.ug.clothesapp.domain.Wearer;
import pl.spiascik.ug.clothesapp.service.WearerManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("wearer")
@Stateless
public class WearerRESTService {

    @PersistenceContext
    EntityManager em;

    @EJB
    WearerManager tm;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public Response getAllWearers() {
        List<Wearer> wearers = tm.getAllWearers();
        return Response.status(200).entity(wearers).build();
    }

    @GET
    @Path("/{wearerId}")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public Response getWearerById(@PathParam("wearerId") Long id) {
        Wearer wearer = tm.getWearerById(id);
        return Response.status(200).entity(wearer).build();
    }

    @GET
    @Path("/{wearerId}")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public Response getAllClothes(@PathParam("wearerId") Long id) {
        Wearer wearer = tm.getWearerById(id);
        return Response.status(200).entity(wearer).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addWearer(Wearer wearer) {
        tm.addWearer(wearer);
        return Response.status(201).entity("Added new wearer").build();
    }

    @DELETE
    public Response clearWearers() {
        tm.clearWearers();
        return Response.status(200).build();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateWearer(Wearer wearer) {
        tm.updateWearer(wearer);
        return Response.status(202).build();
    }

}
