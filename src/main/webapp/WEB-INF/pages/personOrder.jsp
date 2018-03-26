<!DOCTYPE HTML>


<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="index.section.main" var="lbSectMain"/>
<spring:message code="newRate.li.div" var="lbLiDiv"/>
<spring:message code="contact.div.ul.liA" var="lbUlLiA"/>
<spring:message code="contact.div.ul.liB" var="lbUlLiB"/> 
<spring:message code="contact.div.ul.liC" var="lbUlLiC"/>
<spring:message code="contact.div.ul.liD" var="lbUlLiD"/>
<spring:message code="contact.div.ul.liE" var="lbUlLiE"/>
<spring:message code="personCost.head.title" var="lbTitle"/>
<spring:message code="contact.cancel" var="lbCancel"/>
<spring:message code="personCost.send" var="lbSend"/>

<spring:message code="personOrder.headerA" var="lbHeaderA"/>
<spring:message code="personOrder.headerB" var="lbHeaderB"/>
<spring:message code="personOrder.table.tdAA" var="lbTableAA"/>
<spring:message code="personOrder.table.tdAB" var="lbTableAB"/>
<spring:message code="personOrder.table.tdBA" var="lbTableBA"/>
<spring:message code="personOrder.table.tdBB" var="lbTableBB"/>

<spring:message code="contact.place.Mname" var="lbPlaceMname"/>
<spring:message code="contact.place.Lname" var="lbPlaceLname"/>
<spring:message code="contact.place.Fname" var="lbPlaceFname"/>


<html>
<head>
    <title>${lbTitle}</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  	<link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400;300" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>



<%@ include file = "menuGeneral.jsp" %>
<%@ include file = "menuCustomer.jsp" %>


<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbHeaderA}</h2>
            <p>${lbHeaderB}</p>
        </header>
        <form class="registration">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <td width="200" valign="top">
                        <label for="lastName"><b>${lbTableAA}</b></label>
                        <input type="text" placeholder="${lbPlaceLname }" name="lastName" id="lastName" required>

                        <label for="firstName"><b>${lbTableAB}</b></label>
                        <input type="text" placeholder="${lbPlaceFname }" name="firstName" id="firstName" required>
                    </td>

                    <td width="200" valign="top">
                        <label for="patronymic"><b>${lbTableBA}</b></label>
                        <input type="text" placeholder="${lbPlaceMname }" name="patronymic" id="patronymic" required>

                        <label for="telephone"><b>${lbTableBB}</b></label>
                        <input type="text" placeholder="+7(926)723-16-50" name="telephone" id="telephone" required>
                    </td>

                </table>
                <div class="clearfix">
                    <button type="button" class="cancelbtn">${lbCancel }</button>
                    <button type="submit" class="signupbtn"><a href="resultCost.html">${lbSend}</a></button>
                </div>

            </div>
        </form>
    </div>
</section>


<!-- Main -->



<!-- Scripts -->
<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>

</body>
</html>