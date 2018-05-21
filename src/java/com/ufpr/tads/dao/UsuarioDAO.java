/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class UsuarioDAO {
    
    private Connection con;
    private ResultSet rs;
    
    public UsuarioDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public UsuarioDAO(Connection con){
        this.con = con;
    }
    
    public Usuario getUsuario(String email,String senha){
        PreparedStatement st;
        Usuario u = null;
        try {
            st = con.prepareStatement(
                    "SELECT IDUSUARIO,EMAIL,SENHA,TIPO FROM USUARIO WHERE EMAIL = ? AND SENHA = ?"
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
            
            if(u != null){
                if(u.getTipo() == 'C' || u.getTipo() == 'c'){
                    ClienteDAO clienteDAO = new ClienteDAO(con);
                    return clienteDAO.getCliente(u);
                }
                else{
                    FuncionarioDAO funcionarioDAO = new FuncionarioDAO(con);
                    return funcionarioDAO.getFuncionario(u);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        
        return null;
    }
    
    private String senhaMD5(String senha){
        MessageDigest algorithm;
        String senhaHex = null;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            senhaHex = hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
                
        return senhaHex;
    }
    
}
