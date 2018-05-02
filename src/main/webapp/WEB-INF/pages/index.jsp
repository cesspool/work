<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<spring:message code="index.title" var="lbTitle"/>
<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="index.section.main" var="lbSectMain"/>
<spring:message code="index.section.descrA" var="lbSectDescrA"/>
<spring:message code="index.section.descrB" var="lbSectDescrB"/>
<spring:message code="index.section.descrC" var="lbSectDescrC"/>
<spring:message code="index.header.main" var="lbHeader"/>
<spring:message code="index.divB" var="lbDivB"/>
<spring:message code="index.ul.li" var="lbUlLi"/>
<spring:message code="newRate.li.div" var="lbLiDiv"/>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<title>${lbTitle}</title>
<spring:message code="index.divA" var="lbDivA"/>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>
		<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
		<link rel="icon" type="image/png" href="<c:url value="/resources/Login_v2/images/icons/favicon.ico"/>"/>
		<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	</head>
	<body >

	<%@ include file = "menuGeneral.jsp" %>
	
    <c:choose>
        <c:when test="${not empty sessionScope.principal and sessionScope.principal.admin}">
            <%@ include file = "menuAdmin.jsp" %>
        </c:when>
        <c:when test="${not empty sessionScope.principal and sessionScope.principal.manager}">
            <%@ include file = "menuManager.jsp" %>
        </c:when>
        <c:when test="${not empty sessionScope.principal}">
            <%@ include file = "menuCustomer.jsp" %>
        </c:when>
    </c:choose>
              
              <div style="float: right; color: white; background: blue;">  
                <select id="selLangID">
                    <option value="ru_RU">РУС</option>
                    <option value="en_EN">EN</option>
                </select>
             </div>
                

		<!-- Banner -->
			<section id="banner">
				<h2>${lbSectMain}</h2>
				<p>${lbSectDescrA}<br />${lbSectDescrB}<br /><br />${lbSectDescrC}</p>
				<ul class="actions">
					<li><a href="${contextPath}/costCalculation" class="button special big">${lbUlLi}</a></li>
				</ul>
			</section>

			<!-- One -->
				<section id="one" class="wrapper style1">
					<div class="container 75%">
						<div class="row 200%">
							<div class="6u 12u$(medium)">
								<header class="major">
									<h2>${lbHeader}</h2>
								</header>
							</div>
							<div class="6u$ 12u$(medium)">
								<p>${lbDivA}</p>
								<p>${lbDivB}</p>
							</div>
						</div>
					</div>
				</section>

		<!-- Scripts -->
			<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
			<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
			<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
			<script src="<c:url value="/resources/assets/js/main.js"/>"></script>
			
			<script src="<c:url value="/resources/js/jquery.js"/>"></script>
			<script src="<c:url value="/resources/js/menu.js"/>"></script>
            <script src="<c:url value="/resources/js/index.js"/>"></script>
	</body>
</html>