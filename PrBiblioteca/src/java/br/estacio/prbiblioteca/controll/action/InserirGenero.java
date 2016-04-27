package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.entity.Genero;
import javax.servlet.http.HttpServletRequest;

public class InserirGenero implements Action {
  
  @Override
  public String executar(HttpServletRequest request) {
    try {
      
      Genero genero = new Genero();
      
      request.setAttribute("genero", genero);
      
      return "formGenero.jsp";
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "erro.jsp";
  }
}
