/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Festa;
import com.ufpr.tads.beans.Funcionario;
import com.ufpr.tads.beans.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ArtVin
 */
public class FestaDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public FestaDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public FestaDAO(Connection con){
        this.con = con;
    }

    public List<Festa> getListaFesta() {
        List<Festa> listaFesta = new ArrayList<Festa>();
        Festa f = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idFesta, data, tema, hora "
                    + "FROM Festa"
            );
            
            rs = st.executeQuery();
            Funcionario func;
            while(rs.next()){
                f = new Festa();
                f.setIdFesta(rs.getInt("idFesta"));
                f.setData(rs.getDate("data"));
                f.setTema(rs.getString("tema"));
                f.setHora(rs.getTimestamp("hora"));
                listaFesta.add(f);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return listaFesta;
    }

    public int createFesta(Festa f) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "INSERT INTO festa( data, tema, hora,Local_idLocal, Funcionario_idFuncionario , Status_idStatus) "
                    + "VALUES(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS
            );
            st.setDate(1, new java.sql.Date(f.getData().getTime()));
            st.setString(2, f.getTema());
            st.setTimestamp(3, new java.sql.Timestamp(f.getHora().getTime()));
            st.setInt(4, f.getLocal().getIdLocal());
            st.setInt(5, f.getFunc().getIdFuncionario());
            st.setInt(6, f.getStatus().getIdStatus());
            
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return 0;
    }
}
