<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cadastro de Livros</title>
    </head>
        <body>
        <jsp:include page="menufinal.jsp"/>
        <div class="container">
            <h1>Cadastro de Livros</h1>
            <form role="form" method="post" action="/prbiblioteca/servletbiblioteca">
                <div class="form-group">
                    <input type='hidden' name='acao' value='GravarLivro'/>
                    <input type='hidden' name='isbn' value='${livro.isbn}'/>
                    <table>
                        <tr>
                            <td>Titulo:</td>
                        </tr>
                        <tr>
                            <td><input type='text' name='titulo' value='${livro.titulo}'></td>
                        </tr>
                        <tr>
                            <td>Descrição:</td>
                        </tr>
                        <tr>
                            <td><input type='text' name='descricao' value='${livro.descricao}'></td>
                        </tr>
                        <tr>
                            <td>Ano de lançamento:</td>
                        </tr>
                        <tr>
                            <td><input type='text' name='anoLancamento' value='${livro.anoLancamento}'></td>
                        </tr>
                        <tr>
                            <td>Autor:</td>
                        </tr>
                        <tr>
                            <td>
                                <select name="idAutor">
                                    <c:forEach items="${listaA}" var="autor">
                                        <option value="${autor.id}"
                                                <c:if test="${autor.id == livro.autor.id}">
                                                    selected
                                                </c:if>
                                                    >${autor.nome}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Genero:</td>
                        </tr>
                        <tr>
                            <td>
                                <select name="idGenero">
                                    <c:forEach items="${listaG}" var="genero">
                                        <option value="${genero.id}"
                                                <c:if test="${genero.id == livro.genero.id}">
                                                    selected
                                                </c:if>
                                                    >${genero.descricao}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><br/><input type='submit' value='Salvar'></td>
                            <td><br/><input type='button' value='Voltar' onClick="history.go(-1)"></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </body>
</html>

