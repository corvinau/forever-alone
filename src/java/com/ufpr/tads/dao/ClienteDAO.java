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
import java.util.Date;
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
    public int insertCliente(Cliente c){
        PreparedStatement st;
        int aux;
        try {
            st = con.prepareStatement(
                    "INSERT INTO cliente(Usuario_idUsuario,nome, cpf, dataNascimento,"
                    + "dataCadastro, sexo, disponibilidade, qtdTokens, "
                    + "Endereco_idEndereco, Descricao_idDescricao, "
                    + "Preferencias_idPreferencias) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)"
            );
            st.setInt(1, c.getIdUsuario());
            st.setString(2, c.getNome());
            st.setString(3, c.getCpf());
            st.setDate(4,new java.sql.Date(c.getDataNasc().getTime()));
            Date dateNow = new Date();
            st.setDate(5,new java.sql.Date(dateNow.getTime()));
            st.setString(6, c.getSexo() + "");
            st.setBoolean(7, c.isDisp());
            st.setInt(8,c.getQtdTokens());
            if(c.getEndereco() != null){
                if(c.getEndereco().getIdEndereco() == 0){
                    EnderecoDAO enderecoDAO = new EnderecoDAO(con);
                    aux = enderecoDAO.insertEndereco(c.getEndereco());
                    c.getEndereco().setIdEndereco(aux);
                    st.setInt(9, c.getEndereco().getIdEndereco());
                }
                else st.setNull(9, java.sql.Types.INTEGER);
            }
            else{
                st.setNull(9, java.sql.Types.INTEGER);
            }
            if(c.getDescricao() != null){
                if(c.getDescricao().getIdDescricao() == 0){
                    DescricaoDAO descricaoDAO = new DescricaoDAO(con);
                    aux = descricaoDAO.insertDescricao(c.getDescricao());
                    c.getDescricao().setIdDescricao(aux);
                    st.setInt(10, c.getDescricao().getIdDescricao());
                }
                else st.setNull(10, java.sql.Types.INTEGER);
            }
            else{
                st.setNull(10, java.sql.Types.INTEGER);
            }
            if(c.getPreferencia() != null){
                if(c.getPreferencia().getIdPreferencias() == 0){
                    PreferenciaDAO preferenciaDAO = new PreferenciaDAO(con);
                    aux = preferenciaDAO.insertPreferencia(c.getPreferencia());
                    c.getPreferencia().setIdPreferencias(aux);
                    st.setInt(11, c.getPreferencia().getIdPreferencias());
                }
                else st.setNull(11, java.sql.Types.INTEGER);
            }
            else{
                st.setNull(11, java.sql.Types.INTEGER);
            }
            
            st.executeUpdate();
            
            rs = st.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return 0;
    }
    
}
