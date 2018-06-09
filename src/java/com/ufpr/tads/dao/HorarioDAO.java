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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public Horario getHorario(String diaSemana, Date horaInicial, Date horaLimite) {
        Horario h = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idHorario, diaSemana, horaInicial, horaLimite "
                    + "FROM Horario WHERE diaSemana = ? , horaInicial = ? , horaLimite = ? "
            );
            st.setString(1, diaSemana);
            st.setDate(2,new java.sql.Date(horaInicial.getTime()));
            st.setDate(3, new java.sql.Date(horaLimite.getTime()));
            
            rs = st.executeQuery();
            while(rs.next()){
                h = new Horario();
                h.setIdHorario(rs.getInt("idHorario"));
                h.setDiaSemana(rs.getString("diaSemana"));
                h.setHoraInicial(rs.getDate("horaInicial"));
                h.setHoraLimite(rs.getDate("horaLimite"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return h;
    }

    public List<Horario> getListaHorario(int idPreferencia){
        List<Horario> lista = new ArrayList<Horario>();
        Horario h;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                              "SELECT horario.idHorario, horario.diaSemana, "
                            + "horario.horaInicial, horario.horaLimite "
                            + "FROM preferencias_has_horario "
                            + "INNER JOIN horario ON horario.idHorario = preferencias_has_horario.Horario_idHorario "
                            + "WHERE preferencias_has_horario.Preferencias_idPreferencias = ? "
            );
            st.setInt(1, idPreferencia);
            
            rs = st.executeQuery();
            while(rs.next()){
                h = new Horario();
                h.setIdHorario(rs.getInt("horario.idHorario"));
                h.setDiaSemana(rs.getString("horario.diaSemana"));
                h.setHoraInicial(rs.getDate("horario.horaInicial"));
                h.setHoraLimite(rs.getDate("horario.horaLimite"));
                lista.add(h);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    
    }
    public int insertHorario(Horario h) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT INTO horario(diaSemana, horaInicial, horaLimite) "
                    + "VALUES(?,?,?) ",Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, h.getDiaSemana());
            st.setDate(2,new java.sql.Date(h.getHoraInicial().getTime()));
            st.setDate(3, new java.sql.Date(h.getHoraLimite().getTime()));
            
            st.executeUpdate();
            
            rs = st.getGeneratedKeys();
            
            if(rs.next()) return rs.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return 0;
    }

    public boolean insertHorarioPreferencia(int aux, List<Horario> horario) { 
        Horario aux2;
        int aux3;
        if(horario != null && !horario.isEmpty()){
            for(Horario h : horario){
                if(h.getIdHorario() == 0){
                    aux2 = getHorario(h.getDiaSemana(),h.getHoraInicial(),h.getHoraLimite());
                    if(aux2 != null){
                        aux3 = aux2.getIdHorario();
                    }
                    else{
                        aux3 = insertHorario(h);
                    }
                    if(aux3 == 0) return false;
                    if(!insertHorarioPreferencia(aux,aux3)) return false;
                }
            }
        }
        
        return true;
    }

    public boolean insertHorarioPreferencia(int idPreferencia, int idHorario) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                        "INSERT INTO preferencias_has_Horario(Horario_idHorario, Preferencias_idPreferencias) "
                      + "VALUES (?,?)"
            );
            st.setInt(1, idHorario);
            st.setInt(2, idPreferencia);
            
            if(st.executeUpdate() > 0) return true;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;




    }

    public boolean deleteHorarioPreferencia(int idPreferencia) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                        "DELETE FROM preferencias_has_Horario WHERE Preferencias_idPreferencias = ? "
            );
            st.setInt(1, idPreferencia);
            
            if(st.executeUpdate() > 0) return true;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
