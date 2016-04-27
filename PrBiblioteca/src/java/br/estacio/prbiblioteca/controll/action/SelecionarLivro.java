package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.AutorDAO;
import br.estacio.prbiblioteca.model.dao.GeneroDAO;
import br.estacio.prbiblioteca.model.dao.LivroDAO;
import br.estacio.prbiblioteca.model.entity.Autor;
import br.estacio.prbiblioteca.model.entity.Genero;
import br.estacio.prbiblioteca.model.entity.Livro;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class SelecionarLivro implements Action{
    public String executar(HttpServletRequest request) {
    try {
      //1. buscar o id da cidade a ser alterada
      int isbn = Integer.parseInt(request.getParameter("isbn"));
      LivroDAO dao = new LivroDAO();
      Livro livro = dao.getByIsbn(isbn);
      List<Autor> autores = new AutorDAO().list();
      List<Genero> generos = new GeneroDAO().list();
      
      //2. inserir objeto na requisicao
      request.setAttribute("livro", livro);
      request.setAttribute("listaA", autores);
      request.setAttribute("listaG", generos);
      
      //3. encaminhar para o JSP especifico
      return "formLivro.jsp";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "erro.jsp";
  }
}
