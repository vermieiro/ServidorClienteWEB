<%@page contentType="text/html" pageEncoding="UTF-8"
        import="br.estacio.prbiblioteca.model.entity.Autor"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista do Autor</title>
    </head>
    <body>
        <jsp:include page="menufinal.jsp"/>
        <div class="container">
            <h1>Lista do Autor</h1>
            <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default"><a href = "/prbiblioteca/servletbiblioteca?acao=InserirAutor">Novo Autor</a></button>
                <button type="button" class="btn btn-default"><a href = "/prbiblioteca/">Inicio</a></button>
            </div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>Nome</td>
                        <td>Email</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="autor" items="${lista}">
                        <tr>
                            <td>${autor.nome}</td>
                            <td>${autor.email}</td>
                            <td><a href='/prbiblioteca/servletbiblioteca?acao=SelecionarAutor&id=${autor.id}'>Alterar</a></td>
                            <td><a href='/prbiblioteca/servletbiblioteca?acao=RemoverAutor&id=${autor.id}'>Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>