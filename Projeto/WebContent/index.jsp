<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div class="card-body">
				<h3>Buscar País</h3>
				<p class="card-text">Descubra quantas medalhas seu país
					conquistou em qualquer edição das Olimpíadas</p>
				<div class="container">
					<form action="buscaPais" method="get">
						<div class="form-row">
							<div class="md-form col">
								<input type="text" id="Pais" name="nomePais" class="form-control">
								<label for="pais">País</label>
							</div>
							<div class="md-form col">
								<select class="custom-select mr-sm-2" name="idAno">
									<option>Ano</option>
									<option value=2016>2016</option>
									<optiom value=2004>2004</optiom>/option>
								</select>
							</div>
						</div>
						
				 		<input type="submit" class="btn btn-primary">
				 		
					
					</form>
				
				</div>
				
			</div>
		</div>
		
		
		
		<script type="text/javascript" src="js/mdb.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	</body>
</html>