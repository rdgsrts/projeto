<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
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
    <div id="main" class="container">
       <h3 class="page-header">Login</h3>
        <form action="controller.do" method="post">
				<div class="row col-md-12">
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span></div> 
					   <input type="email" name="username" id="username" class="form-control" maxlength="60" placeholder="E-mail" required/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span></div> 
					   <input type="password" name="passwd" id="passwd" class="form-control" placeholder="Senha" required/>
					</div>
				</div>
				</div>
				<div class="row col-md-12">
					<button type="submit" class="btn btn-primary" name="command" value="FazerLogin"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Ok</button>
				</div>
			</form>    
			</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>