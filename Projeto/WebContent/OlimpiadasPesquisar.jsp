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
		<br><br><br><br>
		<div class="container">
			<form action="ManterOlimpiada.do" method="post">
			<h2 class="page-header">Pesquisar Medalhas</h2>
			
			<div class="row">
				<div class="col-md-4">
					<select type="text" name="pais" class="form-control">
				    	<option>- Selecione uma opção -</option>
				       	<%
				       	List<Pais> pais = (List<Pais>)request.getAttribute("pais");
				       	for(Pais p : pais){
				       	%>
				       	<option value="<%=p.getId()%>"><%=p.getNome()%></option>
				       	<%}
				       	%>    	
    				</select>
				</div>
				<div class="col-md-4">
					<select type="text" name="modalidade" class="form-control">
				    	<option>- Selecione uma opção -</option>
				       	<%
				       	
				       	List<Modalidade> modalidade = (List<Modalidade>)request.getAttribute("modalidade"); 
				       	for(Modalidade m : modalidade){
				       	%>
				       	<option value="<%=m.getId()%>"><%=m.getNome()%></option>
				       	<%}
				       	%>    	
    				</select>
				</div>
				<div class="col-md-4">
					<select type="text" name="ano" class="form-control">
				    	<option>- Selecione uma opção -</option>
				       	<%
						List<Olimpiada> olimpiada = (List<Olimpiada>)request.getAttribute("olimpiada");
				       	for(Olimpiada o : olimpiada){
				       	%>
				       	<option value="<%=o.getAno()%>"><%=o.getAno()%></option>
				       	<%}
				       	%>    	
    				</select>
				</div>
				
			</div>
			<hr>
			<div class="row">
				<div class="col-md-9"></div>
				<div class="col-md-3 text-right">
					<button type="submit" class="btn btn-primary" name="acao" value="carregarMedalhas">Pesquisar</button>
				</div>
			</div>
			</form>
		</div>
		
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>