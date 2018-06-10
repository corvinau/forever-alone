/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Endereco;
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
public class EnderecoDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public EnderecoDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public EnderecoDAO(Connection con){
        this.con = con;
    }
    
    public Endereco getEndereco(int idEndereco){
        Endereco e = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idEndereco, bairro, rua, numero, complemento,"
                    + " Cidade_idCidade FROM Endereco WHERE idEndereco = ?"
            );
            st.setInt(1, idEndereco);
            
            rs = st.executeQuery();
            CidadeDAO cidadeDAO = new CidadeDAO(con);
            while(rs.next()){
                e = new Endereco();
                e.setIdEndereco(rs.getInt("idEndereco"));
                e.setBairro(rs.getString("bairro"));
                e.setRua(rs.getString("rua"));
                e.setNumero(rs.getInt("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setCidade(cidadeDAO.getCidade(rs.getInt("Cidade_idCidade")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return e;
    }

    public int insertEndereco(Endereco endereco){
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "INSERT INTO Endereco(bairro, rua, numero, complemento,"
                    + " Cidade_idCidade) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS
            );
            if(endereco != null){
                if(endereco.getBairro() != null || !endereco.getBairro().isEmpty())
                    st.setString(1, endereco.getBairro());
                if(endereco.getRua() != null || !endereco.getRua().isEmpty())
                    st.setString(2, endereco.getRua());
                if(endereco.getNumero() > 0)
                    st.setInt(3,endereco.getNumero());
                if(endereco.getComplemento() != null || !endereco.getBairro().isEmpty())
                    st.setString(4,endereco.getComplemento());
                else
                    st.setNull(4, java.sql.Types.VARCHAR);
                if(endereco.getBairro() != null || !endereco.getBairro().isEmpty())
                    st.setInt(5, endereco.getCidade().getIdCidade());

                st.executeUpdate();

                rs = st.getGeneratedKeys();
                if(rs.next()) return rs.getInt(1);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return 0;
        
    }

    public boolean updateEndereco(Endereco endereco) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "UPDATE Endereco SET bairro = ? , rua = ?, numero = ?, complemento = ?,"
                    + " Cidade_idCidade = ? WHERE idEndereco = ?"
            );
            st.setString(1, endereco.getBairro());
            st.setString(2, endereco.getRua());
            st.setInt(3,endereco.getNumero());
            st.setString(4,endereco.getComplemento());
            st.setInt(5, endereco.getCidade().getIdCidade());
            st.setInt(6, endereco.getIdEndereco());
            
            int aux = st.executeUpdate();
            if(aux > 0) return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }
}
