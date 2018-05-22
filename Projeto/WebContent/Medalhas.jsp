<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Pais" %>
<%@page import="model.Olimpiada" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projeto Olimpiada</title>
		<link rel="stylesheet" href="css/mdb.min.css" type="text/css" />
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		
		<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div class="card text-center">
		<div class="card-header">
			<ul class="nav nav-pills card-header-pills">
				<li class="nav-item">Projeto Olimpiada</li>
			</ul>
		</div>
	<%Pais pais = (Pais)request.getAttribute("pais");%>
	<h2 class="text-left" style="margin:50px 0 50px 400px;"><%=pais.getNome() %></h2>
	<%int total = (int) request.getAttribute("total"); %>
	<h5 class="text-left" style="margin:-50px 0 50px 400px;">Total de Medalhas: <%=total %></h5>
	
	<div class="container">
		<table class="table table-hover" style="margin-bottom:50px">

		    <!--Table head-->
		    <thead>
		        <tr>
		            <th>Modalidade</th>
		            <th>Ouro</th>
		            <th>Prata</th>
		            <th>Bronze</th>
		        </tr>
		    </thead>
		    <!--Table head-->
		
		    <!--Table body-->
		    <tbody>
		    		
		        <c:forEach var="medalhas" items="${requestScope.list}">
			        <tr>
			            <td>${medalhas.nomeModalidade}</td>
			            <td>${medalhas.ouro}</td>
			            <td>${medalhas.prata }</td>
			            <td>${medalhas.bronze }</td>
			        </tr>
		        </c:forEach>
		        <%-- <tr>
		            <td colspan="3"></td>
		            <td><strong>Total</strong></td>
		            <% int total = (int)request.getAttribute("total");%>
		            <td><%= total %></td>
		        </tr> --%>
		        
		    </tbody>
		    <!--Table body-->
		
		</table>
		
		</div>
		</div>
	<script type="text/javascript" src="js/mdb.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>