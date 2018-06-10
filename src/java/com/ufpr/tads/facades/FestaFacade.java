/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.facades;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Convite;
import com.ufpr.tads.beans.Festa;
import com.ufpr.tads.dao.FestaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ArtVin
 */
public class FestaFacade {
    
    public static List<Festa> getListaFesta(){
        FestaDAO festaDao = new FestaDAO();
        return festaDao.getListaFesta();
    }

    public static int createFesta(Festa f) {
        FestaDAO festaDao = new FestaDAO();
        return festaDao.createFesta(f);
    }

    public static Festa getFesta(int idFesta) {
        FestaDAO festaDao = new FestaDAO();
        return festaDao.getFesta(idFesta);
    }

    public static List<Convite> insertConvites(String idFesta, String[] idUsuarios) {
        FestaDAO festaDao = new FestaDAO();
        List<Convite> listNotInserted = new ArrayList<Convite>();
        int idF = Integer.parseInt(idFesta);
        Convite convite;
        Cliente cliente;
        Festa festa = new Festa();
        festa.setIdFesta(idF);
        for(String aux : idUsuarios){
            convite = new Convite();
            cliente = new Cliente();
            cliente.setIdCliente(Integer.parseInt(aux));
            convite.setConvidado(cliente);
            convite.setTipo("F");
            convite.setEvento(festa);
            convite.setStatus("Aguardando");
            if(festaDao.insertConviteFesta(convite) > 0){
                listNotInserted.add(convite);
            }
        }
        
        return listNotInserted;
    }
}
