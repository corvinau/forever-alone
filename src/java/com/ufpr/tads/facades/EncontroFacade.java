/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.facades;

import com.ufpr.tads.beans.Encontro;
import com.ufpr.tads.dao.EncontroDAO;
import java.util.List;

/**
 *
 * @author ArtVin
 */
public class EncontroFacade {

    public static List<Encontro> getListaEncontroCliente(int idCliente) {
        EncontroDAO encontroDao = new EncontroDAO();
        return encontroDao.getListaEncontroCliente(idCliente);
    }
    
}
