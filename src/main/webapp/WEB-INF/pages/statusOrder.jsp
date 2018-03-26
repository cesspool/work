<!DOCTYPE HTML>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:message code="newRate.li.div" var="lbLiDiv"/>
<spring:message code="index.section.main" var="lbSectMain"/>
<spring:message code="contact.head.title" var="lbHeadTitle"/>
<spring:message code="newRate.ulA" var="lbUlA"/>
<spring:message code="newRate.ulB" var="lbUlB"/>
<spring:message code="newRate.ulC" var="lbUlC"/>
<spring:message code="newRate.ulD" var="lbUlD"/>
<spring:message code="newRate.ulE" var="lbUlE"/>
<spring:message code="personal.section.p" var="lbSectionP"/>
<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="contact.div.ul.liA" var="lbUlLiA"/>
<spring:message code="contact.save" var="lbSave"/>
<spring:message code="contact.cancel" var="lbCancel"/>
<spring:message code="statusOrder.searching" var="lbSearch"/>
<spring:message code="statusOrder.place.recipient" var="lbPlaceRecipient"/>


<spring:message code="history.table.trA.tdA" var="lbTableAA"/>
<spring:message code="history.table.trA.tdB" var="lbTableAB"/>
<spring:message code="history.table.trB.tdA" var="lbTableBA"/>
<spring:message code="history.table.trB.tdB" var="lbTableBB"/>
<spring:message code="history.table.trB.tdC" var="lbTableBC"/>
<spring:message code="history.table.trB.tdD" var="lbTableBD"/>
<spring:message code="history.table.trC.tdA" var="lbTableCA"/>
<spring:message code="history.table.trC.tdB" var="lbTableCB"/>
<spring:message code="history.table.trC.tdC" var="lbTableCC"/>
<spring:message code="history.table.trC.tdD" var="lbTableCD"/>
<spring:message code="history.table.trD.tdA" var="lbTableDA"/>
<spring:message code="history.table.trD.tdB" var="lbTableDB"/>
<spring:message code="history.table.trD.tdC" var="lbTableDC"/>
<spring:message code="history.table.trD.tdD" var="lbTableDD"/>
<spring:message code="history.table.trE.tdA" var="lbTableEA"/>
<spring:message code="history.table.trE.tdB" var="lbTableEB"/>
<spring:message code="history.table.trE.tdC" var="lbTableEC"/>
<spring:message code="statusOrder.ready" var="lbReady"/>


<html>
<head>
    <title>${lbUlLiB}</title>
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
<%@ include file = "menuAdmin.jsp" %>

<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbUlLiA}</h2>
            <input type="text" placeholder = "${lbPlaceRecipient}" id="name" name="name">
            <br>
            <button type="submit" class="signupbtn">${lbSearch}</button>
        </header>
        <form class="registration">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr ><td class="someTable" width="200" valign="top">
                            ${lbTableAA} <data>14251</data>
                        </td>
                        <td class="someTable" colspan="2" width="200" valign="top">
                            ${lbTableAB} <data>1561 руб</data>
                        </td>
                        <td width="200" valign="top">
							 <input type="checkbox" id="ready" name="ready" value="air">
                            <label for="ready">${lbReady}</label>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbTableBA} <data>express</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableBB} <data>standart</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableBC} <data>name</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableBD} <data>1.5</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbTableCA} <data>Moscow</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableCB} <data>Ufa</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableCC} <data>Envelop </data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableCD} <data>1</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbTableDA} <data>10.10.2017</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableDB} <data>12.12.2017</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableDC} <data>1</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableDD} <data>1</data>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableEA} <data>Ivanov Ivan Ivanovich</data>
                        </td>

                        <td width="200" valign="top">
                            ${lbTableEB} <data>1</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableEC} <data>1</data>
                        </td>
                    </tr>
                </table>
                <div class="clearfix">
                	<button type="button" class="cancelbtn">${lbCancel }</button>
                	<button type="submit" class="signupbtn">${lbSave }</button>
            	</div>

            </div>
        </form>
    </div>


    <hr>
</section>


<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>
</body>
</html>