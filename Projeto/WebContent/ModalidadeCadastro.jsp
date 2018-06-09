<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<br><br>
		<div class="container">
			<h1 class="page-header">Cadastro de Modalidade</h1>
			<form action="controller.do" method="post">
				<div class="row">
					<div class="form-group col-md-12">
							<label for="modalidade"><strong>Nome da Modalidade</strong></label>
							<input type="text" class="form-control" name="modalidade" placeholder="Digite o nome da Modalidade">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
							<label for="modalidade"><strong>Tipo</strong></label>
							<input type="text" class="form-control" name="tipo" placeholder="Digite se é Verão(V) ou Inverno (I)">
					</div>
				</div>
				<hr />
				<div class="row text-right">
	                	<div class="col-md-12">
	                    	<button type="submit" class="btn btn-primary" name="command" value="CadastrarModalidade">Criar</button>	
	                    		<a href="index.html" class="btn btn-default">Cancelar</a>
	               		</div>
	           	</div>
		</div>
		
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>