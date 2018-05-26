/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.CorCabelo;
import com.ufpr.tads.beans.CorPele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ArtVin
 */
public class CorPeleDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public CorPeleDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public CorPeleDAO(Connection con){
        this.con = con;
    }
    
    public CorPele getCorPele(int idCorPele){
        CorPele c = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idCorPele, nome FROM CorPele WHERE idCorPele = ?"
            );
            st.setInt(1, idCorPele);
            
            rs = st.executeQuery();
            while(rs.next()){
                c = new CorPele();
                c.setIdCorPele(idCorPele);
                c.setNome(rs.getString("nome"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return c;
    }
}
