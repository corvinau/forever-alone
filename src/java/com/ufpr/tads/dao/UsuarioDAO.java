/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Funcionario;
import com.ufpr.tads.beans.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class UsuarioDAO {
    
    private final String CPF = "SELECT cpf FROM cliente WHERE cpf = ? \n" +
                                        "UNION\n" +
                                        "SELECT cpf FROM funcionario WHERE cpf = ?;";
    private final String EMAIL = "SELECT email FROM usuario WHERE email = ?;";
    
    private PreparedStatement stmt;
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
            if(email != null && senha !=null){
                st.setString(1, email);
                st.setString(2, senhaMD5(senha));

                rs = st.executeQuery();
            }
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
                
        
        
        return u;
    }
    public int insertUsuario(Usuario u){
        PreparedStatement st;
        if(u !=null){
            try {
                st = con.prepareStatement(
                        "INSERT INTO usuario(email,senha,tipo) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS
                );
                if(!u.getEmail().isEmpty() && !u.getSenha().isEmpty() && u.getTipo() != 0){
                    st.setString(1, u.getEmail());
                    st.setString(2, senhaMD5(u.getSenha())); 
                    st.setString(3, u.getTipo() + "");
                    st.executeUpdate();
                }
                if(st !=null){
                    rs = st.getGeneratedKeys();
                }
                if(rs.next()){
                    u.setIdUsuario(rs.getInt(1));
                    if(u.getTipo() == 'C' || u.getTipo() == 'c'){
                        ClienteDAO clienteDAO = new ClienteDAO(con);
                        if(clienteDAO.insertCliente((Cliente) u) != 0)return 1;
                    }
                    else{
                        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(con);
                        if(funcionarioDAO.insertFuncionario((Funcionario) u) != 0) return 1;
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            deleteUsuario(u);
        }
        return 0;    
        
    }
    public boolean updateUsuario(Usuario u){
        PreparedStatement st;
        if(u !=null && u.getIdUsuario() > 0){
            try {
                st = con.prepareStatement(
                        "UPDATE usuario SET senha = ? WHERE idUsuario = ?"
                );
                if(!u.getSenha().isEmpty()){
                    st.setString(1, senhaMD5(u.getSenha()));
                    st.setInt(2, u.getIdUsuario());
                    st.executeUpdate();
                }
                int rowsAffected = st.executeUpdate();
                if(rowsAffected > 0)return true;
                
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;    
        
    }
    public boolean deleteUsuario(Usuario u){
        if(u.getIdUsuario() != 0){
            return deleteUsuario(u.getIdUsuario());
        }
        return false;
    }
    public boolean deleteUsuario(int idUsuario){
        PreparedStatement st;
        try {
            st = con.prepareStatement(
                    "DELETE FROM usuario WHERE idUsuario = ?"
            );
            st.setInt(1, idUsuario);
            
            if(st.executeUpdate() !=0) return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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

    public boolean verificaCpf(String cpf) {
    	try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(CPF);
            stmt.setString(1, cpf);
            stmt.setString(2, cpf);
            rs = stmt.executeQuery();
            if (rs.next())
            	return true;
            else
            	return false;
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}finally{
    		try {con.close();} catch (SQLException e) {}
    	}
    }

    public boolean verificaEmail(String email) {
    	try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(EMAIL);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            if (rs.next())
            	return true;
            else
            	return false;
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}finally{
    		try {con.close();} catch (SQLException e) {}
    	}
    }
    
}
