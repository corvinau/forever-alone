/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Convite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ArtVin
 */
public class ConviteDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public ConviteDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ConviteDAO(Connection con){
        this.con = con;
    }
    
 
    public int insertConvite(Convite convite) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "INSERT INTO convite(status,tipo,Cliente_idCliente) "
                    + "VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1,convite.getStatus());
            st.setString(2, convite.getTipo());
            st.setInt(3, convite.getConvidado().getIdCliente());
         
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return 0;
    }
}
