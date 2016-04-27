package br.estacio.prbiblioteca.controll.action;

import br.estacio.prbiblioteca.model.dao.GeneroDAO;
import br.estacio.prbiblioteca.model.entity.Genero;
import javax.servlet.http.HttpServletRequest;

public class GravarGenero implements Action{
     
    @Override
    public String executar(HttpServletRequest request) {
    try {
      //1. ler dados da pagina e mapear como objeto Genero
      int id = Integer.parseInt(request.getParameter("id"));
      String descricao = request.getParameter("descricao");
     
      Genero genero = new Genero();
      genero.setId(id);
      genero.setDescricao(descricao);
      
      //2. gravar dados
      GeneroDAO dao = new GeneroDAO();
      if (id == 0) {
        dao.insert(genero);
      }
      else {
        dao.update(genero);
      }
      
      //3. encaminhar para o JSP especifico
      return new ListarGenero().executar(request);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "erro.jsp";
  }
    
}
