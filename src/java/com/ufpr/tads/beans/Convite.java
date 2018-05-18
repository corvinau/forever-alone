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
public class Convite implements Convidavel {
    private String status;
    private int tipo;
    private Cliente convidado;
}
