/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ArtVin
 */
public class LocalDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public LocalDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public LocalDAO(Connection con){
        this.con = con;
    }
    
    public Local getLocal(int idLocal){
        Local local = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idLocal, nomeEstabelecimento, Endereco_idEndereco"
                    + " FROM local"
            );
            
            rs = st.executeQuery();
            EnderecoDAO enderecoDAO = new EnderecoDAO(con);
            if(rs.next()){
                local = new Local();
                local.setIdLocal(rs.getInt("idLocal"));
                local.setNomeEstabelecimento(rs.getString("nomeEstabelecimento"));
                local.setEndereco(enderecoDAO.getEndereco(rs.getInt("Endereco_idEndereco")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return local;
    }
    public List<Local> getListaLocal() {
        List<Local> listaLocal = new ArrayList<Local>();
        Local l = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idLocal, nomeEstabelecimento, Endereco_idEndereco"
                    + " FROM local"
            );
            
            rs = st.executeQuery();
            EnderecoDAO enderecoDAO = new EnderecoDAO(con);
            while(rs.next()){
                l = new Local();
                l.setIdLocal(rs.getInt("idLocal"));
                l.setNomeEstabelecimento(rs.getString("nomeEstabelecimento"));
                l.setEndereco(enderecoDAO.getEndereco(rs.getInt("Endereco_idEndereco")));
                listaLocal.add(l);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return listaLocal;
    }

    public int createLocal(Local l) {
        PreparedStatement st;
        
        
        try {
            st = con.prepareStatement(
                    "INSERT INTO local( nomeEstabelecimento, Endereco_idEndereco) "
                    + "VALUES (?,?) ",Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, l.getNomeEstabelecimento());
            if(l.getEndereco() != null){
                EnderecoDAO enderecoDAO = new EnderecoDAO(con);
                l.getEndereco().setIdEndereco(enderecoDAO.insertEndereco(l.getEndereco()));
                if(l.getEndereco().getIdEndereco() > 0){
                    st.setInt(2, l.getEndereco().getIdEndereco());
                }
                else return 0;
            }
            else return 0;            
            st.executeUpdate();

            rs = st.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);


        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return 0;
    }

    public Local getRandomLocal(int idCidade) {
        List<Local> listaLocal = new ArrayList<Local>();
        Local l = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT L.idLocal, L.nomeEstabelecimento, L.Endereco_idEndereco "
                    + " FROM local L " 
                    + "INNER JOIN Endereco E ON L.Endereco_idEndereco = E.idEndereco "
                    + "Where E.Cidade_idCidade = ?"
                    
            );
            st.setInt(1, idCidade);
            
            rs = st.executeQuery();
            EnderecoDAO enderecoDAO = new EnderecoDAO(con);
            while(rs.next()){
                l = new Local();
                l.setIdLocal(rs.getInt("L.idLocal"));
                l.setNomeEstabelecimento(rs.getString("L.nomeEstabelecimento"));
                l.setEndereco(enderecoDAO.getEndereco(rs.getInt("L.Endereco_idEndereco")));
                listaLocal.add(l);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Random rand = new Random();
        if(listaLocal.isEmpty()) return null;
        return listaLocal.get(rand.nextInt(listaLocal.size()));
        
    }
}
