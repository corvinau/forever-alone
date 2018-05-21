/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.beans;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Horario {
    private int idHorario;
    private String diaSemana;
    private Date horaInicial;
    private Date horaLimite;

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraLimite() {
        return horaLimite;
    }

    public void setHoraLimite(Date horaLimite) {
        this.horaLimite = horaLimite;
    }
    
    
}
