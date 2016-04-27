package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.LivroDAO;
import javax.servlet.http.HttpServletRequest;

public class RemoverLivro implements Action{
    
    public String executar(HttpServletRequest request) {
    try {
      //1. buscar o id da cidade a ser removida
      int isbn = Integer.parseInt(request.getParameter("isbn"));
      
      //2. remover o objeto cidade informado
      LivroDAO dao = new LivroDAO();
      dao.delete(isbn);
      
      //3. encaminhar para JPS especifico
      return new ListarLivro().executar(request);
    } catch (Exception e) {
    }
    return "erro.jsp";
  }
}
