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
import java.util.ArrayList;
import java.util.List;
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
    public CorCabelo getCorCabelo(String nomeCorCabelo){
        CorCabelo c = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idCorCabelo, nome FROM corCabelo WHERE nome = ?"
            );
            st.setString(1, nomeCorCabelo);
            
            rs = st.executeQuery();
            while(rs.next()){
                c = new CorCabelo();
                c.setIdCorCabelo(rs.getInt("idCorCabelo"));
                c.setNome(rs.getString("nome"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return c;
    }

    public List<CorCabelo> getListaCorCabelo(int idPreferencia){
        List<CorCabelo> lista = new ArrayList<CorCabelo>();
        CorCabelo c;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                              "SELECT corCabelo.idCorCabelo, corCabelo.nome FROM preferencias_has_corcabelo "
                            + "INNER JOIN corCabelo ON corCabelo.idCorCabelo = preferencias_has_corcabelo.CorCabelo_idCorCabelo "
                            + "WHERE preferencias_has_corcabelo.Preferencias_idPreferencias = ? "
            );
            st.setInt(1, idPreferencia);
            
            rs = st.executeQuery();
            while(rs.next()){
                c = new CorCabelo();
                c.setIdCorCabelo(rs.getInt("corCabelo.idCorCabelo"));
                c.setNome(rs.getString("corCabelo.nome"));
                lista.add(c);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public boolean insertCorCabeloPreferencia(int idPreferencia, List<CorCabelo> corCabelo) {
        if(!corCabelo.isEmpty()){
            for(CorCabelo c : corCabelo){
                if(c.getIdCorCabelo() == 0){
                    c.setIdCorCabelo(getCorCabelo(c.getNome()).getIdCorCabelo());
                }
                if(!insertCorCabeloPreferencia(idPreferencia, c.getIdCorCabelo())) return false;
            }
        }
        return true;
    }
    
    public boolean insertCorCabeloPreferencia(int idPreferencia, int idCorCabelo){
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                        "INSERT INTO preferencias_has_corcabelo(CorCabelo_idCorCabelo, Preferencias_idPreferencias) "
                      + "VALUES (?,?)"
            );
            st.setInt(1, idCorCabelo);
            st.setInt(2, idPreferencia);
            
            if(st.executeUpdate() > 0) return true;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public boolean deleteCorCabeloPreferencia(int idPreferencia) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                        "DELETE FROM preferencias_has_corcabelo WHERE Preferencias_idPreferencias = ? "
            );
            st.setInt(1, idPreferencia);
            
            if(st.executeUpdate() > 0) return true;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public List<CorCabelo> getListaCorCabelo() {
        List<CorCabelo> lista = new ArrayList<CorCabelo>();
        CorCabelo c;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                              "SELECT idCorCabelo, nome FROM corCabelo"
            );
            
            rs = st.executeQuery();
            while(rs.next()){
                c = new CorCabelo();
                c.setIdCorCabelo(rs.getInt("idCorCabelo"));
                c.setNome(rs.getString("nome"));
                lista.add(c);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
}
