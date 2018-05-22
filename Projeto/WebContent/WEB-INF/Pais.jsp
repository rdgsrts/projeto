<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pais</title>

 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">

</head>
<body>

<div id="main" class="container"> 

	<div class="row">
		<div class="col-md-12">
		
			<p><strong>Nome:</strong> </p>
			<p>${pais.nome}</p><br>
		</div>
	</div>
		
	<div class="row">
		<div class="col-md-6">
		
			<p><strong>População:</strong> </p>
			<p>${pais.populacao}</p><br>
		</div>
	
		
		<div class="col-md-6">
			<p><strong>Área</strong></p><br>
			<p>${ pais.area }</p>
			<br>
		</div>
	
	</div>
	 <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.jsp" class="btn btn-default">Voltar</a>
                </div>
     </div>
</div>
</body>
</html>