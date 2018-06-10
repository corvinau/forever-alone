/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.beans;

import com.ufpr.tads.interfaces.Convidavel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Festa implements Convidavel {
    private int idFesta;
    private Date data;
    private String tema;
    private Date hora;
    private Funcionario func;
    private Status status;
    private Local local;
    private List<Convite> convites;

    public int getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(int idFesta) {
        this.idFesta = idFesta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Convite> getConvites() {
        return convites;
    }

    public void setConvites(List<Convite> convites) {
        this.convites = convites;
    }

    @Override
    public int getId() {
        return this.getIdFesta();
    }
    
    
    
}
