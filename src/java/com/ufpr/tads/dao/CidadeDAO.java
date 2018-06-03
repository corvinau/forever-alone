/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Endereco;
import com.ufpr.tads.beans.UF;
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
public class CidadeDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public CidadeDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public CidadeDAO(Connection con){
        this.con = con;
    }
    
    public Cidade getCidade(int idCidade){
        Cidade c = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idCidade, nome, UF_idUF"
                    + " FROM Cidade WHERE idCidade = ?"
            );
            st.setInt(1, idCidade);
            
            rs = st.executeQuery();
            UFDAO ufDAO = new UFDAO(con);
            while(rs.next()){
                c = new Cidade();
                c.setIdCidade(idCidade);
                c.setNome(rs.getString("nome"));
                c.setUf(ufDAO.getUF(rs.getInt("UF_idUF")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return c;
    }

    public List<Cidade> getListaCidade(int idEstado) {
        List<Cidade> lista = new ArrayList<Cidade>();
        Cidade c = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idCidade, nome, UF_idUF"
                    + " FROM Cidade WHERE UF_idUF = ?"
            );
            st.setInt(1, idEstado);
            
            rs = st.executeQuery();
            UFDAO ufDAO = new UFDAO(con);
            while(rs.next()){
                c = new Cidade();
                c.setIdCidade(rs.getInt("idCidade"));
                c.setNome(rs.getString("nome"));
                UF uf = new UF();
                uf.setIdUF(idEstado);
                c.setUf(uf);
                lista.add(c);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return lista;
    }
}
