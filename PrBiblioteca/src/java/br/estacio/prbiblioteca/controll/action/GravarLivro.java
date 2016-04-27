/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.LivroDAO;
import br.estacio.prbiblioteca.model.entity.Autor;
import br.estacio.prbiblioteca.model.entity.Genero;
import br.estacio.prbiblioteca.model.entity.Livro;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Vermieiro
 */
public class GravarLivro implements Action{
     
    @Override
    public String executar(HttpServletRequest request) {
    try {
      //1. ler dados da pagina e mapear como objeto Livro
     int isbn = Integer.parseInt(request.getParameter("isbn"));
     String titulo = request.getParameter("titulo");
     String descricao = request.getParameter("descricao");
     int anoLancamento = Integer.parseInt(request.getParameter("anoLancamento"));
     int idAutor = Integer.parseInt(request.getParameter("idAutor"));
     int idGenero = Integer.parseInt(request.getParameter("idGenero"));
     Livro livro = new Livro();
     livro.setIsbn(isbn);
     livro.setTitulo(titulo);
     livro.setDescricao(descricao);
     livro.setAnoLancamento(anoLancamento);
     Autor autor = new Autor();
     autor.setId(idAutor);
     livro.setAutor(autor);
     Genero genero = new Genero();
     genero.setId(idGenero);
     livro.setGenero(genero);
      
      //2. gravar dados
      LivroDAO dao = new LivroDAO();
      if (isbn == 0) {
        dao.insert(livro);
      }
      else {
        dao.update(livro);
      }
      
      //3. encaminhar para o JSP especifico
      return new ListarLivro().executar(request);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "erro.jsp";
  }
    
}
