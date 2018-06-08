/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.CorCabelo;
import com.ufpr.tads.beans.CorPele;
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
public class CorPeleDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public CorPeleDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public CorPeleDAO(Connection con){
        this.con = con;
    }
    
    public CorPele getCorPele(int idCorPele){
        CorPele c = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idCorPele, nome FROM CorPele WHERE idCorPele = ?"
            );
            st.setInt(1, idCorPele);
            
            rs = st.executeQuery();
            while(rs.next()){
                c = new CorPele();
                c.setIdCorPele(idCorPele);
                c.setNome(rs.getString("nome"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return c;
    }
    public CorPele getCorPele(String nomeCorPele){
        CorPele c = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idCorPele, nome FROM CorPele WHERE nome = ?"
            );
            st.setString(1, nomeCorPele);
            
            rs = st.executeQuery();
            while(rs.next()){
                c = new CorPele();
                c.setIdCorPele(rs.getInt("idCorPele"));
                c.setNome(rs.getString("nome"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return c;
    }

    public List<CorPele> getListaCorPele(int idPreferencia){
       List<CorPele> lista = new ArrayList<CorPele>();
       CorPele c;
       PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                              "SELECT CorPele.idCorPele, CorPele.nome FROM preferencias_has_CorPele "
                            + "INNER JOIN CorPele ON CorPele.idCorPele = preferencias_has_CorPele.CorPele_idCorPele "
                            + "WHERE preferencias_has_CorPele.Preferencias_idPreferencias = ? "
            );
            st.setInt(1, idPreferencia);
            
            rs = st.executeQuery();
            while(rs.next()){
                c = new CorPele();
                c.setIdCorPele(rs.getInt("CorPele.idCorPele"));
                c.setNome(rs.getString("CorPele.nome"));
                lista.add(c);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public boolean insertCorPelePreferencia(int idPreferencia, List<CorPele> CorPele) {
        if(!CorPele.isEmpty()){
            for(CorPele c : CorPele){
                if(c.getIdCorPele() == 0){
                    c.setIdCorPele(getCorPele(c.getNome()).getIdCorPele());
                }
                if(!insertCorPelePreferencia(idPreferencia, c.getIdCorPele())) return false;
            }
        }
        return true;
    }
    
    public boolean insertCorPelePreferencia(int idPreferencia, int idCorPele){
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                        "INSERT INTO preferencias_has_CorPele(CorPele_idCorPele, Preferencias_idPreferencias) "
                      + "VALUES (?,?)"
            );
            st.setInt(1, idCorPele);
            st.setInt(2, idPreferencia);
            
            if(st.executeUpdate() > 0) return true;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public boolean deleteCorPelePreferencia(int idPreferencia) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                        "DELETE FROM preferencias_has_CorPele WHERE Preferencias_idPreferencias = ?"
            );
            st.setInt(1, idPreferencia);
            
            if(st.executeUpdate() > 0) return true;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public List<CorPele> getListaCorPele() {
       List<CorPele> lista = new ArrayList<CorPele>();
       CorPele c;
       PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                              "SELECT idCorPele, nome FROM corPele"
            );
            
            rs = st.executeQuery();
            while(rs.next()){
                c = new CorPele();
                c.setIdCorPele(rs.getInt("idCorPele"));
                c.setNome(rs.getString("nome"));
                lista.add(c);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
