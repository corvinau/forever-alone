/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.servlets;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Descricao;
import com.ufpr.tads.beans.Pagamento;
import com.ufpr.tads.beans.Preferencia;
import com.ufpr.tads.facades.EncontroFacade;
import com.ufpr.tads.facades.FestaFacade;
import com.ufpr.tads.facades.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EncontroServlet", urlPatterns = {"/EncontroServlet"})
public class EncontroServlet extends HttpServlet {

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
        Cliente usuarioLogado = (Cliente) session.getAttribute("loginBean");
        if(usuarioLogado == null || usuarioLogado.getIdUsuario() == 0){
            rd = getServletContext().getRequestDispatcher("/login.jsp");
            session.invalidate();
            rd.forward(request, response);
        }
        String action = (String) request.getAttribute("action");
        if(action == null || action.isEmpty()){
            action = (String) request.getParameter("action");
        }
        if(action != null){
            String[] parameterList;
            int aux;
            switch (action){
                case "solicitarCasamento":
                    aux = Integer.parseInt(request.getParameter("id"));
                    request.setAttribute("encontro", EncontroFacade.getEncontroConvite(aux));
                    rd = getServletContext().getRequestDispatcher("/casamentoSolicitarForm.jsp");
                    break;
                case "listaEncontro":
                    request.setAttribute("listaEncontro",EncontroFacade.getListaEncontroCliente(usuarioLogado.getIdCliente()));
                    rd = getServletContext().getRequestDispatcher("/encontroListar.jsp");
                    break;
                    case "aceitarEncontro":
                    aux = Integer.parseInt(request.getParameter("id"));
                    if(EncontroFacade.aceitaEncontro(aux)){
                        request.setAttribute("msg","Convite aceito com sucesso");
                    }
                    else{
                        request.setAttribute("msg","Erro ao aceitar o convite");
                    }
                    rd = getServletContext().getRequestDispatcher("/encontroListar.jsp");
                    break;
                case "cancelarEncontro":
                    aux = Integer.parseInt(request.getParameter("id"));
                    if(EncontroFacade.cancelarEncontro(aux,usuarioLogado)){
                        request.setAttribute("msg","Encontro cancelado com sucesso");
                    }
                    else{
                        request.setAttribute("msg","Erro ao cancelar o encontro");
                    }
                    rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    break;
                case "remarcarEncontro":
                    aux = Integer.parseInt(request.getParameter("id"));
                    if(EncontroFacade.remarcarEncontro(aux,usuarioLogado)){
                        request.setAttribute("msg","Encontro remarcado com sucesso");
                    }
                    else{
                        request.setAttribute("msg","Erro ao remarcar o encontro");
                    }
                    rd = getServletContext().getRequestDispatcher("/encontroListar.jsp");
                    break;    
                case "convidarClientes":
                    parameterList = (String[]) request.getParameterValues("idCliente");
                    Pagamento pagamento = new Pagamento();
                    pagamento.setTipo("Tradicional");
                    pagamento.setValor((float) (2.5 * parameterList.length));
                    if(parameterList != null && parameterList.length > 0){
                        EncontroFacade.insertConvites(usuarioLogado,parameterList,pagamento);
                    }
                    request.setAttribute("action", "listaEncontros");
                    rd = getServletContext().getRequestDispatcher("/EncontroServlet");
                    break;
                case "SolicitarEncontro":
                    if(usuarioLogado.isDisp()){
                        request.setAttribute("listaCliente",EncontroFacade.getClientesCompativeis(usuarioLogado));
                        rd = getServletContext().getRequestDispatcher("/encontroSolicitar.jsp");
                    }
                    break;
                default :
                    rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    break;
            }
                            
                            
        }
        rd.forward(request, response);
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
