/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.CorCabelo;
import com.ufpr.tads.beans.Endereco;
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
public class CorCabeloDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public CorCabeloDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public CorCabeloDAO(Connection con){
        this.con = con;
    }
    
    public CorCabelo getCorCabelo(int idCorCabelo){
        CorCabelo c = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idCorCabelo, nome FROM corCabelo WHERE idCorCabelo = ?"
            );
            st.setInt(1, idCorCabelo);
            
            rs = st.executeQuery();
            while(rs.next()){
                c = new CorCabelo();
                c.setIdCorCabelo(idCorCabelo);
                c.setNome(rs.getString("nome"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return c;
    }
}
