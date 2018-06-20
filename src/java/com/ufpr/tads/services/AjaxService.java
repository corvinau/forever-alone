/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.services;

import com.ufpr.tads.beans.Casamento;
import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Convite;
import com.ufpr.tads.beans.Encontro;
import com.ufpr.tads.beans.Festa;
import com.ufpr.tads.facades.UsuarioFacade;
import com.ufpr.tads.interfaces.Convidavel;
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
    @GET
    @Path("/convites/{id}")// id do Cliente
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConvites(@PathParam("id") String id) {
        
        List<Convite> convites = UsuarioFacade.getConvitesAguardando(Integer.parseInt(id));
        GenericEntity<List<Convite>> lista =
        new GenericEntity<List<Convite>>(convites) {};
        return Response
            .ok()
            .entity(lista)
            .build();
    }
    @GET
    @Path("/eventoConvite/{id}")// id do convite
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventoConvite(@PathParam("id") String id) {
        
        Convite convite = UsuarioFacade.getEventoConvite(Integer.parseInt(id));
        switch (convite.getTipo().toLowerCase()){
            case "f" :
                GenericEntity<Festa> evento =
                new GenericEntity<Festa>((Festa) convite.getEvento()) {};
                return Response
                .ok()
                .entity(evento)
                .build();
            case "e" :
                GenericEntity<Encontro> evento2 =
                new GenericEntity<Encontro>((Encontro) convite.getEvento()) {};
                return Response
                .ok()
                .entity(evento2)
                .build();
            default :
                GenericEntity<Casamento> evento3 =
                new GenericEntity<Casamento>((Casamento) convite.getEvento()) {};
                return Response
                .ok()
                .entity(evento3)
                .build();
                
        }
    }
    
    @GET
    @Path("/existecpf/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificaCpf(@PathParam("cpf") String cpf) {
        String result;
        if(UsuarioFacade.verificaCpf(cpf))
            result = "true";
        else
            result = "false";
        return Response
            .ok()
            .entity(result)
            .build();
    }

    @GET
    @Path("/existeemail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificaEmail(@PathParam("email") String email) {
        String result;
        if(UsuarioFacade.verificaEmail(email))
            result = "true";
        else
            result = "false";
        return Response
            .ok()
            .entity(result)
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
