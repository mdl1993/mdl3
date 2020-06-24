<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
	<head><title><spring:message code="anagrafica" /></title>
	

        <link href="<spring:url value='/css/font-awesome/font-awesome.min.css' />" rel="stylesheet" type="text/css">
        <link href="<spring:url value='/css/ionicons/ionicons.min.css' />" rel="stylesheet" type="text/css">
        <link href="<spring:url value='/css/bootstrap/bootstrap.min.css' />" rel="stylesheet" type="text/css">
        <link href="<spring:url value='/css/adminlte.min.css' />" rel="stylesheet" type="text/css">
        <link href="<spring:url value='/css/skins/adminlte-skins.min.css' />" rel="stylesheet" type="text/css">
        <link href="<spring:url value='/css/application.css' />" rel="stylesheet" type="text/css">

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic" rel="stylesheet" type="text/css">

        <script src="<spring:url value='/js/jquery.js' />" type="text/javascript"></script>
        <script src="<spring:url value='/js/bootstrap/bootstrap.min.js' />" type="text/javascript"></script>
        <script src="<spring:url value='/js/adminlte.min.js' />" type="text/javascript"></script>
        <script src="<spring:url value='/js/application.js' />" type="text/javascript"></script></head>
	<body>
		<h1><spring:message code="nuovaAnagrafica" /></h1>

		<c:if test="${fn:length(errors.allErrors) > 0}">
			<div>
				<h4>Errori:</h4>
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</c:if>		

		<br>
		<form:form id="form" action="insert" modelAttribute="anagraficaForm">
			
			<label for="nome"><spring:message code="anagrafica.nome" /></label><br> 
			<form:input path="anagrafica.nome" id="nome" maxlength="100"/><br>
			
			<label for="cognome"><spring:message code="anagrafica.cognome" /></label><br>
			<form:input path="anagrafica.cognome" id="cognome" maxlength="100"/><br> 
	
			<label for="codiceFiscale"><spring:message code="anagrafica.codiceFiscale" /></label><br> 
			<form:input path="anagrafica.codiceFiscale" id="codice-fiscale" maxlength="16"/><br> 
	
			<label><spring:message code="anagrafica.provinciaNascita" /></label><br>
			<form:select path="anagrafica.provinciaNascita.idProvincia" id="provincia-nascita">
				<form:option value="" label="--Vuoto--" />
				<form:options items="${province}" />
			</form:select>
			<br>
			
			<label for="eta"><spring:message code="anagrafica.eta" /></label><br> 
			<form:input path="anagrafica.eta" id="eta" maxlength="2"/><br> 
	
			<label for="sesso"><spring:message code="anagrafica.sesso" /></label> 
			<label> M</label><form:radiobutton path="anagrafica.sesso" id="sesso-m" value="M" />
			<label> F</label><form:radiobutton path="anagrafica.sesso" id="sesso-f" value="F" />
			<br>
			
			<label for="eta"><spring:message code="anagrafica.categoriaProtetta" /></label>
			<form:checkbox path="anagrafica.categoriaProtetta" id="categoria-protetta" />
			<br>

			<label for="eta"><spring:message code="anagrafica.curriculum" /></label><br> 
			<form:textarea path="anagrafica.curriculum" id="curriculum" /><br><br>
	
			<input type="submit" name="update" value="Salva">
	
		</form:form>
	</body>
</html>