/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Funcionario;
import com.ufpr.tads.beans.Usuario;
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
public class FuncionarioDAO {
    private Connection con;
    private ResultSet rs;
    
    public FuncionarioDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public FuncionarioDAO(Connection con){
        this.con = con;
    }
    
    public Funcionario getFuncionario(Usuario u){
        Funcionario f = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                      "SELECT idFuncionario, nome, cargo, cpf, "
                    + "dataNascimento, Endereco_idEndereco FROM funcionario "
                    + "WHERE Usuario_idUsuario = ? "
            );
            st.setInt(1, u.getIdUsuario());
            EnderecoDAO enderecoDAO = new EnderecoDAO(con);
            rs = st.executeQuery();
            while(rs.next()){
                f = new Funcionario();
                f.setIdUsuario(u.getIdUsuario());
                f.setEmail(u.getEmail());
                f.setTipo(u.getTipo());
                f.setIdFuncionario(rs.getInt("idFuncionario"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
                f.setCpf(rs.getString("cpf"));
                f.setDataNasc(rs.getDate("dataNascimento"));
                f.setEndereco(enderecoDAO.getEndereco(rs.getInt("Endereco_idEndereco")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return f;
    }

    public int insertFuncionario(Funcionario f) {
        PreparedStatement st;
        int aux;
        try {
            st = con.prepareStatement(
                      "INSERT INTO Funcionario(nome, cargo, cpf, "
                    + "dataNascimento, Endereco_idEndereco) "
                    + "VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, f.getNome());
            st.setString(2, f.getCargo());
            st.setString(3, f.getCpf());
            st.setDate(4, new java.sql.Date(f.getDataNasc().getTime()));
            if(f.getEndereco() != null){
                if(f.getEndereco().getIdEndereco() == 0){
                    EnderecoDAO enderecoDAO = new EnderecoDAO(con);
                    aux = enderecoDAO.insertEndereco(f.getEndereco());
                    f.getEndereco().setIdEndereco(aux);
                    st.setInt(5, f.getEndereco().getIdEndereco());
                }
                else st.setNull(5, java.sql.Types.INTEGER);
            }
            else{
                st.setNull(5, java.sql.Types.INTEGER);
            }
            
            st.executeUpdate();
            
            rs = st.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return 0;
    }
    public boolean updateFuncionario(Funcionario f) {
        PreparedStatement st;
        int aux;
        try {
            st = con.prepareStatement(
                      "UPDATE Funcionario WHERE idFuncionario = ? SET nome = ?,"
                    + "cargo = ?, Endereco_idEndereco = ?"
            );
            st.setInt(1, f.getIdFuncionario());
            st.setString(2, f.getNome());
            st.setString(3, f.getCargo());
            if(f.getEndereco() != null){
                EnderecoDAO enderecoDAO = new EnderecoDAO(con);
                if(f.getEndereco().getIdEndereco() == 0){
                    aux = enderecoDAO.insertEndereco(f.getEndereco());
                    f.getEndereco().setIdEndereco(aux);
                }
                else {
                    enderecoDAO.updateEndereco(f.getEndereco());
                }
                st.setInt(4, f.getEndereco().getIdEndereco());
            }
            else{
                st.setNull(4, java.sql.Types.INTEGER);
            }
            aux = st.executeUpdate();
            if(aux > 0) return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return true;
    }
}
