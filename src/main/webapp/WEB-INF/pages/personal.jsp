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
<spring:message code="adminMain.place.address" var="lbPlaceAddress"/>
<spring:message code="history.full.path" var="lbFullPath"/>
<spring:message code="history.about.delivery.data" var="lbAboutDataDelivery"/>

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
<spring:message code="personal.address" var="lbAddress"/>
<spring:message code="history.cargo-package" var="lbCargoPackage"/>
<spring:message code="personal.receipt.pdf" var="lbOrderReceipt"/>





<html>
<head>
    <title>${lbUlLiB}</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  	<link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>
    <link rel="icon" type="image/png" href="<c:url value="/resources/Login_v2/images/icons/favicon.ico"/>"/>

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400;300" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/styleTables.css"/>" rel="stylesheet"/>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>


<%@ include file = "menuGeneral.jsp" %>
<%@ include file = "menuCustomer.jsp" %>

<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbUlLiA}</h2>
            <p>${lbSectionP}</p>
        </header>
       <form class="registration">
            <div class="container limiter">
			<c:forEach var="order" items="${orderReq}">		                    
                <table width="100%" cellspacing="0" cellpadding="5" id="customers">
                    <tr ><th colspan="2" width="200" valign="top">
                            ${lbTableAA} ${order.order.name }
                        </th>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableAB} ${order.order.cost }
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbTableBA} ${order.typeDelivery}
                        </td>
                        <td width="200" valign="top">
                            ${lbTableBB} ${order.box.variety}
                        </td>
                        <td colspan="2" width="200" valign="top">
                            ${lbPlaceAddress }: ${order.nodeEnd.address }
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbTableCA} ${order.nodeStart.city }
                        </td>
                        <td width="200" valign="top">
                            ${lbTableCB} ${order.nodeEnd.city }
                        </td>
                        <td width="200" valign="top">
                            ${lbTableCC} ${order.typeCargo}
                        </td>
                        <td width="200" valign="top">
                            ${lbTableCD} ${order.cargo.quantity }
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbTableDA} ${order.order.shipmentDate }
                        </td>
                        <td width="200" valign="top">
                            ${lbAboutDataDelivery } ${order.order.planDate }
                        </td>
                        <c:if test="${order.typeCargo==lbCargoPackage}">    
	                   		<td width="200" valign="top">
	                            ${lbTableDC} ${order.cargo.height }
	                        </td>
	                        <td width="200" valign="top">
	                            ${lbTableDD} ${order.cargo.width }
	                        </td>
                   		</c:if>  
                    </tr>
                    <tr>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableEA} 
                            <br/>
                            ${order.order.contact_information }
                        </td>
						<c:if test="${order.typeCargo==lbCargoPackage}">
	                        <td width="200" valign="top">
	                            ${lbTableEB} ${order.cargo.length }
	                        </td>
	                        <td width="200" valign="top">
	                            ${lbTableEC} ${order.cargo.weight }
	                        </td>
	                    </c:if>
                    </tr>
                    <tr  valign="top">
                    	<td colspan="5">
                    	${lbFullPath }: ${order.order.fullPath}
                    	</td>
                    </tr>
                </table>
                <a target="_blank" href="${contextPath}/orderform/12">${lbOrderReceipt}</a>
				</c:forEach>
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