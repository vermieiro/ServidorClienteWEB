<%@page contentType="text/html" pageEncoding="UTF-8"
        import="br.estacio.prbiblioteca.model.entity.Genero"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
            import = "br.estacio.prbiblioteca.model.entity.Genero"/>
        <title>Cadastro de Genero</title>
    </head>
    <body>
        <jsp:include page="menufinal.jsp"/>
        <div class="container">
            <h1>Cadastro de Genero</h1>
            <form role="form" method="post" action="/prbiblioteca/servletbiblioteca">
                <div class="form-group">
                    <input type='hidden' name='acao' value='GravarGenero'/>
                    <input type='hidden' name='id' value='${genero.id}'/>
                    <table>
                        <tr>
                            <td>Nome:</td>
                        </tr>
                        <tr>
                            <td>
                                <input type='text' class="form-control" name='descricao' value='${genero.descricao}'>
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