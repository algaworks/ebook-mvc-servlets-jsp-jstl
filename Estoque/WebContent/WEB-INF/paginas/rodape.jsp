<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br/><br/>
Usuário <strong>${sessionScope.usuarioLogado}</strong> logado desde 
<fmt:formatDate value="${sessionScope.dataLogin}" pattern="dd/MM/yyyy HH:mm:ss"/>
<br/><br/>

<a href="logout">Logout</a>