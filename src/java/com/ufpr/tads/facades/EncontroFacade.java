/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.facades;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Encontro;
import com.ufpr.tads.beans.Horario;
import com.ufpr.tads.beans.Pagamento;
import com.ufpr.tads.dao.ClienteDAO;
import com.ufpr.tads.dao.ConviteDAO;
import com.ufpr.tads.dao.EncontroDAO;
import com.ufpr.tads.dao.PagamentoDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ArtVin
 */
public class EncontroFacade {

    public static List<Encontro> getListaEncontroCliente(int idCliente) {
        EncontroDAO encontroDao = new EncontroDAO();
        return encontroDao.getListaEncontroCliente(idCliente);
    }
    
    public static Encontro getEncontroConvite(int idEncontro){
        EncontroDAO encontroDao = new EncontroDAO();
        return encontroDao.getEncontroConvite(idEncontro);
    }

    public static List<Cliente> getClientesCompativeis(Cliente usuarioLogado) {
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> lista = clienteDao.getClientesCompativeis(usuarioLogado);
        List<Horario> horarios;
        List<Horario> horariosCliente = usuarioLogado.getPreferencia().getHorario();
        Date menor;
        Date maior;
        for(Cliente c :lista){
            horarios = c.getPreferencia().getHorario();
            for(Horario h :horarios){
                for(Horario hCliente:horariosCliente){
                    if(h.getDiaSemana().equals(hCliente.getDiaSemana())){
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
                        if(menor.getTime() > maior.getTime()){
                            lista.remove(c);
                        }
                    }
                }
            }
        }
        return lista;
    }

    public static boolean insertConvites(Cliente usuarioLogado, String[] idClientes, Pagamento pagamento) {
        EncontroDAO encontroDao = new EncontroDAO();
        for( int i = 0 ; i < idClientes.length; i++){
            encontroDao.insertEncontro(usuarioLogado,Integer.parseInt(idClientes[i]),pagamento);
        }
        return true;
    }

    public static boolean aceitaEncontro(int idConvite) {
        ConviteDAO conviteDao = new ConviteDAO();
        if(conviteDao.aceitarConvite(idConvite)){
            EncontroDAO encontroDao = new EncontroDAO();
            if(encontroDao.updateEncontro(idConvite,2)){
                return true;
            }
        }
        return false;
       
    }

    public static boolean remarcarEncontro(int idEncontro,Cliente usuarioLogado) {
        EncontroDAO encontroDao = new EncontroDAO();
        if(encontroDao.remarcarEncontro(idEncontro,usuarioLogado)){
            return true;
        }
        
        return false;
    }

    public static boolean cancelarEncontro(int idConvite, Cliente usuarioLogado) {
        EncontroDAO encontroDao = new EncontroDAO();
        if(encontroDao.cancelarEncontro(idConvite,usuarioLogado)){
            return true;
        }
        
        return false;
    }
    
}
