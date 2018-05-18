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
public class Casamento implements Convidavel {
    private String status;
    private Date data;
    private Date hora;
    private int qtdConvidados;
    private String nomePadre;
    private String igreja;
    private String localLuaDeMel;
    private Padrinhos padrinhos;
    private Orcamento orcamento;
}
