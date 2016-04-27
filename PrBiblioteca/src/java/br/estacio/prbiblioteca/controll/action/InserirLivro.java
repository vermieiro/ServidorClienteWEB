package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.AutorDAO;
import br.estacio.prbiblioteca.model.dao.GeneroDAO;
import br.estacio.prbiblioteca.model.entity.Autor;
import br.estacio.prbiblioteca.model.entity.Genero;
import br.estacio.prbiblioteca.model.entity.Livro;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class InserirLivro implements Action {
  
  @Override
  public String executar(HttpServletRequest request) {
    try {
      
      Livro livro = new Livro();
      AutorDAO dao = new AutorDAO();
      List<Autor> autores = dao.list();
      GeneroDAO dao2 = new GeneroDAO();
      List<Genero> generos = dao2.list();
      
      request.setAttribute("livro", livro);
      request.setAttribute("listaA", autores);
      request.setAttribute("listaG", generos);
      
      return "formLivro.jsp";
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "erro.jsp";
  }
}
