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

<spring:message code="newRate.section.p" var="lbUlSect"/>
<spring:message code="contact.cancel" var="lbCancel"/>
<spring:message code="personCost.send" var="lbSend"/>

<spring:message code="adminMain.header.h" var="lbHeader"/>
<spring:message code="adminMain.table.trA.tdA" var="lbTableAA"/>
<spring:message code="adminMain.table.trA.tdB" var="lbTableAB"/>
<spring:message code="adminMain.table.trA.tdC" var="lbTableAC"/>
<spring:message code="adminMain.table.trB.tdA" var="lbTableBA"/>
<spring:message code="adminMain.table.trB.tdB" var="lbTableBB"/>
<spring:message code="adminMain.table.trB.tdC" var="lbTableBC"/>
<spring:message code="adminMain.table.trB.tdD" var="lbTableBD"/>
<spring:message code="adminMain.table.trC.tdA" var="lbTableCA"/>
<spring:message code="adminMain.place.city" var="lbPlaceCity"/>
<spring:message code="adminMain.place.branch" var="lbPlaceBranch"/>
<spring:message code="adminMain.place.address" var="lbPlaceAddress"/>
<spring:message code="adminMain.button.add" var="lbBtnAdd"/>
<spring:message code="adminMain.button.remove" var="lbBtnRemove"/>


<spring:message code="changingAgreement.maxValues" var="lbChangAgrMaxValues"/>
<spring:message code="changingAgreement.agreement" var="lbChangAgrAgreement"/>
<spring:message code="changingAgreement.button.add" var="lbChangAgrAdd"/>
<spring:message code="changingAgreement.button.delete" var="lbChangAgrDelete"/>
<spring:message code="changingAgreement.button.change" var="lbChangAgrChange"/>
<spring:message code="changingAgreement.cargo.weight" var="lbChangAgrWeight"/>
<spring:message code="changingAgreement.cargo.length" var="lbChangAgrLength"/>
<spring:message code="changingAgreement.cargo.width" var="lbChangAgrWidth"/>
<spring:message code="changingAgreement.cargo.height" var="lbChangAgrHeight"/>
<spring:message code="changingAgreement.name" var="lbChangAgrName"/>
<spring:message code="changingAgreement.dateStart" var="lbChangAgrDateStart"/>
<spring:message code="changingAgreement.dateEnd" var="lbChangAgrDateEnd"/>

<spring:message code="changingAgreement.button.add" var="lbAddBox"/>
<spring:message code="changingAgreement.button.delete" var="lbDeleteBox"/>
<spring:message code="changingAgreement.button.change" var="lbChangeBox"/>

<html>
<head>
    <title>${lbHeadTitle}</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>
    <link rel="icon" type="image/png" href="<c:url value="/resources/Login_v2/images/icons/favicon.ico"/>"/>

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400;300" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/changingBranch.css"/>" rel="stylesheet"/>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
   

</head>
<body>

<%@ include file = "menuGeneral.jsp" %>
<%@ include file = "menuAdmin.jsp" %>

<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbChangAgrHeader}</h2>
            <p>${lbChangAgrMaxValues }</p>
        </header>
        
   
        <form class="changingTransport" method="get" action="${contextPath}/changingTransport" id="changingTransportForm" name="changingTransportForm">
        
        <table width="100%" cellspacing="0" cellpadding="5">
            <tr>
                 <td width="200" valign="top">
                     <label for="lastName"><b>${lbChangAgrWeight}</b></label>
                     ${weight }
                 </td>
                 <td width="200" valign="top">
                     <label for="lastName"><b>${lbChangAgrLength}</b></label>
                     ${length }
                 </td>
                 <td width="200" valign="top">
                     <label for="lastName"><b>${lbChangAgrWidth}</b></label>
                     ${width }
                 </td>
                 <td width="200" valign="top">
                     <label for="lastName"><b>${lbChangAgrHeight}</b></label>
                     ${height }
                 </td>
                 <td>
		                <a href="${contextPath}/changingTransport" 
		                     class="likeButton" >${lbChangeBox }</a>
		         </td>
            </tr>
        </table>
          <header class="major special">
			<br />
            <p>${lbChangAgrAgreement}</p>
        </header>
            <div class="container limiter">
	            <table width="100%" cellspacing="0" cellpadding="5">
		             <c:forEach var="rate" items="${allRates}">
		              	 <tr width="200" valign="top">
		              	 	<td colspan="2">
		                       ${lbChangAgrName }: ${rate.name} 
		                    </td>
		                    <td >
		                       ${lbChangAgrDateStart }: ${rate.startAction} 
		                    </td>
		                    <td >
		                       ${lbChangAgrDateEnd }: ${rate.endAction} 
		                    </td>
		                    <td>
		                       <a href="${contextPath}/changingAgreement/change/${rate.id}" 
		                       		class="likeButton" >${lbChangeBox }</a>
		                    </td>
		                 </tr>
		             </c:forEach>  
				</table>
                <div class="clearfix">
                     <a href="${contextPath}/newrate" class="likeButton">${lbAddBox }</a>
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

<script src="<c:url value="/resources/js/link.js"/>"></script>

</body>
</html>