/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.beans;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Preferencia {
    private int idPreferencias;
    private char sexos;
    private int idadeMin;
    private int idadeMax;
    private List<CorCabelo> corCabelo;
    private List<CorPele> corPele;
    private List<Horario> horario;

    public int getIdPreferencias() {
        return idPreferencias;
    }

    public void setIdPreferencias(int idPreferencias) {
        this.idPreferencias = idPreferencias;
    }

    public char getSexos() {
        return sexos;
    }

    public void setSexos(char sexos) {
        this.sexos = sexos;
    }

    public int getIdadeMin() {
        return idadeMin;
    }

    public void setIdadeMin(int idadeMin) {
        this.idadeMin = idadeMin;
    }

    public int getIdadeMax() {
        return idadeMax;
    }

    public void setIdadeMax(int idadeMax) {
        this.idadeMax = idadeMax;
    }

    public List<CorCabelo> getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(List<CorCabelo> corCabelo) {
        this.corCabelo = corCabelo;
    }

    public List<CorPele> getCorPele() {
        return corPele;
    }

    public void setCorPele(List<CorPele> corPele) {
        this.corPele = corPele;
    }

    public List<Horario> getHorario() {
        return horario;
    }

    public void setHorario(List<Horario> horario) {
        this.horario = horario;
    }
    
    
}
