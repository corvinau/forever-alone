/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.beans;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Orcamento {
    private int idOrcamento;
    private Date dataOrcado;
    private List<Proposta> propostas;

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Date getDataOrcado() {
        return dataOrcado;
    }

    public void setDataOrcado(Date dataOrcado) {
        this.dataOrcado = dataOrcado;
    }

    public List<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(List<Proposta> propostas) {
        this.propostas = propostas;
    }
    
    
}
