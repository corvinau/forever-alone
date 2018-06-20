/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Encontro;
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
public class EncontroDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public EncontroDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public EncontroDAO(Connection con){
        this.con = con;
    }

    public Encontro getEncontroByConvite(int idConvite) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT E.idEncontro FROM encontro E "
                    + "WHERE Convite_idConvite = ?"
            );
            st.setInt(1, idConvite);
            
            rs = st.executeQuery();
            if(rs.next()) return getEncontro(rs.getInt(1));
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }

    private Encontro getEncontro(int idEncontro) {
        PreparedStatement st;
        Encontro encontro = null;
        try {
            st = con.prepareStatement(
                    "SELECT idEncontro, data, hora, Status_idStatus, Cliente_idCliente, "
                    + "Convite_idConvite, Local_idLocal "
                    + "FROM encontro  "
                    + "WHERE idEncontro = ?"
            );
            st.setInt(1, idEncontro);
            StatusDAO statusDAO = new StatusDAO(con);
            ClienteDAO clienteDAO = new ClienteDAO(con);
            LocalDAO localDAO = new LocalDAO(con);
            
            rs = st.executeQuery();
            if(rs.next()){
                encontro = new Encontro();
                encontro.setIdEncontro(rs.getInt("idEncontro"));
                encontro.setData(rs.getDate("data"));
                encontro.setHora(rs.getDate("hora"));
                encontro.setStatus(statusDAO.getStatus(rs.getInt("Status_idStatus")));
                encontro.setCliente(clienteDAO.getCliente(rs.getInt("Cliente_idCliente")));
                encontro.setLocal(localDAO.getLocal(rs.getInt("Local_idLocal")));
            }
            return encontro;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }

    public List<Encontro> getListaEncontroCliente(int idCliente) {
        List<Encontro> lista = new ArrayList<Encontro>();
        PreparedStatement st;
        Encontro encontro = null;
        try {
            st = con.prepareStatement(
                    "SELECT idEncontro, data, hora, Status_idStatus, Cliente_idCliente, "
                    + "Convite_idConvite, Local_idLocal "
                    + "FROM encontro  "
                    + "WHERE Cliente_idCliente = ?"
            );
            st.setInt(1, idCliente);
            
            StatusDAO statusDAO = new StatusDAO(con);
            ClienteDAO clienteDAO = new ClienteDAO(con);
            LocalDAO localDAO = new LocalDAO(con);
            ConviteDAO conviteDAO = new ConviteDAO(con);
            
            rs = st.executeQuery();
            while(rs.next()){
                encontro = new Encontro();
                encontro.setIdEncontro(rs.getInt("idEncontro"));
                encontro.setData(rs.getDate("data"));
                encontro.setHora(rs.getDate("hora"));
                encontro.setStatus(statusDAO.getStatus(rs.getInt("Status_idStatus")));
                encontro.setCliente(clienteDAO.getCliente(rs.getInt("Cliente_idCliente")));
                encontro.setLocal(localDAO.getLocal(rs.getInt("Local_idLocal")));
                encontro.setConvite(conviteDAO.getConviteEncontro(rs.getInt("Convite_idConvite")));
                lista.add(encontro);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
}
