/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.CorCabelo;
import com.ufpr.tads.beans.Horario;
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
public class HorarioDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public HorarioDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public HorarioDAO(Connection con){
        this.con = con;
    }
    
    public Horario getHorario(int idHorario){
        Horario h = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idHorario, diaSemana, horaInicial, horaLimite "
                    + "FROM Horario WHERE idHorario = ?"
            );
            st.setInt(1, idHorario);
            
            rs = st.executeQuery();
            while(rs.next()){
                h = new Horario();
                h.setIdHorario(idHorario);
                h.setDiaSemana(rs.getString("diaSemana"));
                h.setHoraInicial(rs.getDate("horaInicial"));
                h.setHoraLimite(rs.getDate("horaLimite"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return h;
    }
}
