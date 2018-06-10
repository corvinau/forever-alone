/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.facades;

import com.ufpr.tads.beans.Festa;
import com.ufpr.tads.dao.FestaDAO;
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
}
