<%@page contentType="text/html" pageEncoding="UTF-8"
        import="br.estacio.prbiblioteca.model.entity.Genero"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista do Genero</title>
    </head>
    <body>
        <jsp:include page="menufinal.jsp"/>
        <div class="container">
            <h1>Lista do Genero</h1>
            <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default"><a href = "/prbiblioteca/servletbiblioteca?acao=InserirGenero">Novo Genero</a></button>
                <button type="button" class="btn btn-default"><a href = "/prbiblioteca/">Inicio</a></button>
            </div>
            <br>
            <table class="table table-striped">
                <tr><br>
                    <td>Nome</td>
                </tr>
                <c:forEach var="genero" items="${lista}">
                    <tr>
                        <td>${genero.descricao}</td>
                        <td><a href='/prbiblioteca/servletbiblioteca?acao=SelecionarGenero&id=${genero.id}'>Alterar</a></td>
                        <td><a href='/prbiblioteca/servletbiblioteca?acao=RemoverGenero&id=${genero.id}'>Excluir</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
