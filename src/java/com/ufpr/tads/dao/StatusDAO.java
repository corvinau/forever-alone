/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Status;
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
class StatusDAO {
    private Connection con;
    private ResultSet rs;
    
    public StatusDAO(){
        
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public StatusDAO(Connection con){
        this.con = con;
    }

    public Status getStatus(int idStatus) {
        Status status = null;
        PreparedStatement st;
        try {
            st = con.prepareStatement(
                    "SELECT nome "
                    + "FROM status  "
                    + "WHERE idStatus = ?"
            );
            st.setInt(1, idStatus);
            
            rs = st.executeQuery();
            if(rs.next()){
                status = new Status();
                status.setIdStatus(idStatus);
                status.setNome(rs.getString("nome"));
            }
            return status;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return status;
    }
}
