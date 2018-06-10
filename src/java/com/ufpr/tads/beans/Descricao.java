/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.beans;

/**
 *
 * @author DELL
 */
public class Descricao {
    private int idDescricao;
    private String imagem;
    private String resumo;
    private CorCabelo corCabelo;
    private CorPele corPele;

    public int getIdDescricao() {
        return idDescricao;
    }

    public void setIdDescricao(int idDescricao) {
        this.idDescricao = idDescricao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public CorCabelo getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(CorCabelo corCabelo) {
        this.corCabelo = corCabelo;
    }

    public CorPele getCorPele() {
        return corPele;
    }

    public void setCorPele(CorPele corPele) {
        this.corPele = corPele;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    
}
