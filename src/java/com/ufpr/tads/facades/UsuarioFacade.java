/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*LEIA-ME
 Para fazer o envio de email funcionar
 1- baixar o javax.mail.jar desse link: https://javaee.github.io/javamail/
 2- Adicionar o javax.mail como library no projeto
 3- Feito!
*/
package com.ufpr.tads.facades;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Convite;
import com.ufpr.tads.beans.CorCabelo;
import com.ufpr.tads.beans.CorPele;
import com.ufpr.tads.beans.Funcionario;
import com.ufpr.tads.beans.UF;
import com.ufpr.tads.beans.Usuario;
import com.ufpr.tads.dao.CidadeDAO;
import com.ufpr.tads.dao.ClienteDAO;
import com.ufpr.tads.dao.ConviteDAO;
import com.ufpr.tads.dao.CorCabeloDAO;
import com.ufpr.tads.dao.CorPeleDAO;
import com.ufpr.tads.dao.DescricaoDAO;
import com.ufpr.tads.dao.FuncionarioDAO;
import com.ufpr.tads.dao.PreferenciaDAO;
import com.ufpr.tads.dao.UFDAO;
import com.ufpr.tads.dao.UsuarioDAO;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ArtVin
 */
public class UsuarioFacade {
    
    //Esse método envia email
    //Precisa inserir o javax.mail.jar na biblioteca (libraries)
    private static void sendFromGMail(String para, String assunto, String corpo) {
        //O usuário que manda o email
        String from ="foreveralonebot"; //email sem o @gmail.com
        String pass = "razer2018"; //senha do email
        
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            
            InternetAddress toAddress = new InternetAddress(para);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(assunto);
            message.setText(corpo);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    public static Usuario usuarioLogin(String email,String senha){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario u = usuarioDao.getUsuario(email, senha);
        
        return u;
    }
    public static int createCliente(Cliente c){
        if(c.getSenha() == null || c.getSenha().isEmpty()){
            c.setSenha(getRandomString(5));
        //Envia senha por email
        String  assunto = "Teste usuário criado";
        String corpo = "Sua senha é: " + c.getSenha();
        String email = c.getEmail();
        sendFromGMail(email, assunto, corpo);
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

    public static List<Cliente> getListaClienteFestaNotInvite(int aux) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getListaClienteFestaNotInvite(aux);
    }

    public static List<Convite> getConvitesAguardando(int idCliente) {
        ConviteDAO conviteDAO = new ConviteDAO();
        return conviteDAO.getListaConviteClienteAguardando(idCliente);
    }
}
