package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.AutorDAO;
import br.estacio.prbiblioteca.model.entity.Autor;
import javax.servlet.http.HttpServletRequest;

public class GravarAutor implements Action{
     
    @Override
    public String executar(HttpServletRequest request) {
    try {
      //1. ler dados da pagina e mapear como objeto Autor
      int id = Integer.parseInt(request.getParameter("id"));
      String nome = request.getParameter("nome");
      String email = request.getParameter("email");
     
      Autor autor = new Autor();
      autor.setId(id);
      autor.setNome(nome);
      autor.setEmail(email);
      
      //2. gravar dados
      AutorDAO dao = new AutorDAO();
      if (id == 0) {
        dao.insert(autor);
      }
      else {
        dao.update(autor);
      }
      
      //3. encaminhar para o JSP especifico
      return new ListarAutor().executar(request);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "erro.jsp";
  }
}
