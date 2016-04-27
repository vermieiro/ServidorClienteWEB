/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prbiblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Vermieiro
 */
public interface Action {
    public String executar(HttpServletRequest request) 
    throws Exception;
  
    
}
