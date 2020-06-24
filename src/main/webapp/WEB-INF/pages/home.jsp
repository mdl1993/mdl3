<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>HOME</title>

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
        <script src="<spring:url value='/js/application.js' />" type="text/javascript"></script>
	</head>
	<body>
		<section>
			<div>
				<a href="<spring:url value='/anagrafica/list' />">
					Accedi
				</a><br>
			</div>
		</section>
	</body>
</html>