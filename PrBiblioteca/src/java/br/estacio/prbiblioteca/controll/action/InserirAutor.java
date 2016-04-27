package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.entity.Autor;
import javax.servlet.http.HttpServletRequest;

public class InserirAutor implements Action {
  
  @Override
  public String executar(HttpServletRequest request) {
    try {
      
      Autor autor = new Autor();

      request.setAttribute("autor", autor);
      
      return "formAutor.jsp";
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "erro.jsp";
  }
}
