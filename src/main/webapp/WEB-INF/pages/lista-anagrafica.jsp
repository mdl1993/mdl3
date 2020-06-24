<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html>
<head><title>Anagrafica</title>

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
	<h1>Lista Anagrafiche</h1>

	<a href="openInsert">nuovo</a>
	<br><br>

	
	<div class="row">
                <div class="col-xs-9">
                    <div class="box">
                        <div class="box-header">
                        <h3 class="box-title"><b>Lista Anagrafiche</b></h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <tbody>
                                <tr>
                                    <th><b>Nome</b></th>
                                    <th><b>Cognome</b></th>
                                    <th><b>Codice Fiscale</b></th>
                                    <th>Stato</th>
                                    <th>action</th>
                                </tr>
                                <c:forEach var="item" items="${anagrafiche}">
                                    <tr>
                                        <td>${item.nome}</td>
                                        <td>${item.cognome}</td>
                                        <td>${item.codiceFiscale}</td>
                                        <c:if test="${item.id % 2 != 0}"><td><span class="label label-warning">In attesa</span></td></c:if>
                                        <c:if test="${item.id % 2 == 0}"><td><span class="label label-success">Assunto</span></td></c:if>
                                        <td><a href="<spring:url value="/anagrafica/get/${item.id}"/>">Apri Dettaglio</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>

</body>
</html>