/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Convite;
import com.ufpr.tads.beans.Encontro;
import com.ufpr.tads.beans.Local;
import com.ufpr.tads.beans.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ArtVin
 */
public class PagamentoDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public PagamentoDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public PagamentoDAO(Connection con){
        this.con = con;
    }

    public int insertPagamento(Pagamento pagamento) {
        PreparedStatement st;
        try {
            st = con.prepareStatement(
                    "INSERT INTO pagamento(tipo, valor ) "
                    + "VALUES (?,?)",Statement.RETURN_GENERATED_KEYS
            );
            
            st.setString(1, pagamento.getTipo() );
            st.setFloat(2, pagamento.getValor());
            
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return 0;
    
    
    }
}
