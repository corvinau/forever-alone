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
import com.ufpr.tads.beans.Funcionario;
import com.ufpr.tads.beans.UF;
import com.ufpr.tads.beans.Usuario;
import com.ufpr.tads.dao.CidadeDAO;
import com.ufpr.tads.dao.ClienteDAO;
import com.ufpr.tads.dao.CorCabeloDAO;
import com.ufpr.tads.dao.CorPeleDAO;
import com.ufpr.tads.dao.DescricaoDAO;
import com.ufpr.tads.dao.FuncionarioDAO;
import com.ufpr.tads.dao.PreferenciaDAO;
import com.ufpr.tads.dao.UFDAO;
import com.ufpr.tads.dao.UsuarioDAO;
import java.util.List;
import java.util.Random;

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
        if(c.getSenha() == null || c.getSenha().isEmpty()){
            c.setSenha(getRandomString(5));
        }
        UsuarioDAO usuarioDao = new UsuarioDAO();
        return usuarioDao.insertUsuario(c);
    }
    public static int createFuncionario(Funcionario f){
        if(f.getSenha() == null || f.getSenha().isEmpty()){
            f.setSenha(getRandomString(5));
        }
        UsuarioDAO usuarioDao = new UsuarioDAO();
        return usuarioDao.insertUsuario(f);
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

    public static boolean updatePreferencia(Cliente cliente) {
        if(cliente.getTipo() != 'C' || cliente.getTipo() != 'c'){
            if(cliente.getPreferencia() != null){
                if(cliente.getPreferencia().getIdPreferencias() != 0){
                    PreferenciaDAO preferenciaDao = new PreferenciaDAO();
                    return preferenciaDao.updatePreferencia(cliente.getPreferencia());
                }
                else{
                    ClienteDAO clienteDao = new ClienteDAO();
                    return clienteDao.updateCliente(cliente);
                    
                }
            }
        }
        return false;
    }

    public static List<Cliente> getListaCliente() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getListaCliente();
    }
    private static String getRandomString(int maxLen) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String string = "";
        
        Random rnd = new Random();
        
        while (string.length() < maxLen) { 
            int index = (int) (rnd.nextFloat() * chars.length());
            string += chars.charAt(index);
        }
        
        return string;

    }

    public static List<Funcionario> getListaFuncionario() {
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        return funcionarioDao.getListaFuncionario();
    }
}
