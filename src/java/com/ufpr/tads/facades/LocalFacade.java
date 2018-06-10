/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.facades;

import com.ufpr.tads.beans.Local;
import com.ufpr.tads.dao.LocalDAO;
import java.util.List;

/**
 *
 * @author ArtVin
 */
public class LocalFacade {
    
    public static List<Local> getListaLocal(){
        LocalDAO localDao = new LocalDAO();
        return localDao.getListaLocal();
    }

    public static int createLocal(Local l) {
        LocalDAO localDao = new LocalDAO();
        return localDao.createLocal(l);
    }
}
