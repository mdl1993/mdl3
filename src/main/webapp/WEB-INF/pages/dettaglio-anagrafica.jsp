<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html>
<head>
<title>Anagrafica</title>

<link href="<spring:url value='/css/jquery-ui.css' />" rel="stylesheet">

<script src="<spring:url value='/js/jquery.js' />" type="text/javascript"></script>
<script src="<spring:url value='/js/jquery-ui.js' />" type="text/javascript"></script>
<script src="<spring:url value='/js/application.js' />" type="text/javascript"></script>

</head>
<body>
		<a href="<spring:url value="/anagrafica/list"/>">Ritorna alla lista</a>
		
		<!-- Tabs -->
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">Dettaglio Anagrafica</a></li>
				<li><a href="#tabs-2">Lista Contratti</a></li>
			</ul>
			<div id="tabs-1">
			
				<h1>Dettaglio Anagrafica</h1>
			
				<label>First name:</label>
				<b>${anagrafica.nome}</b><br> 
				
				<label>Last name:</label> 
				<b>${anagrafica.cognome}</b><br>
		
				<label>Fiscal Code:</label> 
				<b>${anagrafica.codiceFiscale}</b><br>
				
				<label>Provincia di nascita:</label> 
				<b>${anagrafica.provinciaNascita.descrizione}</b><br>
				
				<label>Age:</label> 
				<b>${anagrafica.eta}</b><br>
		
				<label>Sesso:</label> 
				<b>
				<c:if test="${anagrafica.sesso == 'M'}">Maschile</c:if>
				<c:if test="${anagrafica.sesso == 'F'}">Femminile</c:if>
				</b><br>
		
				<label>Categoria protetta:</label>
				<input type="checkbox" <c:if test="${anagrafica.categoriaProtetta}">checked</c:if> disabled /><br>
		
				<label>curriculum:</label><br> 
				<textarea rows="10" cols="100" name="curriculum" readonly="readonly" >${anagrafica.curriculum}</textarea><br><br>			
		
			<a href="<spring:url value="/anagrafica/openUpdate/${anagrafica.id}"/>">Modifica</a>
			<a href="<spring:url value="/anagrafica/delete/${anagrafica.id}"/>">Elimina</a>
		
			</div>

			<div id="tabs-2">
			
				CIAO
			
			</div>

		</div>
</body>
</html>