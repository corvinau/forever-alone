/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Usuario;
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
public class ClienteDAO {
    
    private Connection con;
    private ResultSet rs;
    
    public ClienteDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ClienteDAO(Connection con){
        this.con = con;
    }
    
    public Cliente getCliente(Usuario u){
        Cliente c = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT  FROM USUARIO WHERE EMAIL = ? AND SENHA = ?"
            );
            st.setString(1, email);
            st.setString(2, senhaMD5(senha));
            
            rs = st.executeQuery();
            while(rs.next()){
                u = new Usuario();
                u.setIdUsuario(rs.getInt("IDUSUARIO"));
                u.setEmail(rs.getString("EMAIL"));
                u.setSenha(rs.getString("SENHA"));
                u.setTipo(rs.getString("TIPO").charAt(0));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return c;
    }
    
}
