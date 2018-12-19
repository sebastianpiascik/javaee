package com.example.restwsdemo.rest;

import com.example.restwsdemo.domain.Cloth;
import com.example.restwsdemo.domain.Person;
import com.example.restwsdemo.service.ClothManager;
import com.example.restwsdemo.service.PersonManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Path("cloth")
@Stateless
public class ClothRESTService {

    @Inject
    private ClothManager cm;

    @GET
    @Path("/{clothId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cloth getCloth(@PathParam("clothId") Integer id) {
        Cloth c = cm.getCloth(id);
        System.out.println(c.getProductionDate());
        if(c != null)
            return c;
        else
            return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cloth> getClothes() {
        return cm.getAllClothes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCloth(Cloth cloth) {
        System.out.println("Data: "+cloth.getProductionDate());
        cm.addCloth(cloth);

        return Response.status(201).entity("Cloth").build();
    }

    @DELETE
    public Response clearClothes() {
        cm.deleteAllClothes();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{clothId}")
    public Response deleteCloth(@PathParam("clothId") Integer id) {
        cm.deleteCloth(cm.getCloth(id));
        return Response.status(200).build();
    }

    @PUT
    @Path("/{clothId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCloth(@PathParam("clothId") Integer id, Cloth cloth) {
        if(cm.updateCloth(id,cloth)){
            return Response.ok("Zmodyfikowano").build();
        }
        return Response.status(404).build();
    }

}
