/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.servlets;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Endereco;
import com.ufpr.tads.beans.Festa;
import com.ufpr.tads.beans.Funcionario;
import com.ufpr.tads.beans.Local;
import com.ufpr.tads.beans.Status;
import com.ufpr.tads.beans.UF;
import com.ufpr.tads.facades.FestaFacade;
import com.ufpr.tads.facades.LocalFacade;
import com.ufpr.tads.facades.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "FestaServlet", urlPatterns = {"/FestaServlet"})
public class FestaServlet extends HttpServlet {

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
            Festa f;
            switch (action){
                case "adicionarConvidado":
                    
                    break;
                case "cadastroFesta":
                    f = getPostFesta(request);
                    f.setFunc(usuarioLogado);
                    if(FestaFacade.createFesta(f) != 0){
                        request.setAttribute("msg", "Festa cadastrada com sucesso");
                        rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    }
                    break;
                case "festaForm":
                    request.setAttribute("locais", LocalFacade.getListaLocal());
                    rd = getServletContext().getRequestDispatcher("/festaForm.jsp");
                    break;
                case "listaConvidados":
                    f = FestaFacade.getFesta(Integer.parseInt((String) request.getParameter("id")));
                    rd = getServletContext().getRequestDispatcher("/festaForm.jsp");
                    break;
                case "listaFesta":
                    request.setAttribute("listaFesta", FestaFacade.getListaFesta());
                    rd = getServletContext().getRequestDispatcher("/festaListar.jsp");
                    break;
                default :
                    rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    break;
            }
                            
                            
        }
        rd.forward(request, response);
    }
    
    private Festa getPostFesta(HttpServletRequest request){
        Festa festa = new Festa();
        
        festa.setTema((String) request.getParameter("tema"));
        
        String aux = (String) request.getParameter("data");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            festa.setData(format.parse(aux.replace("/", "-")));
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Timestamp hora;
        hora = new Timestamp(1000000000000l);
        hora.setHours(Integer.parseInt((String) request.getParameter("hora")));
        hora.setMinutes(Integer.parseInt((String) request.getParameter("minuto")));
        
        festa.setHora(hora);
        
        Local local = new Local();
        local.setIdLocal(Integer.parseInt((String) request.getParameter("local")));
        
        festa.setLocal(local);
        
        Status status = new Status();
        status.setIdStatus(1);
        festa.setStatus(status);
        
        return festa;
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
