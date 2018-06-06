/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.servlets;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Endereco;
import com.ufpr.tads.beans.UF;
import com.ufpr.tads.beans.Usuario;
import com.ufpr.tads.facades.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ArtVin
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        String action = (String) request.getParameter("action");
        if(action == null){
             action = (String) request.getAttribute("action");
        }
        if(action != null){
            Cliente c;
            switch(action){
                case "login" :
                    String login = (String) request.getParameter("login");
                    String senha = (String) request.getParameter("senha");
                    Usuario u = UsuarioFacade.usuarioLogin(login, senha);
                    if(u != null){
                        session.setAttribute("loginBean", u);
                        rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    }
                    else{
                        request.setAttribute("msg", "Usuário/senha invalidos");
                        rd = getServletContext().getRequestDispatcher("/login.jsp");
                    }
                    break;
                case "cadastroCliente":
                    c = getPostCliente(request);
                    if(UsuarioFacade.createCliente(c) != 0){
                        request.setAttribute("msg", "Usuario cadastrado com sucesso");
                        rd = getServletContext().getRequestDispatcher("/login.jsp");
                    }
                    else{
                        request.setAttribute("usuario", c);
                        rd = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                    }
                    break;
                case "formLogin":
                    rd = getServletContext().getRequestDispatcher("/login.jsp");   
                    break;
                case "formCliente":
                    request.setAttribute("estados", UsuarioFacade.getEstados());
                    rd = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                    break;
                default :
                    rd = getServletContext().getRequestDispatcher("/index.jsp");
                    break;
            }
        }
        rd.forward(request, response);
       
    }
    
    private Cliente getPostCliente(HttpServletRequest request){
        Cliente c = new Cliente();
        String aux;
        Date data;
        
        c.setEmail((String)request.getParameter("email"));
        aux = (String) request.getParameter("senha");
        if(aux.equals((String)request.getParameter("senhaConfirm"))){
            c.setSenha(aux);
        }
        c.setNome((String) request.getParameter("nome"));
        c.setCpf((String) request.getParameter("cpf"));
        aux = (String) request.getParameter("dataNascimento");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            c.setDataNasc(format.parse(aux.replace("/", "-")));
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        aux = (String) request.getParameter("sexo");
        c.setSexo(aux.charAt(0));
        c.setTipo('C');
        
        Endereco endereco = new Endereco();
        UF uf = new UF();
        Cidade cidade = new Cidade();
        
        uf.setIdUF(Integer.parseInt( (String) request.getParameter("uf") ));
        cidade.setUf(uf);
        cidade.setIdCidade(Integer.parseInt( (String) request.getParameter("cidade") ));
        endereco.setCidade(cidade);
        endereco.setBairro((String) request.getParameter("bairro"));
        endereco.setRua((String) request.getParameter("rua"));
        endereco.setNumero(Integer.parseInt((String) request.getParameter("numero")));
        endereco.setComplemento((String) request.getParameter("complemento"));
        
        c.setEndereco(endereco);
        return c;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
