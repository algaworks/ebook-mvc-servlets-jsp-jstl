<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="aw" tagdir="/WEB-INF/tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>Consulta de produtos</h1>

	<aw:pesquisa acao="consulta-produtos" nomeParametro="nome" 
		descricaoParametro="Nome" />
	
	<c:if test="${empty produtos}">
		<strong>Nenhum produto encontrado.</strong>
	</c:if>
	
	<c:if test="${not empty produtos}">
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Preço</th>
			<th>Quantidade</th>
		</tr>
		
		<c:forEach items="${produtos}" var="produto">
		<tr>
			<td>${produto.nome}</td>
			<td>
				<fmt:setLocale value="pt_BR" />
				<fmt:formatNumber type="currency" value="${produto.precoCusto}" />
			</td>
			<td>${produto.quantidadeEstoque}</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	
	<c:import url="/WEB-INF/paginas/rodape.jsp" />
</body>
</html>