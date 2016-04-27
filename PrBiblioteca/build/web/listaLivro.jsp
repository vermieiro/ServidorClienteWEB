<%@page contentType="text/html" pageEncoding="UTF-8"
        import="br.estacio.prbiblioteca.model.entity.Livro"
        import="br.estacio.prbiblioteca.model.entity.Autor"
        import="br.estacio.prbiblioteca.model.entity.Genero"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Livros</title>
    </head>
    <body>
        <jsp:include page="menufinal.jsp"/>
        <div class="container">
            <h1>Lista de Livros</h1>
            <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default"><a href='/prbiblioteca/servletbiblioteca?acao=InserirLivro'>Novo Livro</a></button>
                <button type="button" class="btn btn-default"><a href = "/prbiblioteca/">Inicio</a></button>
            </div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>Titulo</td>
                        <td>Descricao</td>
                        <td>Ano de lançamento</td>
                        <td>Autor</td>
                        <td>Genero</td>
                        <td>Ação</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="livro" items="${lista}">
                        <tr>
                            <td>${livro.titulo}</td>
                            <td>${livro.descricao}</td>
                            <td>${livro.anoLancamento}</td>
                            <td>${livro.autor.nome}</td>
                            <td>${livro.genero.descricao}</td>
                            <td><a href='/prbiblioteca/servletbiblioteca?acao=SelecionarLivro&isbn=${livro.isbn}'>Alterar</a></td>
                            <td><a href='/prbiblioteca/servletbiblioteca?acao=RemoverLivro&isbn=${livro.isbn}'>Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

