/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.servlets;

import com.ufpr.tads.beans.Cidade;
import com.ufpr.tads.beans.Convite;
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
import java.util.ArrayList;
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
        String action = (String) request.getAttribute("action");
        if(action == null || action.isEmpty()){
            action = (String) request.getParameter("action");
        }
        if(action != null){
            Festa f;
            int aux = 0;
            String parameter;
            String[] parameterList;
            switch (action){
                case "convidarClientes":
                    parameterList = (String[]) request.getParameterValues("idCliente");
                    parameter = (String) request.getParameter("idFesta");
                    if(!parameter.isEmpty() && parameterList.length != 0){
                        FestaFacade.insertConvites(parameter,parameterList);
                    }
                    request.setAttribute("action", "listaConvidados");
                    request.setAttribute("id", parameter);
                    rd = getServletContext().getRequestDispatcher("/FestaServlet");
                    break;
                case "cadastroFesta":
                    f = getPostFesta(request);
                    f.setFunc(usuarioLogado);
                    if(FestaFacade.createFesta(f) != 0){
                        request.setAttribute("msg", "Festa cadastrada com sucesso");
                        rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    }
                    break;
                case "adcionarConvidado" :
                    parameter = (String) request.getParameter("id");
                    if(parameter != null || !parameter.isEmpty()){
                        aux = Integer.parseInt(parameter);
                    }
                    if(aux != 0){
                        request.setAttribute("idFesta",aux);
                        request.setAttribute("listaCliente",UsuarioFacade.getListaClienteFestaNotInvite(aux));
                        rd = getServletContext().getRequestDispatcher("/festaAdicionaConvidados.jsp");
                    }
                    break;
                case "festaForm":
                    request.setAttribute("locais", LocalFacade.getListaLocal());
                    rd = getServletContext().getRequestDispatcher("/festaForm.jsp");
                    break;
                case "listaConvidados":
                    parameter = (String) request.getParameter("id");
                    if(parameter == null || parameter.isEmpty()){
                        parameter = (String) request.getAttribute("id");
                    }
                    f = FestaFacade.getFesta(Integer.parseInt(parameter));
                    request.setAttribute("festa", f);
                    rd = getServletContext().getRequestDispatcher("/festaListaConvidados.jsp");
                    break;
                case "listaFesta":
                    List<Festa> lista = FestaFacade.getListaFesta();
                    request.setAttribute("listaFesta", lista);
                    List<Integer> pendentes = new ArrayList<Integer>();
                    List<Integer> aceitos = new ArrayList<Integer>();
                    int pen, acei;
                    for(Festa fes : lista){
                        pen = 0;
                        acei = 0;
                        if(fes.getConvites() != null && fes.getConvites().isEmpty()){
                            for(Convite co : fes.getConvites()){
                                if(co.getStatus().equals("Aceito")) acei++;
                                else if(co.getStatus().equals("Aguardando")) pen++;
                            }
                        }
                        pendentes.add(pen);
                        aceitos.add(acei);
                    }
                    request.setAttribute("pendentes", pendentes);
                    request.setAttribute("aceitos", aceitos);
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
