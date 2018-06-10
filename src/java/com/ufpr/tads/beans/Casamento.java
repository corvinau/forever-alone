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
public class Casamento implements Convidavel {
    private int idCasamento;
    private String status;
    private Date data;
    private Date hora;
    private int qtdConvidados;
    private String nomePadre;
    private String igreja;
    private String localLuaDeMel;
    private List<Padrinhos> padrinhos;
    private Orcamento orcamento;
    private Convite convite;

    public int getIdCasamento() {
        return idCasamento;
    }

    public void setIdCasamento(int idCasamento) {
        this.idCasamento = idCasamento;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getQtdConvidados() {
        return qtdConvidados;
    }

    public void setQtdConvidados(int qtdConvidados) {
        this.qtdConvidados = qtdConvidados;
    }

    public String getNomePadre() {
        return nomePadre;
    }

    public void setNomePadre(String nomePadre) {
        this.nomePadre = nomePadre;
    }

    public String getIgreja() {
        return igreja;
    }

    public void setIgreja(String igreja) {
        this.igreja = igreja;
    }

    public String getLocalLuaDeMel() {
        return localLuaDeMel;
    }

    public void setLocalLuaDeMel(String localLuaDeMel) {
        this.localLuaDeMel = localLuaDeMel;
    }

    public List<Padrinhos> getPadrinhos() {
        return padrinhos;
    }

    public void setPadrinhos(List<Padrinhos> padrinhos) {
        this.padrinhos = padrinhos;
    }

    public Convite getConvite() {
        return convite;
    }

    public void setConvite(Convite convite) {
        this.convite = convite;
    }

    

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public int getId() {
        return this.getIdCasamento();
    }
    
    
}
