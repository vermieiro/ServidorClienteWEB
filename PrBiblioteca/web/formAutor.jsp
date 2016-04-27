<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
          import = "br.estacio.prbiblioteca.model.entity.Autor"/>
    <title>Cadastro de Autor</title>
    </head>
    <body>
        <jsp:include page="menufinal.jsp"/>
        <div class="container">
            <h1>Cadastro de Autor</h1>
            <form role="form" method="post" action="/prbiblioteca/servletbiblioteca">
                <div class="form-group">
                    <input type='hidden' name='acao' value='GravarAutor'/>
                    <input type='hidden' name='id' value='${autor.id}'/>
                    <table>
                        <tr>
                            <td>Nome:</td>
                        </tr>
                        <tr>
                            <td><input type='text' class="form-control" name='nome' value='${autor.nome}'></td>
                        </tr>
                        <tr>
                            <td>E-mail:</td>
                        </tr>
                        <tr>
                            <td><input type='text' class="form-control" name='email' value='${autor.email}'></td>
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