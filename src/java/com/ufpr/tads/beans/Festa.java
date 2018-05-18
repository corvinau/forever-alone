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
public class Festa implements Convidavel {
    private Date data;
    private String tema;
    private Date hora;
    private Funcionario func;
    private Status status;
    private Local local;
}
