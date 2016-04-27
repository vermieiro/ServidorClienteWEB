package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.GeneroDAO;
import br.estacio.prbiblioteca.model.entity.Genero;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ListarGenero implements Action {
  
  @Override
  public String executar(HttpServletRequest request) {
    try {
      //1. buscar dados
      GeneroDAO dao = new GeneroDAO();
      List<Genero> generos = dao.list();

      //2. colocar dados na requisição
      request.setAttribute("lista", generos);

      //3. chamar JSP
      return "listaGenero.jsp";
    } catch (Exception e) {
      e.printStackTrace();;
    }
    return "erro.jsp";
  }
    
}
