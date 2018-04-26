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
<spring:message code="history.full.path" var="lbFullPath"/>
<spring:message code="history.about.delivery.data" var="lbAboutDataDelivery"/>
<spring:message code="personal.address" var="lbAddress"/>
<spring:message code="history.cargo-package" var="lbCargoPackage"/>


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
<spring:message code="adminManager.head.title" var="lbManagerTitle"/>

<html>
<head>
    <title>${lbManagerTitle}</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  	<link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400;300" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/styleTables.css"/>" rel="stylesheet"/>
    <link rel="icon" type="image/png" href="<c:url value="/resources/Login_v2/images/icons/favicon.ico"/>"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>


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

<section id="main" class="wrapper">
    <div class="container">

		<form method="post" action="${contextPath}/status" id="statusForm" name="statusForm">
	        <header class="major special">
	            <h2>${lbStatusOrder}</h2>
	            <input type="text" placeholder = "${lbPlaceRecipient}" id="nameRecip" name="nameRecip">
	            <br>
	            <button type="submit" class="signupbtn">${lbSearch}</button>
	        </header>
        </form>
        <form method="post" action="${contextPath}/statusOrder" id="statusOrderForm" name="statusOrderForm">
            <div class="container limiter">
			   <c:forEach var="order" items="${orderReq}">		
                <table width="100%" cellspacing="0" cellpadding="5" id="customers">
                     <tr ><th colspan="2" width="200" valign="top">
                            ${lbTableAA} ${order.order.name }
                        </th>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableAB} ${order.order.cost }
                        </td>
                       
                        <td width="200" valign="top">
							 <input type="checkbox" id="id_${order.order.id}" name="id_${order.order.id}" value = "${order.order.id}"/>
                            <label for="id_${order.order.id}">${lbReady}</label>
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
                            ${lbAddress }: ${order.nodeEnd.address }
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
                             ${lbAboutDataDelivery }: ${order.order.planDate }
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
                            ${lbTableEA} ${order.order.contact_information }
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
                    <tr valign="top">
                    	<td colspan="5">
                    	${lbFullPath }: ${order.order.fullPath}
                    	</td>
                    </tr>
                  </table>
                </c:forEach>
                  <div class="clearfix">
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