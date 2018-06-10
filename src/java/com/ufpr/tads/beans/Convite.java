/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.beans;

import com.ufpr.tads.interfaces.Convidavel;

/**
 *
 * @author DELL
 */
public class Convite {
    private int idConvite;
    private String status;
    private String tipo;
    private Cliente convidado;
    private Convidavel evento;
    private Pagamento pagamento;
    
    public int getIdConvite() {
        return idConvite;
    }

    public void setIdConvite(int idConvite) {
        this.idConvite = idConvite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getConvidado() {
        return convidado;
    }

    public void setConvidado(Cliente convidado) {
        this.convidado = convidado;
    }

    public Convidavel getEvento() {
        return evento;
    }

    public void setEvento(Convidavel evento) {
        this.evento = evento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    
}
