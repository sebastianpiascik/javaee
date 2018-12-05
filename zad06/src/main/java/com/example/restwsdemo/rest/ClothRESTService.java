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
    public Cloth getPerson(@PathParam("clothId") Integer id) {
        Cloth c = cm.getCloth(id);
        return c;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cloth> getClothess() {
        return cm.getAllClothes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCloth(String name) {
//        return Response.ok("Cloth: " + name).build();
        cm.addCloth(new Cloth(name));

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

}
