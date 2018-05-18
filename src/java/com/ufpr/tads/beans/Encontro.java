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
public class Encontro implements Convidavel {
    private Date data;
    private Date hora;
    private Status status;
}
