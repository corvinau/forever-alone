/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Descricao;
import com.ufpr.tads.beans.Usuario;
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
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS
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
    
    public boolean updateCliente(Cliente c){
        PreparedStatement st;
        int aux;
        if(c.getIdCliente() > 0){
            try {
                st = con.prepareStatement(
                        "UPDATE cliente SET nome = ?,disponibilidade = ?,"
                        + " qtdTokens = ?, Endereco_idEndereco = ?, "
                        + " Descricao_idDescricao = ?,Preferencias_idPreferencias = ? "
                        + " WHERE idCliente = ? "
                );
                st.setString(1, c.getNome());
                st.setBoolean(2, c.isDisp());
                st.setInt(3,c.getQtdTokens());
                if(c.getEndereco() != null){
                    EnderecoDAO enderecoDAO = new EnderecoDAO(con);
                    if(c.getEndereco().getIdEndereco() == 0){
                        aux = enderecoDAO.insertEndereco(c.getEndereco());
                        c.getEndereco().setIdEndereco(aux);
                    }
                    else {
                        enderecoDAO.updateEndereco(c.getEndereco());
                    }
                    st.setInt(4, c.getEndereco().getIdEndereco());
                }
                else{
                    st.setNull(4, java.sql.Types.INTEGER);
                }
                if(c.getDescricao() != null){
                    DescricaoDAO descricaoDAO = new DescricaoDAO(con);
                    if(c.getDescricao().getIdDescricao() == 0){
                        aux = descricaoDAO.insertDescricao(c.getDescricao());
                        c.getDescricao().setIdDescricao(aux);
                    }
                    else {
                        descricaoDAO.updateDescricao(c.getDescricao());
                    }
                    st.setInt(5, c.getDescricao().getIdDescricao());
                }
                else{
                    st.setNull(5, java.sql.Types.INTEGER);
                }
                if(c.getPreferencia() != null){
                    PreferenciaDAO preferenciaDAO = new PreferenciaDAO(con);
                    if(c.getPreferencia().getIdPreferencias() == 0){
                        aux = preferenciaDAO.insertPreferencia(c.getPreferencia());
                        c.getPreferencia().setIdPreferencias(aux);
                    }
                    else {
                        preferenciaDAO.updatePreferencia(c.getPreferencia());
                    }
                    st.setInt(6, c.getPreferencia().getIdPreferencias());
                }
                else{
                    st.setNull(6, java.sql.Types.INTEGER);
                }
                st.setInt(7, c.getIdCliente());
                
                int rowsAffected = st.executeUpdate();

                if(rowsAffected > 0) return true;

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }

    public List<Cliente> getListaCliente() {
        List<Cliente> lista = new ArrayList<Cliente>();
        Cliente c ;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT C.idCliente, C.nome, C.cpf, "
                    + "C.sexo, C.disponibilidade, "
                    + "C.Descricao_idDescricao, D.resumo, "
                    + "C.Usuario_idUsuario, U.email "
                    + "FROM Cliente C "
                    + "INNER JOIN usuario U ON C.Usuario_idUsuario = U.idUsuario "
                    + "INNER JOIN descricao D ON C.Descricao_idDescricao = D.idDescricao "
            );
            
            rs = st.executeQuery();
            Descricao descricao;
            while(rs.next()){
                c = new Cliente();
                c.setIdCliente(rs.getInt("C.idCliente"));
                c.setNome(rs.getString("C.nome"));
                c.setCpf(rs.getString("C.cpf"));
                c.setSexo(rs.getString("C.sexo").charAt(0));
                c.setDisp(rs.getBoolean("C.disponibilidade"));
                descricao = new Descricao();
                descricao.setIdDescricao(rs.getInt("C.Descricao_idDescricao"));
                descricao.setResumo(rs.getString("D.resumo"));
                c.setDescricao(descricao);
                c.setEmail(rs.getString("U.email"));
                lista.add(c);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return lista;
    }
    
}
