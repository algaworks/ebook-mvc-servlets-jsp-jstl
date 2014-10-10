<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="nomeParametro" required="true"  %>
<%@ attribute name="descricaoParametro" required="true"  %>
<%@ attribute name="descricaoBotao" required="false"  %>
<%@ attribute name="acao" required="true"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty descricaoBotao}">
	<c:set var="descricaoBotao" value="Consultar" />
</c:if>

<form action="${acao}" method="get">
	${descricaoParametro}:
	<input type="text" name="${nomeParametro}" value="${param[nomeParametro]}" />
	<input type="submit" value="${descricaoBotao}" />
</form>