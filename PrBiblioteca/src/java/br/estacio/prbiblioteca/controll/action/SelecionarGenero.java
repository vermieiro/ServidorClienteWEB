package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.GeneroDAO;
import br.estacio.prbiblioteca.model.entity.Genero;
import javax.servlet.http.HttpServletRequest;

public class SelecionarGenero implements Action {
    
    public String executar(HttpServletRequest request) {
    try {
      //1. buscar o id da cidade a ser alterada
      int id = Integer.parseInt(request.getParameter("id"));
      GeneroDAO dao = new GeneroDAO();
      Genero genero = dao.getById(id);
      
      //2. inserir objeto na requisicao
      request.setAttribute("genero", genero);
      
      //3. encaminhar para o JSP especifico
      return "formGenero.jsp";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "erro.jsp";
  }
}
