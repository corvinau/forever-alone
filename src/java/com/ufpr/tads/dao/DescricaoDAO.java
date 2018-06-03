/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Descricao;
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
public class DescricaoDAO {
     private Connection con;
    private ResultSet rs;
    
    
    public DescricaoDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public DescricaoDAO(Connection con){
        this.con = con;
    }
    
    
    public Descricao getDescricao(int idDescricao){
        Descricao d = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idDescricao, resumo, CorCabelo_idCorCabelo, "
                    + "CorPele_idCorPele FROM Descricao WHERE idDescricao = ?"
            );
            st.setInt(1, idDescricao);
            
            rs = st.executeQuery();
            CorCabeloDAO corCabeloDAO = new CorCabeloDAO(con);
            CorPeleDAO corPeleDAO = new CorPeleDAO(con);
            while(rs.next()){
                d = new Descricao();
                d.setIdDescricao(idDescricao);
                d.setResumo(rs.getString("resumo"));
                d.setCorCabelo(corCabeloDAO.getCorCabelo(rs.getInt("CorCabelo_idCorCabelo")));
                d.setCorPele(corPeleDAO.getCorPele(rs.getInt("CorPele_idCorPele")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return d;
    }

    public int insertDescricao(Descricao descricao) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "INSERT INTO descricao(resumo, CorCabelo_idCorCabelo, "
                    + "CorPele_idCorPele) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, descricao.getResumo());
            st.setInt(2, descricao.getCorCabelo().getIdCorCabelo());
            st.setInt(3, descricao.getCorPele().getIdCorPele());
            
            st.executeUpdate();
            
            rs = st.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return 0;
    
    
    }
}
