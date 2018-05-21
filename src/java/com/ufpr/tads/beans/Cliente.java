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
    private int idCliente;
    private String nome;
    private String cpf;
    private Date dataNasc;
    private Date dataCadast;
    private Endereco endereco;
    private char sexo;
    private boolean disp;
    private int qtdTokens;
    private Preferencias preferencia;
    private Descricao descricao;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Date getDataCadast() {
        return dataCadast;
    }

    public void setDataCadast(Date dataCadast) {
        this.dataCadast = dataCadast;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public boolean isDisp() {
        return disp;
    }

    public void setDisp(boolean disp) {
        this.disp = disp;
    }

    public int getQtdTokens() {
        return qtdTokens;
    }

    public void setQtdTokens(int qtdTokens) {
        this.qtdTokens = qtdTokens;
    }

    public Preferencias getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencias preferencia) {
        this.preferencia = preferencia;
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }
    
    
}
