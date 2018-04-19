<!DOCTYPE HTML>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:message code="newRate.li.div" var="lbLiDiv"/>
<spring:message code="index.section.main" var="lbSectMain"/>
<spring:message code="contact.head.title" var="lbHeadTitle"/>
<spring:message code="contact.div.ul.liA" var="lbUlLiA"/>
<spring:message code="contact.div.ul.liB" var="lbUlLiB"/>
<spring:message code="contact.div.ul.liC" var="lbUlLiC"/>
<spring:message code="contact.div.ul.liD" var="lbUlLiD"/>
<spring:message code="contact.div.ul.liE" var="lbUlLiE"/>
<spring:message code="personal.section.p" var="lbSectionP"/>
<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="contact.cancel" var="lbCancel"/>
<spring:message code="resultCost.issue" var="lbIssue"/>

<spring:message code="resultCost.header.H" var="lbHeaderH"/>
<spring:message code="resultCost.header.P" var="lbHEaderP"/>
<spring:message code="resultCost.table.trA.tdA" var="lbTableAA"/>
<spring:message code="resultCost.table.trA.tdB" var="lbTableAB"/>
<spring:message code="resultCost.table.trB.tdA" var="lbTableBA"/>
<spring:message code="resultCost.table.trB.tdB" var="lbTableBB"/>
<spring:message code="resultCost.table.trC.tdA" var="lbTableCA"/>

<spring:message code="resultCost.time.begin" var="lbTimeBg"/>
<spring:message code="resultCost.time.end" var="lbTimeEnd"/>





<html>
<head>
    <title>${lbHeadTitle}</title>
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
            <h2>${lbHeaderH }</h2>
            <p>${lbHEaderP}</p>
        </header>
        <form class="registration" method="post" action="${contextPath}/result" name="result"  id="result">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr ><td colspan="4" width="200" valign="top">
                       ${lbTableAA} ${costCalcRes.typeDelivery}
                    </td>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableAB} ${costCalcRes.totalCost}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableBA} ${costCalcRes.dateCurrent}
                        </td>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableBB} ${costCalcRes.dateDelivery } 
                        </td>
                        <td colspan="2" width="200" valign="top">
                            ${lbTimeBg } ${costCalcRes.quatityHours} ${lbTimeEnd }
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" width="200" valign="top">
                            ${lbTableCA} ${costCalcRes.fullPath}
                        </td>
                    </tr>
                </table>

                <div class="clearfix">
                    <button onclick="location.href = '${contextPath}/costCalculation';" type="button" class="cancelbtn">${lbCancel }</button>
                    <button type="submit" class="signupbtn">${lbIssue}</button>
                </div>

            </div>
        </form>
    </div>
</section>

<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>
</body>
</html>