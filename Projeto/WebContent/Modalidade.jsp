<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Modalidade" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Modalidade</title>
    </head>
    <body>
 	<%Modalidade modalidade = (Modalidade)request.getAttribute("modalidade"); %>
 	<nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Olimpiadas</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="PaisCadastro.jsp">Pais</a>
                    </li>
                    <li><a href="ModalidadeCadastro.jsp">Modalidade</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <br>
    <div class="container">
        <h2 class= "page-header">Modalidade Cadastrada com Sucesso!</h2>
        
        <div class="row">
     		<div class="form-group col-md-6">
           		<label ><strong>Id</strong></label>
                <p> <%=modalidade.getId() %></p>

            </div>
            <div class="form-group col-md-6">
            	<label ><strong>Modalidade</strong></label>
                <p> <%=modalidade.getNome() %></p>
            </div>
        </div>
        <hr>
    </div>
    </body>
</html>