<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>Cadastro de produto</h1>

	<c:if test="${not empty mensagem}">
		<strong>${mensagem}</strong><br/><br/>
	</c:if>

	<form action="cadastro-produto" method="post">
		Nome:
		<input type="text" name="nome" size="20" value="${form.nome}" /><br/>
		Preço de custo:
		<input type="text" name="preco" size="8" value="${form.preco}" /><br/>
		
		Quantidade em estoque:
		<input type="text" name="quantidade" size="8" value="${form.quantidade}" /><br/>
		
		<input type="submit" value="Cadastrar">
	</form>
	
	<c:import url="/WEB-INF/paginas/rodape.jsp" />
</body>
</html>