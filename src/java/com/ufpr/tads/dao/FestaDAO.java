/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Convite;
import com.ufpr.tads.beans.Endereco;
import com.ufpr.tads.beans.Festa;
import com.ufpr.tads.beans.Funcionario;
import com.ufpr.tads.beans.Local;
import com.ufpr.tads.beans.Status;
import com.ufpr.tads.beans.UF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ArtVin
 */
public class FestaDAO {
    private Connection con;
    private ResultSet rs;
    
    
    public FestaDAO(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public FestaDAO(Connection con){
        this.con = con;
    }

    public List<Festa> getListaFesta() {
        List<Festa> listaFesta = new ArrayList<Festa>();
        Festa f = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT F.idFesta, F.data, F.tema, F.hora ,S.idStatus , S.nome "
                    + "FROM Festa F "
                    + "INNER JOIN status S ON F.Status_idStatus = S.idStatus "
            );
            
            rs = st.executeQuery();
            Status status;
            while(rs.next()){
                f = new Festa();
                f.setIdFesta(rs.getInt("F.idFesta"));
                f.setData(rs.getDate("F.data"));
                f.setTema(rs.getString("F.tema"));
                f.setHora(rs.getTimestamp("F.hora"));
                status = new Status();
                status.setIdStatus(rs.getInt("S.idStatus"));
                status.setNome(rs.getString("S.nome"));
                f.setStatus(status);
                listaFesta.add(f);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return listaFesta;
    }

    public int createFesta(Festa f) {
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "INSERT INTO festa( data, tema, hora,Local_idLocal, Funcionario_idFuncionario , Status_idStatus) "
                    + "VALUES(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS
            );
            st.setDate(1, new java.sql.Date(f.getData().getTime()));
            st.setString(2, f.getTema());
            st.setTimestamp(3, new java.sql.Timestamp(f.getHora().getTime()));
            st.setInt(4, f.getLocal().getIdLocal());
            st.setInt(5, f.getFunc().getIdFuncionario());
            st.setInt(6, f.getStatus().getIdStatus());
            
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return 0;
    }
    
    public List<Convite> getConvites(int idFesta){
        List<Convite> listaConvites = new ArrayList<Convite>();
        Festa f = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "Festa_idFesta, Convite_idConvite idConvite, status, tipo, Pagamento_idPagamento, Cliente_idCliente" +
                    "SELECT F.idFesta, F.data, F.tema, F.hora ,S.idStatus , S.nome "
                    + "FROM Festa F "
                    + "INNER JOIN status S ON F.Status_idStatus = S.idStatus "
            );
            
            rs = st.executeQuery();
            Status status;
            while(rs.next()){
                f = new Festa();
                f.setIdFesta(rs.getInt("F.idFesta"));
                f.setData(rs.getDate("F.data"));
                f.setTema(rs.getString("F.tema"));
                f.setHora(rs.getTimestamp("F.hora"));
                status = new Status();
                status.setIdStatus(rs.getInt("S.idStatus"));
                status.setNome(rs.getString("S.nome"));
                f.setStatus(status);
                listaConvites.add(f);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaConvites;
    }
    
    public Festa getFesta(int idFesta) {
        Festa f = null;
        PreparedStatement st;
        
        try {
            st = con.prepareStatement(
                    "SELECT F.idFesta, F.data, F.tema, F.hora , S.idStatus , S.nome, "
                    + "FU.idFuncionario, FU.nome, L.nomeEstabelecimento, L.idLocal , E.bairro, E.rua, "
                    + "E.numero, E.complemento, E.idEndereco, C.nome, C.idCidade, UF.nome, UF.sigla, UF.idUF "
                    + "FROM Festa F "
                    + "INNER JOIN status S ON F.Status_idStatus = S.idStatus "
                    + "INNER JOIN funcionario FU ON F.Funcionario_idFuncionario = FU.idFuncionario "
                    + "INNER JOIN local L ON F.Local_idLocal = L.idLocal "
                    + "INNER JOIN endereco E ON L.Endereco_idEndereco = E.idEndereco "
                    + "INNER JOIN cidade C ON E.Cidade_idCidade = C.idCidade "
                    + "INNER JOIN uf UF ON C.UF_idUF = UF.idUF "
            );
            
            rs = st.executeQuery();
            Status status;
            Funcionario func;
            Local local;
            Endereco endereco;
            Cidade cidade;
            UF uf;
            while(rs.next()){
                f = new Festa();
                f.setIdFesta(rs.getInt("F.idFesta"));
                f.setData(rs.getDate("F.data"));
                f.setTema(rs.getString("F.tema"));
                f.setHora(rs.getTimestamp("F.hora"));
                
                status = new Status();
                status.setIdStatus(rs.getInt("S.idStatus"));
                status.setNome(rs.getString("S.nome"));
                f.setStatus(status);
                
                func = new Funcionario();
                func.setIdFuncionario(rs.getInt("FU.idFuncionario"));
                func.setNome(rs.getString("FU.nome"));
                f.setFunc(func);
                
                uf = new UF();
                uf.setIdUF(rs.getInt("UF.idUF"));
                uf.setNome(rs.getString("UF.nome"));
                uf.setSigla(rs.getString("UF.sigla"));
                
                cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("C.idCidade"));
                cidade.setNome(rs.getString("C.nome"));
                cidade.setUf(uf);
                
                endereco = new Endereco();
                endereco.setBairro(rs.getString("E.bairro"));
                endereco.setRua(rs.getString("E.rua"));
                endereco.setNumero(rs.getInt("E.numero"));
                endereco.setComplemento(rs.getString("E.complemento"));
                endereco.setCidade(cidade);
                
                local = new Local();
                local.setIdLocal(rs.getInt("L.idLocal"));
                local.setNomeEstabelecimento(rs.getString("L.nomeEstabelecimento"));
                local.setEndereco(endereco);
                
                f.setLocal(local);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return f;
    }
}
