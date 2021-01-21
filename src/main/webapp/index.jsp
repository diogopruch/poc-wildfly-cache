<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cache no Wildfly com Redis</title>
</head>
<body>
	<jsp:useBean id="controller" class="br.pucminas.arq.tcc.Controller" scope="request" />

	<h3>Cache no Wildfly com Redis</h3>
	<c:forEach var="municipio" items="${controller.getMunicipios()}">
        <c:out value="${municipio.id}"/> - <c:out value="${municipio.nome}"/> - <c:out value="${municipio.microrregiao.mesorregiao.uf.sigla}"/><br>
   </c:forEach>
</body>
</html>
