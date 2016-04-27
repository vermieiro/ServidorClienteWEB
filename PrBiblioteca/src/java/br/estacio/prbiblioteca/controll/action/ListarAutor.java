package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.AutorDAO;
import br.estacio.prbiblioteca.model.entity.Autor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ListarAutor implements Action {
  
  @Override
  public String executar(HttpServletRequest request) {
    try {
      //1. buscar dados
      AutorDAO dao = new AutorDAO();
      List<Autor> autores = dao.list();

      //2. colocar dados na requisição
      request.setAttribute("lista", autores);

      //3. chamar JSP
      return "listaAutor.jsp";
    } catch (Exception e) {
      e.printStackTrace();;
    }
    return "erro.jsp";
  }
    
}
