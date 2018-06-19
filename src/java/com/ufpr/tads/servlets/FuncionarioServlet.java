/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.servlets;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Descricao;
import com.ufpr.tads.beans.Endereco;
import com.ufpr.tads.beans.Funcionario;
import com.ufpr.tads.beans.Local;
import com.ufpr.tads.beans.Preferencia;
import com.ufpr.tads.beans.UF;
import com.ufpr.tads.facades.FestaFacade;
import com.ufpr.tads.facades.LocalFacade;
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
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/portal.jsp");
        HttpSession session = request.getSession();
        Funcionario usuarioLogado = (Funcionario) session.getAttribute("loginBean");
        if(usuarioLogado == null || usuarioLogado.getIdUsuario() == 0 ||
                (usuarioLogado.getTipo() != 'F' && usuarioLogado.getTipo() != 'f')){
            rd = getServletContext().getRequestDispatcher("/login.jsp");
            session.invalidate();
            rd.forward(request, response);
        }
        String action = (String) request.getParameter("action");
        if(action == null){
             action = (String) request.getAttribute("action");
        }
        if(action != null){
            Funcionario f;
            Local l;
            switch (action){
                case "cadastroFuncionario":
                    f = getPostFuncionario(request);
                    if(UsuarioFacade.createFuncionario(f) != 0){
                        request.setAttribute("msg", "Usuario cadastrado com sucesso");
                        rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    }
                    break;
                case "cadastroLocal":
                    l = getPostLocal(request);
                    if(LocalFacade.createLocal(l) != 0){
                        request.setAttribute("msg", "Local cadastrado com sucesso");
                        rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    }
                    break;
                case "localForm":
                    request.setAttribute("estados", UsuarioFacade.getEstados());
                    rd = getServletContext().getRequestDispatcher("/localForm.jsp");
                    break;
                case "clienteForm":
                    request.setAttribute("estados", UsuarioFacade.getEstados());
                    rd = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                    break;
                case "funcionarioForm":
                    request.setAttribute("estados", UsuarioFacade.getEstados());
                    rd = getServletContext().getRequestDispatcher("/funcionarioForm.jsp");
                    break;
                case "listaLocal":
                    request.setAttribute("listaLocal", LocalFacade.getListaLocal());
                    rd = getServletContext().getRequestDispatcher("/localListar.jsp");
                    break;
                case "listaFuncionarios":
                    request.setAttribute("listaFuncionarios", UsuarioFacade.getListaFuncionario());
                    rd = getServletContext().getRequestDispatcher("/funcionarioListar.jsp");
                    break;
                case "listaClientes":
                    request.setAttribute("listaClientes",UsuarioFacade.getListaCliente());
                    rd = getServletContext().getRequestDispatcher("/clienteListar.jsp");
                    break;
                case "showCliente":
                	request.setAttribute("cliente", UsuarioFacade.getCliente(Integer.parseInt(request.getParameter("id"))));
                	request.setAttribute("visualizar", true);
                	rd = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                	break;
                case "formUpdateCliente":
                	 request.setAttribute("cliente", UsuarioFacade.getCliente(Integer.parseInt(request.getParameter("id"))));
                	 request.setAttribute("estados", UsuarioFacade.getEstados());
                	 request.setAttribute("alterar", true);
                     rd = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                	break;
                case "deleteCliente":
                	 UsuarioFacade.deleteCliente(Integer.parseInt(request.getParameter("id")));
                     response.sendRedirect("/FuncionarioServler?action=listaClientes");
                	break;
                default :
                    rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    break;
            }
                            
                            
        }
        rd.forward(request, response);
    }
    
    private Local getPostLocal(HttpServletRequest request){
        Local local = new Local();
        
        local.setNomeEstabelecimento((String) request.getParameter("nomeEstabelecimento"));
        
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
        
        local.setEndereco(endereco);
        return local;
    }
    
    private Funcionario getPostFuncionario(HttpServletRequest request){
        Funcionario f = new Funcionario();
        String aux;
        Date data;
        
        f.setEmail((String)request.getParameter("email"));
        f.setNome((String) request.getParameter("nome"));
        f.setCargo((String) request.getParameter("cargo"));
        f.setCpf((String) request.getParameter("cpf"));
        aux = (String) request.getParameter("dataNascimento");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            f.setDataNasc(format.parse(aux.replace("/", "-")));
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.setTipo('F');
        
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
        
        f.setEndereco(endereco);
        
        
        return f;
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
