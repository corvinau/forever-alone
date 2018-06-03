/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.services;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.facades.UsuarioFacade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ArtVin
 */
@Path("Ajax")
public class AjaxService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AjaxService
     */
    public AjaxService() {
    }

    /**
     * Retrieves representation of an instance of com.ufpr.tads.services.AjaxService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/cidade/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("id") String id) {
        
        List<Cidade> cidades = UsuarioFacade.getCidades(Integer.parseInt(id));
        GenericEntity<List<Cidade>> lista =
        new GenericEntity<List<Cidade>>(cidades) {};
        return Response
            .ok()
            .entity(lista)
            .build();
    }

    /**
     * PUT method for updating or creating an instance of AjaxService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
