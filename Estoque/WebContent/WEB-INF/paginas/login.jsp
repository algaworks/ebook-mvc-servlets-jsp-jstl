<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>Login</h1>

	<c:if test="${not empty mensagem}">
		<strong>${mensagem}</strong><br/><br/>
	</c:if>

	<form action="login" method="post">
		Usuário:
		<input type="text" name="usuario" size="12" value="${param.usuario}" /><br/>
		Senha:
		<input type="password" name="senha" size="12" /><br/>
		
		<input type="submit" value="Login" />
	</form>
	
</body>
</html>