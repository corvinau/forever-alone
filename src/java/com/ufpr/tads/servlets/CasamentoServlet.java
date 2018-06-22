/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.servlets;

import com.ufpr.tads.beans.Casamento;
import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.Padrinhos;
import com.ufpr.tads.facades.CasamentoFacade;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "CasamentoServlet", urlPatterns = {"/CasamentoServlet"})
public class CasamentoServlet extends HttpServlet {

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
            int aux;
            Casamento casamento;
            switch (action){
                case  "solicitarCasamento" :
                    aux = Integer.parseInt(request.getParameter("idConvidando"));
                    casamento = getPostCasamento(request);
                    casamento.setCliente(usuarioLogado);
                    CasamentoFacade.insertCasamento(casamento,aux);
                    break;
                default :
                    rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    break;
            }
                            
                            
        }
        rd.forward(request, response);
    }
    
    private Casamento getPostCasamento(HttpServletRequest request){
        Casamento casamento = new Casamento();
        String aux;
        
        aux = (String) request.getParameter("data");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            casamento.setData(format.parse(aux.replace("/", "-")));
        } catch (ParseException ex) {
            Logger.getLogger(CasamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date hora = new Date(100000000);
        hora.setHours(Integer.parseInt((String) request.getParameter("hora")));
        
        casamento.setHora(hora);
        
        casamento.setIgreja((String) request.getParameter("igreja"));
        casamento.setLocalLuaDeMel((String) request.getParameter("localLuaMel"));
        casamento.setNomePadre((String) request.getParameter("padre"));
        
        casamento.setQtdConvidados(Integer.parseInt((String) request.getParameter("qtdConvidados")));
        List<Padrinhos> listaPadrinhos = new ArrayList<Padrinhos>();
        Padrinhos p = new Padrinhos();
        
        p.setConjugues((String) request.getParameter("cojuges1"));
        p.setEmail((String) request.getParameter("emailConjuge1"));
        
        listaPadrinhos.add(p);
        
        p = new Padrinhos();
        
        p.setConjugues((String) request.getParameter("cojuges2"));
        p.setEmail((String) request.getParameter("emailConjuge2"));
        
        listaPadrinhos.add(p);
        
        casamento.setPadrinhos(listaPadrinhos);
        
        casamento.setStatus("Aguardando");
        
        return casamento;
        
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
