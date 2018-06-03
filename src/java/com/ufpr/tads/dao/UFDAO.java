/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.UF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ArtVin
 */
public class UFDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public UFDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public UFDAO(Connection con){
        this.con = con;
    }
    
    public UF getUF(int idUF){
        UF u = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idUF, nome, sigla"
                    + " FROM uf WHERE idUF = ?"
            );
            st.setInt(1, idUF);
            
            rs = st.executeQuery();
            while(rs.next()){
                u = new UF();
                u.setIdUF(idUF);
                u.setNome(rs.getString("nome"));
                u.setSigla(rs.getString("sigla"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return u;
    }

    public List<UF> getListaUF() {
        List<UF> listaUF = new ArrayList<UF>();
        UF u = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idUF, nome, sigla"
                    + " FROM uf"
            );
            
            rs = st.executeQuery();
            while(rs.next()){
                u = new UF();
                u.setIdUF(rs.getInt("idUF"));
                u.setNome(rs.getString("nome"));
                u.setSigla(rs.getString("sigla"));
                listaUF.add(u);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return listaUF;
    }
}
