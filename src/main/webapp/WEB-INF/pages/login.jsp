<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="login.div.spanA" var="lbDivA"/>
<spring:message code="login.div.spanB" var="lbDivB"/>
<spring:message code="login.div.spanC" var="lbDivC"/>
<spring:message code="login.div.spanD" var="lbDivD"/>
<spring:message code="index.section.main" var="lbSectMain"/>
<spring:message code="newRate.li.div" var="lbLiDiv"/>


<html lang="en">
<head>
	<title>${lbSectMain}</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<c:url value="/resources/Login_v2/images/icons/favicon.ico"/>"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/Login_v2/vendor/bootstrap/css/bootstrap.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/Login_v2/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/Login_v2/fonts/iconic/css/material-design-iconic-font.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/Login_v2/vendor/animate/animate.css"/>">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/Login_v2/vendor/css-hamburgers/hamburgers.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/Login_v2/vendor/animsition/css/animsition.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/Login_v2/vendor/select2/select2.min.css"/>">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/Login_v2/vendor/daterangepicker/daterangepicker.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/Login_v2/css/util.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/Login_v2/css/main.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css" />"/>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/personCost.css"/>" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/loginMes.css" />"/>
<!--===============================================================================================-->
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

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method="post" id="loginForm" action="${contextPath}/login">
					<span class="login100-form-title p-b-26">
						${lbDivA}
					</span>
					<span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
						<input class="input100" type="text" name="email" id="email">
						<span class="focus-input100" data-placeholder="Email"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="pass" id="pass">
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit">
								${lbDivB}
							</button>
						</div>
					</div>
                    <c:if test="${not empty message}">    
                    <div>
	                      <div> <!-- ERROR MESSAGE BOX -->
		                      <p>${message.msg}</p>
						  </div>
					  </div>
                    </c:if>
                    
					<div class="text-center p-t-115">
						<span class="txt1">
							${lbDivC}
						</span>

						<a class="txt2" href="${contextPath}/registrationform">
							${lbDivD}
						</a>
					</div>
				</form>
				
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
	<script src="<c:url value="/resources/Login_v2/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/resources/Login_v2/vendor/animsition/js/animsition.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/resources/Login_v2/vendor/bootstrap/js/popper.js"/>"></script>
	<script src="<c:url value="/resources/Login_v2/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/resources/Login_v2/vendor/select2/select2.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/resources/Login_v2/vendor/daterangepicker/moment.min.js"/>"></script>
	<script src="<c:url value="/resources/Login_v2/vendor/daterangepicker/daterangepicker.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/resources/Login_v2/vendor/countdowntime/countdowntime.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/resources/Login_v2/js/main.js"/>"></script>

	<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/main.js"/>"></script>
	<!-- src="<c:url value="/resources/js/message.js"/>"></script-->
	
	<script src="<c:url value="/resources/js/jquery.js"/>"></script>
	<script src="<c:url value="/resources/js/menu.js"/>"></script>


</body>
</html>