/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Preferencia;
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
public class PreferenciaDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public PreferenciaDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public PreferenciaDAO(Connection con){
        this.con = con;
    }
    
    public Preferencia getPreferencia(int idPreferencia){
        Preferencia p = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idPreferencias, sexo, idadeMin, idadeMax"
                    + " FROM Preferencias WHERE idPreferencias = ?"
            );
            st.setInt(1, idPreferencia);
            
            rs = st.executeQuery();
            CorCabeloDAO corCabeloDAO = new CorCabeloDAO(con);
            CorPeleDAO corPeleDAO = new CorPeleDAO(con);
            HorarioDAO horarioDAO = new HorarioDAO(con);
            while(rs.next()){
                p = new Preferencia();
                p.setIdPreferencias(idPreferencia);
                p.setIdadeMin(rs.getInt("idadeMin"));
                p.setIdadeMax(rs.getInt("idadeMax"));
                p.setSexos(rs.getString("sexo").charAt(0));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return p;
    }
}
