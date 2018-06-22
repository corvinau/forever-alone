/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.facades;

import com.ufpr.tads.beans.Casamento;
import com.ufpr.tads.beans.Convite;
import com.ufpr.tads.dao.CasamentoDAO;

/**
 *
 * @author ArtVin
 */
public class CasamentoFacade {
    
    
    public static boolean insertCasamento(Casamento casamento,int idConvidado){
        CasamentoDAO casamentoDao = new CasamentoDAO();
        Convite convite = new Convite();
        return true;
    }
}
