package pl.spiascik.ug.clothesapp.rest;

import pl.spiascik.ug.clothesapp.domain.Manufacturer;
import pl.spiascik.ug.clothesapp.service.ManufacturerManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("manufacturer")
@Stateless
public class ManufacturerRESTService {

    @PersistenceContext
    EntityManager em;

    @EJB
    ManufacturerManager mm;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public Response getAllManufacturers() {
        List<Manufacturer> manufacturers = mm.getAllManufacturers();
        return Response.status(200).entity(manufacturers).build();
    }

    @GET
    @Path("/{manufacturerId}")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public Response getManufacturerById(@PathParam("manufacturerId") Long id) {
        Manufacturer manufacturer = mm.getManufacturerById(id);
        return Response.status(200).entity(manufacturer).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addManufacturer(Manufacturer manufacturer) {
        mm.addManufacturer(manufacturer);
        return Response.status(201).entity("Added new manufacturer").build();
    }

    @DELETE
    public Response clearManufacturers() {
        mm.clearManufacturers();
        return Response.status(200).build();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateManufacturer(Manufacturer manufacturer) {
        mm.updateManufacturer(manufacturer);
        return Response.status(202).build();
    }

    @GET
    @Path("/query/clotheswithtype/{manufacturerId}/{typeName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooksAuthor(@PathParam("manufacturerId") Long id, @PathParam("typeName") String typeName){

        List<Object[]> rawClothes = mm.getManufacturerClothesWithType(id,typeName);
        JsonArrayBuilder clothes = Json.createArrayBuilder();

        for(Object[] rawCloth: rawClothes){

            String clothName = (String) rawCloth[0];
            double clothPrice = (Double) rawCloth[1];
            String clothTypeName = (String) rawCloth[2];
            String manufacturerName = (String) rawCloth[3];

            clothes.add(Json.createObjectBuilder()
                    .add("clothName", clothName)
                    .add("clothPrice", clothPrice)
                    .add("clothTypeName", clothTypeName)
                    .add("manufacturerName", manufacturerName));

        }

        JsonObject json =  Json.createObjectBuilder().add("clothes", clothes).build();
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

}
