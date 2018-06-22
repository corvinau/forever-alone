/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Casamento;
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
public class CasamentoDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public CasamentoDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CasamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CasamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public CasamentoDAO(Connection con){
        this.con = con;
    }

    public Casamento getCasamentoByConvite(int idConvite) {
        PreparedStatement st;
        Casamento casamento = null;
        try {
            st = con.prepareStatement(
                    "SELECT idCasamento, status, data, hora, qtdConvidados, nomePadre, "
                    + "igreja, localLuaMel, Cliente_idCliente, Convite_idConvite  "
                    + "FROM casamento "
                    + "WHERE Convite_idConvite = ? "
            );
            st.setInt(1, idConvite);
            ClienteDAO clienteDao = new ClienteDAO();
            ConviteDAO conviteDao = new ConviteDAO();
            rs = st.executeQuery();
            if(rs.next()) {
                casamento = new Casamento();
                casamento.setIdCasamento(rs.getInt("idCasamento"));
                casamento.setStatus(rs.getString("status"));
                casamento.setData(rs.getDate("data"));
                casamento.setHora(rs.getTimestamp("hora"));
                casamento.setQtdConvidados(rs.getInt("qtdConvidados"));
                casamento.setNomePadre(rs.getString("nomePadre"));
                casamento.setIgreja((rs.getString("igreja")));
                casamento.setLocalLuaDeMel(rs.getString("localLuaMel"));
                casamento.setCliente(clienteDao.getCliente(rs.getInt("Cliente_idCliente")));
                casamento.setConvite(conviteDao.getConviteEvento(idConvite));
                return casamento;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return casamento;
    }

    public int insertCasamento(Casamento casamento) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "INSERT INTO casamento(status, data, hora, qtdConvidados, nomePadre, "
                    + "igreja, localLuaMel, Cliente_idCliente, Convite_idConvite) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS
            );
            if(casamento.getConvite().getIdConvite() <= 0){
                ConviteDAO conviteDao = new ConviteDAO(con);
                int aux = conviteDao.insertConvite(casamento.getConvite());
                if(aux <= 0){
                    return 0;
                }
                casamento.getConvite().setIdConvite(aux);
            }
            st.setString(1, casamento.getStatus());
            st.setDate(2, new java.sql.Date(casamento.getData().getTime()));
            st.setTimestamp(3, new java.sql.Timestamp(casamento.getHora().getTime()));
            st.setInt(4, casamento.getQtdConvidados());
            st.setString(5, casamento.getNomePadre());
            st.setString(6, casamento.getIgreja());
            st.setString(7, casamento.getLocalLuaDeMel());
            st.setInt(8, casamento.getCliente().getIdCliente());
            st.setInt(9, casamento.getConvite().getIdConvite());
         
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return 0;
    }
}
