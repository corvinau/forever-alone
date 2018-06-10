/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.servlets;

import com.ufpr.tads.beans.Cliente;
import com.ufpr.tads.beans.CorCabelo;
import com.ufpr.tads.beans.CorPele;
import com.ufpr.tads.beans.Descricao;
import com.ufpr.tads.beans.Horario;
import com.ufpr.tads.beans.Preferencia;
import com.ufpr.tads.beans.Usuario;
import com.ufpr.tads.facades.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/clienteOpcoes.jsp");
        HttpSession session = request.getSession();
        Cliente usuarioLogado = (Cliente) session.getAttribute("loginBean");
        if(usuarioLogado == null || usuarioLogado.getIdUsuario() == 0){
            rd = getServletContext().getRequestDispatcher("/login.jsp");
            session.invalidate();
            rd.forward(request, response);
        }
        String action = (String) request.getParameter("action");
        if(action == null){
             action = (String) request.getAttribute("action");
        }
        if(action != null){
            switch (action){
                case "updateDescricao" :
                    Descricao descricao = getPostDescricao(request);
                    if(usuarioLogado.getDescricao() != null){
                        descricao.setIdDescricao(usuarioLogado.getDescricao().getIdDescricao());
                    }
                    usuarioLogado.setDescricao(descricao);
                    UsuarioFacade.updateDescricao(usuarioLogado);
                    rd = getServletContext().getRequestDispatcher("/clienteOpcoes.jsp");
                    break;
                case "updatePreferencia" :
                    Preferencia preferencia = getPostPreferencia(request);
                    if(usuarioLogado.getPreferencia() != null){
                        preferencia.setIdPreferencias(usuarioLogado.getPreferencia().getIdPreferencias());
                    }
                    usuarioLogado.setPreferencia(preferencia);
                    UsuarioFacade.updatePreferencia(usuarioLogado);
                    rd = getServletContext().getRequestDispatcher("/clienteOpcoes.jsp");
                    break;
                case "formDescricao":
                    request.setAttribute("listaCorCabelo",UsuarioFacade.getListaCorCabelo());
                    request.setAttribute("listaCorPele",UsuarioFacade.getListaCorPele());
                    rd = getServletContext().getRequestDispatcher("/clienteDescricaoForm.jsp");
                    break;
                case "formPreferencia":
                    request.setAttribute("listaCorCabelo",UsuarioFacade.getListaCorCabelo());
                    request.setAttribute("listaCorPele",UsuarioFacade.getListaCorPele());
                    rd = getServletContext().getRequestDispatcher("/clientePreferenciaForm.jsp");
                    break;
                default :
                    rd = getServletContext().getRequestDispatcher("/clienteOpcoes.jsp");
                    break;
            }
                            
                            
        }
        rd.forward(request, response);
    }
    private Descricao getPostDescricao(HttpServletRequest request){
        Descricao descricao = new Descricao();
        descricao.setImagem((String) request.getParameter("imagem"));
        descricao.setResumo((String)request.getParameter("resumo"));
        CorCabelo corCabelo = new CorCabelo();
        corCabelo.setIdCorCabelo(Integer.parseInt((String) request.getParameter("corCabelo")));
        CorPele corPele = new CorPele();
        corPele.setIdCorPele(Integer.parseInt((String) request.getParameter("corPele")));
        
        descricao.setCorCabelo(corCabelo);
        descricao.setCorPele(corPele);
        
        return descricao;
    }
    private Preferencia getPostPreferencia(HttpServletRequest request){
        Preferencia preferencia = new Preferencia();
        preferencia.setSexos( ((String)request.getParameter("sexo")).charAt(0));
        preferencia.setIdadeMin(Integer.parseInt((String) request.getParameter("idadeMin")));
        preferencia.setIdadeMax(Integer.parseInt((String) request.getParameter("idadeMax")));
        
        String[] listaForm = (String[]) request.getParameterValues("cabelo");
        List<CorCabelo> listaCabelos = new ArrayList<CorCabelo>();
        CorCabelo cabelo;
        for( int i = 0 ; i < listaForm.length ; i++){
            cabelo = new CorCabelo();
            cabelo.setIdCorCabelo(Integer.parseInt(listaForm[i]));
            listaCabelos.add(cabelo);
        }
        preferencia.setCorCabelo(listaCabelos);
        
        listaForm = (String[]) request.getParameterValues("pele");
        List<CorPele> listaPele = new ArrayList<CorPele>();
        CorPele pele;
        for( int i = 0; i < listaForm.length;i++){
            pele = new CorPele();
            pele.setIdCorPele(Integer.parseInt(listaForm[i]));
            listaPele.add(pele);
        }
        preferencia.setCorPele(listaPele);
        
        List<Horario> listaHorario = new ArrayList<Horario>();
        listaForm = (String[]) request.getParameterValues("diaSemana");
        Horario horario;
        for(int i = 0; i < listaForm.length; i++){
            horario = new Horario();
            horario.setDiaSemana(listaForm[i]);
            listaHorario.add(horario);
        }
        listaForm = (String[]) request.getParameterValues("horaMin");
        String[] listaForm1 = (String[]) request.getParameterValues("minutoMin");
        Date dataAux;
        int tamanhoLista = listaForm.length;
        for(int i = 0; i < tamanhoLista; i++){
            dataAux = new Date();
            horario = listaHorario.get(i);
            if(listaForm[i].isEmpty()){
                horario = listaHorario.get(i);
                dataAux.setHours(Integer.parseInt(listaForm[i]));
                dataAux.setMinutes(Integer.parseInt(listaForm1[i]));
                horario.setHoraInicial(dataAux);
            }
            listaHorario.set(i,horario);
        }
        listaForm = (String[]) request.getParameterValues("horaMax");
        listaForm1 = (String[]) request.getParameterValues("minutoMax");
        for(int i = 0; i < listaHorario.size(); i++){
            dataAux = new Date();
            horario = listaHorario.get(i);
            dataAux.setHours(Integer.parseInt(listaForm[i]));
            dataAux.setMinutes(Integer.parseInt(listaForm1[i]));
            horario.setHoraInicial(dataAux);
            listaHorario.set(i,horario);
        }
       
        preferencia.setHorario(listaHorario);
                
        return preferencia;
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
