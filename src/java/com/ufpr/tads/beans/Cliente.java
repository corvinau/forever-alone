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
public class Cliente extends Usuario {
    private String nome;
    private String cpf;
    private Date dataNasc;
    private Date dataCadast;
    private char sexo;
    private boolean disp;
    private int qtdTokens;
    private Preferencias preferencia;
    private Descricao descricao;
    
}
