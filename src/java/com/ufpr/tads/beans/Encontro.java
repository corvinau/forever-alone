/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.beans;

import com.ufpr.tads.interfaces.Convidavel;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Encontro implements Convidavel {
    private int idEncontro;
    private Date data;
    private Date hora;
    private Local local;
    private Status status;
    private Convite convite;
    private Pagamento pagamento;

    public int getIdEncontro() {
        return idEncontro;
    }

    public void setIdEncontro(int idEncontro) {
        this.idEncontro = idEncontro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Convite getConvite() {
        return convite;
    }

    public void setConvite(Convite convite) {
        this.convite = convite;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public int getId() {
        return this.getIdEncontro();
    }
    
}
