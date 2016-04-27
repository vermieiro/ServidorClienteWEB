<%-- 
    Document   : menufinal
    Created on : 25/04/2016, 13:42:28
    Author     : Vermieiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
          import = "br.estacio.prbiblioteca.model.entity.Genero"/>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <title>Menu</title>
    <style>
    footer {
      background-color: #1a1818;
      color: white;
      position:absolute;
      bottom:0;
      width:100%;
      padding: 0px;
    }
    </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand"><img src="logo.png" class="img-rounded" width="20" height="20"></a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="/prbiblioteca/servletbiblioteca?acao=ListarAutor">Autor</a></li>
                        <li><a href="/prbiblioteca/servletbiblioteca?acao=ListarGenero">Genero</a></li>
                        <li><a href="/prbiblioteca/servletbiblioteca?acao=ListarLivro">Livro</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right"></ul>
                </div>
            </div>
        </nav>
        <div class="container-fluid text-center">
            <div class="row content">
                <div class="col-sm-2 sidenav"></div>
                <div class="col-sm-8 text-center">
                </div>
                <div class="col-sm-2 sidenav"></div>
                
            </div>
                
        </div>
        <footer class="container-fluid text-center"><p>Sistema desenvolvido por Fernando Henrique - Luiz Lacerda - Thiago Vermieiro - 2016</p></footer>
    </body>
</html>
