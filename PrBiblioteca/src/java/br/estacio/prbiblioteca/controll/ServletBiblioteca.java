package br.estacio.prbiblioteca.controll;

import br.estacio.prbiblioteca.controll.action.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletBiblioteca", urlPatterns = {"/servletbiblioteca"})
public class ServletBiblioteca extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    try {
      String acao = request.getParameter("acao");
      String nomeDaClasse
        = "br.estacio.prbiblioteca.controll.action." + acao;

      Class<?> classe = Class.forName(nomeDaClasse);
      Action action = (Action) classe.newInstance();

      String pagina = action.executar(request);

      RequestDispatcher rd = request.getRequestDispatcher(pagina);
      rd.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
