<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Pais" %>
<%@ page import="model.Modalidade" %>
<%@ page import="model.Olimpiada" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<title>Cadastro de Pais</title>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Olimpiadas</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="PaisCadastro.jsp">Países</a>
                    </li>
                    <li><a href="ModalidadeCadastro.jsp">Modalidades</a>
                    </li>
                </ul>
            </div>
        </div>
    	</nav>
    	<% Pais pais = (Pais)request.getAttribute("pais"); %>
    	<% Modalidade modalidade = (Modalidade)request.getAttribute("modalidade"); %>
    	<% Olimpiada olimpiada = (Olimpiada)request.getAttribute("olimpiada");%>
		<br><br><br><br>
		<div class="container">
			
			<h2 class="page-header"><%=pais.getNome() %>, <%=modalidade.getNome() %>, <%=olimpiada.getAno() %></h2>
			
			<div class="row">
				<div class="col-md-4">
					<h3>Ouro</h3>
					<p><%= modalidade.getOuro() %>
				</div>
				<div class="col-md-4">
					<h3>Prata</h3>
					<p><%= modalidade.getPrata() %>
				</div>
				<div class="col-md-4">
					<h3>Bronze</h3>
					<p><%= modalidade.getBronze() %>
				</div>
			<hr>
			
	
		</div>
		
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>