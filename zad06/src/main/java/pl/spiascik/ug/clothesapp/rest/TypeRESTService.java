package pl.spiascik.ug.clothesapp.rest;

import pl.spiascik.ug.clothesapp.domain.Type;
import pl.spiascik.ug.clothesapp.service.TypeManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("type")
@Stateless
public class TypeRESTService {

    @PersistenceContext
    EntityManager em;

    @EJB
    TypeManager tm;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public Response getAllTypees() {
        List<Type> types = tm.getAllTypes();
        return Response.status(200).entity(types).build();
    }

    @GET
    @Path("/{typeId}")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public Response getTypeById(@PathParam("typeId") Long id) {
        Type type = tm.getTypeById(id);
        return Response.status(200).entity(type).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addType(Type type) {
        tm.addType(type);
        return Response.status(201).entity("Added new type").build();
    }

    @DELETE
    public Response clearTypees() {
        tm.clearTypes();
        return Response.status(200).build();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateType(Type type) {
        tm.updateType(type);
        return Response.status(202).build();
    }

}
