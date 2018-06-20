/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.dao;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Convite;
import com.ufpr.tads.beans.Encontro;
import com.ufpr.tads.beans.Horario;
import com.ufpr.tads.beans.Local;
import com.ufpr.tads.beans.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
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

    public int insertEncontro(Cliente usuarioLogado, int idCliente, Pagamento pagamento) {
        PreparedStatement st;
        Encontro encontro = null;
        try {
            st = con.prepareStatement(
                    "INSERT INTO encontro( Status_idStatus , Cliente_idCliente , Pagamento_idPagamento, "
                    + "Convite_idConvite , Local_idLocal, data , hora ) "
                    + "VALUES ( ? , ? , ? , ? , ? , ? , ? )",Statement.RETURN_GENERATED_KEYS
            );
            
            st.setInt(1, 1);
            st.setInt(2, usuarioLogado.getIdCliente());
            PagamentoDAO pagamentoDAO = new PagamentoDAO();
            if(pagamento.getIdPagamento() <= 0){
                pagamento.setIdPagamento(pagamentoDAO.insertPagamento(pagamento));
                if(pagamento.getIdPagamento() <= 0){
                    return 0;
                }
            }
            st.setInt(3, pagamento.getIdPagamento());
            ConviteDAO conviteDAO = new ConviteDAO(con);
            Convite convite = new Convite();
            Cliente convidado = new Cliente();
            convidado.setIdCliente(idCliente);
            convite.setConvidado(convidado);
            convite.setTipo("E");
            convite.setStatus("Aguardando");
            int aux = conviteDAO.insertConvite(convite);
            if(aux > 0){
                st.setInt(4,aux);
            }
            else{
                return 0;
            }
            
            LocalDAO localDAO = new LocalDAO(con);
            Local local = localDAO.getRandomLocal(usuarioLogado.getEndereco().getCidade().getIdCidade());
            if(local == null){
                local = new Local();
                local.setIdLocal(1);
            }
            st.setInt(5, local.getIdLocal());
            ClienteDAO clienteDAO = new ClienteDAO(con);
            Date data = new Date(System.currentTimeMillis());
            Date hora = new Date(100000000);
            geraDataHora(usuarioLogado.getPreferencia().getHorario(), clienteDAO.getCliente(idCliente),data,hora);
            st.setDate(6, new java.sql.Date(data.getTime()));
            st.setTimestamp(7, new java.sql.Timestamp(hora.getTime()));
            
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return 0;
    }

    private void geraDataHora(List<Horario> horario, Cliente cliente, Date data, Date hora) {
        if(cliente != null && cliente.getPreferencia() != null){
            List<Horario> horariosConvidado = cliente.getPreferencia().getHorario();
            if(horario != null && !horario.isEmpty() && horariosConvidado != null && !horariosConvidado.isEmpty()){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(data);
                calendar.add(Calendar.DATE, 2);
                Date menor;
                Date maior;
                Random rand = new Random();
                int dayOfTheWeek;
                long range;
                for(Horario h :horario){
                    for(Horario hCliente:horariosConvidado){
                        if(h.getDiaSemana().equals(hCliente.getDiaSemana())){
                            switch (h.getDiaSemana()){
                                case "Segunda": dayOfTheWeek = Calendar.MONDAY; break;
                                case "Terca": dayOfTheWeek = Calendar.TUESDAY; break;
                                case "Quarta": dayOfTheWeek = Calendar.WEDNESDAY; break;
                                case "Quinta": dayOfTheWeek = Calendar.THURSDAY; break;
                                case "Sexta": dayOfTheWeek = Calendar.FRIDAY; break;
                                case "Sabado": dayOfTheWeek = Calendar.SATURDAY; break;
                                default : dayOfTheWeek = Calendar.SUNDAY; break;
                            }
                            if(h.getHoraInicial().getTime() < hCliente.getHoraInicial().getTime()){
                                menor = hCliente.getHoraInicial();
                            }
                            else{
                                menor = h.getHoraInicial();
                            }

                            if(h.getHoraLimite().getTime() < hCliente.getHoraLimite().getTime()){
                                maior = h.getHoraLimite();
                            }
                            else{
                                maior = hCliente.getHoraLimite();
                            }
                            range = maior.getTime() - menor.getTime();
                            if(menor.getTime() < maior.getTime()){
                                while(calendar.get(Calendar.DAY_OF_WEEK) != dayOfTheWeek){
                                    calendar.add(Calendar.DATE, 1);
                                }
                                data.setTime(calendar.getTime().getTime());
                                hora.setTime(menor.getTime() + rand.nextInt(Integer.parseInt(range + "")));
                                return;
                            }
                        }
                    }
                }
            }
        }
        
    }

    public boolean updateEncontro(int idConvite, String confirmado) {
        PreparedStatement st;
        Encontro encontro = null;
        try {
            st = con.prepareStatement(
                    "UPDATE encontro SET Status_idStatus = ? "
                    + "WHERE Convite_idConvite = ?"
            );
            st.setString(1, confirmado);
            st.setInt(2, idConvite);
            
            int aux = st.executeUpdate();
            if(aux > 0) return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    public Cliente getOutroEncontro(int idEncontro,int idCliente){
        PreparedStatement st;
        Encontro encontro = null;
        try {
            st = con.prepareStatement(
                    "SELECT Cliente_idCliente, Convite_idConvite FROM encontro E "
                    + "WHERE idEncontro = ?"
            );
            st.setInt(1, idEncontro);
            
            rs = st.executeQuery();
            if(rs.next()){
                int aux = rs.getInt("Cliente_idCliente");
                if(aux == idCliente){
                    ConviteDAO conviteDao = new ConviteDAO();
                    return conviteDao.getConviteEncontro(rs.getInt("Convite_idConvite")).getConvidado();
                }
                else{
                    ClienteDAO clienteDao = new ClienteDAO();
                    clienteDao.getCliente(aux);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
    
    public boolean remarcarEncontro(int idEncontro,Cliente usuarioLogado) {
        PreparedStatement st;
        Encontro encontro = null;
        try {
            st = con.prepareStatement(
                    "UPDATE encontro SET Status_idStatus = 'Remarcado' "
                    + " data = ? , hora = ?  WHERE idEncontro = ?"
            );
            Date data = new Date(System.currentTimeMillis());
            Date hora = new Date(100000000);
            geraDataHora(usuarioLogado.getPreferencia().getHorario(), getOutroEncontro(idEncontro,usuarioLogado.getIdCliente()),data,hora);
            st.setDate(1, new java.sql.Date(data.getTime()));
            st.setTimestamp(2, new java.sql.Timestamp(hora.getTime()));
            st.setInt(3, idEncontro);
            
            int aux = st.executeUpdate();
            
            if(aux > 0) return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    public boolean cancelarEncontro(int idEncontro, Cliente usuarioLogado) {
         PreparedStatement st;
        try {
            st = con.prepareStatement(
                    "UPDATE encontro SET Status_idStatus = 'Cancelado' "
                    + "WHERE idEncontro = ? "
            );
            st.setInt(1, idEncontro);
            
            Cliente c = getOutroEncontro(idEncontro,usuarioLogado.getIdCliente());
            ClienteDAO clienteDao = new ClienteDAO(con);
            c.setQtdTokens(c.getQtdTokens()+1);
            clienteDao.updateCliente(c);
            
            int aux = st.executeUpdate();
            
            if(aux > 0) return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }
}
