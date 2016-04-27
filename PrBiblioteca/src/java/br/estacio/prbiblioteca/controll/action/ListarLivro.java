package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.LivroDAO;
import br.estacio.prbiblioteca.model.entity.Livro;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ListarLivro implements Action {
  
  @Override
  public String executar(HttpServletRequest request) {
    try {
      //1. buscar dados
      LivroDAO dao = new LivroDAO();
      List<Livro> livros = dao.list();

      //2. colocar dados na requisição
      request.setAttribute("lista", livros);

      //3. chamar JSP
      return "listaLivro.jsp";
    } catch (Exception e) {
      e.printStackTrace();;
    }
    return "erro.jsp";
  }
    
}
