/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.AutorDAO;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Fernando
 */
public class RemoverAutor implements Action{
    public String executar(HttpServletRequest request) {
    try {
      //1. buscar o id da cidade a ser removida
      int id = Integer.parseInt(request.getParameter("id"));
      
      //2. remover o objeto cidade informado
      AutorDAO dao = new AutorDAO();
      dao.delete(id);
      
      //3. encaminhar para JPS especifico
      return new ListarAutor().executar(request);
    } catch (Exception e) {
    }
    return "erro.jsp";
  }
}
