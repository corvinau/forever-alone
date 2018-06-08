/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.facades;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.CorCabelo;
import com.ufpr.tads.beans.CorPele;
import com.ufpr.tads.beans.UF;
import com.ufpr.tads.beans.Usuario;
import com.ufpr.tads.dao.CidadeDAO;
import com.ufpr.tads.dao.ClienteDAO;
import com.ufpr.tads.dao.CorCabeloDAO;
import com.ufpr.tads.dao.CorPeleDAO;
import com.ufpr.tads.dao.DescricaoDAO;
import com.ufpr.tads.dao.UFDAO;
import com.ufpr.tads.dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author ArtVin
 */
public class UsuarioFacade {
    
    public static Usuario usuarioLogin(String email,String senha){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario u = usuarioDao.getUsuario(email, senha);
        
        return u;
    }
    public static int createCliente(Cliente c){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        return usuarioDao.insertUsuario(c);
    }
    public static List<UF> getEstados(){
        UFDAO ufDAO = new UFDAO();
        return ufDAO.getListaUF();
    }

    public static List<Cidade> getCidades(int idEstado) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.getListaCidade(idEstado);
    }

    public static List<CorCabelo> getListaCorCabelo() {
       CorCabeloDAO cabeloDao = new CorCabeloDAO();
       return cabeloDao.getListaCorCabelo();
    }

    public static List<CorPele> getListaCorPele() {
       CorPeleDAO peleDao = new CorPeleDAO();
       return peleDao.getListaCorPele();
    }

    public static boolean updateDescricao(Cliente cliente) {
        if(cliente.getTipo() != 'C' || cliente.getTipo() != 'c'){
            if(cliente.getDescricao() != null){
                if(cliente.getDescricao().getIdDescricao() != 0){
                    DescricaoDAO descricaoDao = new DescricaoDAO();
                    return descricaoDao.updateDescricao(cliente.getDescricao());
                }
                else{
                    ClienteDAO clienteDao = new ClienteDAO();
                    return clienteDao.updateCliente(cliente);
                    
                }
            }
        }
        return false;
    }
}
