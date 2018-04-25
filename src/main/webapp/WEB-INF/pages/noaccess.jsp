<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:message code="noaccess.name" var="lbNoAccess"/>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<title>${lbTitle}</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>
		<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	</head>
	<body class="landing">
	
<!-- Banner -->
			<section id="banner">
				<h2>${lbNoAccess }</h2>
			</section>

		<!-- Scripts -->
			<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
			<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
			<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
			<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

	</body>
</html>