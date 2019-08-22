<!-- Import correção acentuação -->
<%@ page contentType="text/html; charset=ISO-8859-1" language="java"
	pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!-- Import da taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cultura - Edit</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
.bs-example {
	margin: 20px;
}
</style>

</head>
<body>
	<div class="container" style="margin-top: 30px;">
		<h5>Cultura - Updating</h5>
		<hr/>
		<form action="<c:url value="/cultura/update"/>" method="post">
		<input type="hidden" name="cultura._id" value="${cultura._id}" />
					<div class="form-group row">
				<label class="col-sm-3 col-form-label" for="cultura.codigo">Código</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="cultura.codigo"
						name="cultura.codigo" value="${cultura.codigo}" readonly="true">
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-3 col-form-label" for="cultura.codigo">Descrição</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="cultura.descricao"
						name="cultura.descricao" value="${cultura.descricao}">
				</div>
			</div>
					<div class="row">
				<div class="col-sm-9 offset-sm-3">
					<button type="submit" class="btn btn-success save-btn">Save</button>
					<a href="${linkTo[IndexController].index}" class="btn btn-light"
						role="button">Voltar</a>
				</div>
			</div>

		</form>
	</div>
</body>
</html>