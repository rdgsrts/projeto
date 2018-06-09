<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalLabel">Excluir Olimpiada</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir esta Olimpiada?
                        </div>
                        <div class="modal-footer">
                            <form action="controller.do" method="post">
                                <input type="hidden" name="ano" value="${olimpiada.ano }" />
                                <input type="hidden" name="modalidade" value="${modalidade.id }" />
                                <input type="hidden" name="pais" value="${pais.id }" />
                                <button type="submit" class="btn btn-primary" name="command" value="ExcluirOlimpiadas">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
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
			<form action="controller.do" method="post">
			<input type="hidden" class="form-group" value="${pais.id }" name="pais">
			<input type="hidden" class="form-group" value="${modalidade.id }" name="modalidade">
			<input type="hidden" class="form-group" value="${olimpiada.ano}" name="ano">
			<input type="hidden" class="form-group" value="${modalidade.ouro }" name="ouro">
			<input type="hidden" class="form-group" value="${modalidade.prata }" name="prata">
			<input type="hidden" class="form-group" value="${modalidade.bronze}" name="bronze">
			<input type="hidden" class="form-group" value="${pais.nome }" name="paisNome">
						<input type="hidden" class="form-group" value="${modalidade.nome }" name="modalidadeNome">
			<c:if test="${modalidade.ouro >= 0 || modalidade.prata >= 0 || modalidade.bronze >= 0}">
				<h2 class="page-header">${pais.nome }, ${modalidade.nome }, ${olimpiada.ano}</h2>
				
				<div class="row">
					<div class="col-md-4">
						<h3>Ouro</h3>
						<p>${modalidade.ouro }</p>
					</div>
					<div class="col-md-4">
						<h3>Prata</h3>
						<p>${modalidade.prata }</p>
					</div>
					<div class="col-md-4">
						<h3>Bronze</h3>
						<p>${modalidade.bronze }</p>
					</div>
				<hr>
				<br>
				<div class="row">
					<div class="col-md-12 text-right">
						<button type="submit" class="btn btn-primary" name="command" value="PaginaEditarOlimpiada">Editar</button>
				</form>
						<button type="button" class="btn btn-primary" name="acao" value="excluirOlimpiada" data-toggle="modal" data-target="#delete-modal">Excluir</button>
					</div>
				</div>
		
				</div>
			</c:if>
			<c:if test="${modalidade.ouro < 0 || modalidade.prata < 0 || modalidade.bronze < 0}">
				<form action="ManterOlimpiada.do" method="post">
				
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4 text-center">
						<h2>O pais ${pais.nome }</h2>
						<p>Não está cadastrado na modalidade ${modalidade.nome }, no ano de ${olimpiada.ano }</p>
						<h4>Deseja Cadastrar?</h4>
						<input type="hidden" class="form-group" value="${pais.id }" name="pais">
						<input type="hidden" class="form-group" value="${modalidade.id }" name="modalidade">
						<input type="hidden" class="form-group" value="${pais.nome }" name="pais">
						<input type="hidden" class="form-group" value="${modalidade.nome }" name="modalidade">
						<input type="hidden" class="form-group" value="${olimpiada.ano}" name="ano">
						<button type="submit" class="btn btn-primary" name="command" value="PaginaCadastrarOlimpiada">Cadastrar</button>
					</div>
				
				
		
				</div>
				</form>
			</c:if>
		</div>
		
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>