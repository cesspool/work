<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:message code="newRate.head.title" var="lbHeadTitle"/>
<spring:message code="index.section.main" var="lbSectMain"/>
<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="newRate.li.div" var="lbLiDiv"/>

<spring:message code="newRate.ulA" var="lbUlA"/>
<spring:message code="newRate.ulB" var="lbUlB"/>
<spring:message code="newRate.ulC" var="lbUlC"/>
<spring:message code="newRate.ulD" var="lbUlD"/>
<spring:message code="newRate.ulE" var="lbUlE"/>

<spring:message code="contact.cancel" var="lbCancel"/>
<spring:message code="personCost.send" var="lbSend"/>

<spring:message code="newRate.section.header" var="lbUlHeader"/>
<spring:message code="newRate.section.p" var="lbUlSect"/>

<spring:message code="newRate.section.trB.tdA" var="lbSectionBA"/>
<spring:message code="newRate.section.trB.tdB" var="lbSectionBB"/>
<spring:message code="newRate.section.trB.tdC" var="lbSectionBC"/>
<spring:message code="newRate.section.trB.tdD" var="lbSectionBD"/>

<spring:message code="changingTransport.changingMax" var="lbNameTitle"/>



<html>
<head>
    <title>${lbHeadTitle}</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400;300" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <link rel="icon" type="image/png" href="<c:url value="/resources/Login_v2/images/icons/favicon.ico"/>"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>

<%@ include file = "menuGeneral.jsp" %>
<%@ include file = "menuAdmin.jsp" %>

<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbNameTitle}</h2>
            <p>${lbUlSect}</p>
        </header>
        <form method="post" action="${contextPath}/changingTransport" id = "changingTransport" class = "changingTransport">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5"> 
                    <tr>
                        <td width="200" valign="top">
                            <label for="totalWeight"><b>${lbSectionBA}</b></label>
                            <input value = "${weight }" type="text" placeholder="10" name="totalWeight" id="totalWeight" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="maxLength"><b>${lbSectionBB}</b></label>
                            <input value = "${length }" type="text" placeholder="0.6" name="maxLength" id="maxLength" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="maxWidth"><b>${lbSectionBC}</b></label>
                            <input value = "${width }" type="text" placeholder="0.3" name="maxWidth" id="maxWidth" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="maxHeight"><b>${lbSectionBD}</b></label>
                            <input value = "${height }" type="text" placeholder="0.2" name="maxHeight" id="maxHeight" required>
                        </td>
                    </tr>
                </table>
 					<div class="clearfix">
                    	<button onclick="location.href = '${contextPath}/changingAgreement';" type="button" class="cancelbtn">${lbCancel }</button>
                    	<button type="submit" class="signupbtn">${lbSend}</button>
                	</div>
            </div>
        </form>
    </div>
</section>

<!-- Main -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>


<!-- Scripts -->
<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>


</body>
</html>
