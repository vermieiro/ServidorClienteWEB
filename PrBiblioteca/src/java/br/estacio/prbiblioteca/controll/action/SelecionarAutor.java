package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.AutorDAO;
import br.estacio.prbiblioteca.model.entity.Autor;
import javax.servlet.http.HttpServletRequest;

public class SelecionarAutor implements Action {
    
    public String executar(HttpServletRequest request) {
    try {
      //1. buscar o id da cidade a ser alterada
      int id = Integer.parseInt(request.getParameter("id"));
      AutorDAO dao = new AutorDAO();
      Autor autor = dao.getById(id);
      
      //2. inserir objeto na requisicao
      request.setAttribute("autor", autor);
      
      //3. encaminhar para o JSP especifico
      return "formAutor.jsp";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "erro.jsp";
  }
}
