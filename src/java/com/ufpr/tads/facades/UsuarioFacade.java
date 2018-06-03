/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.facades;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.UF;
import com.ufpr.tads.beans.Usuario;
import com.ufpr.tads.dao.CidadeDAO;
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
}
