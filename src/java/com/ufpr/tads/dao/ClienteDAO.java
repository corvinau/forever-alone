/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Usuario;
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
public class ClienteDAO {
    
    private Connection con;
    private ResultSet rs;
    
    public ClienteDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ClienteDAO(Connection con){
        this.con = con;
    }
    
    public Cliente getCliente(Usuario u){
        Cliente c = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT idCliente, nome, cpf, dataNascimento,"
                    + " dataCadastro, sexo, disponibilidade, qtdTokens, "
                    + "Endereco_idEndereco, Descricao_idDescricao, "
                    + "Preferencias_idPreferencias "
                    + "FROM Cliente WHERE Usuario_idUsuario = ?"
            );
            st.setInt(1, u.getIdUsuario());
            
            rs = st.executeQuery();
            EnderecoDAO enderecoDAO = new EnderecoDAO(con);
            DescricaoDAO descricaoDAO = new DescricaoDAO(con);
            PreferenciaDAO preferenciaDAO = new PreferenciaDAO(con);
            while(rs.next()){
                c = new Cliente();
                c.setIdUsuario(u.getIdUsuario());
                c.setEmail(u.getEmail());
                c.setTipo(u.getTipo());
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setDataNasc(rs.getDate("dataNascimento"));
                c.setDataCadast(rs.getDate("dataCadastro"));
                c.setSexo(rs.getString("sexo").charAt(0));
                c.setDisp(rs.getBoolean("disponibilidade"));
                c.setQtdTokens(rs.getInt("qtdTokens"));
                c.setEndereco(enderecoDAO.getEndereco(rs.getInt("Endereco_idEndereco")));
                c.setDescricao(descricaoDAO.getDescricao(rs.getInt("Descricao_idDescricao")));
                c.setPreferencia(preferenciaDAO.getPreferencia(rs.getInt("Preferencias_idPreferencias")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return c;
    }
    
}
