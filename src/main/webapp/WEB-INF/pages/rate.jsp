<!DOCTYPE HTML>


<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="contact.div.ul.liB" var="lbUlLiB"/>
<spring:message code="index.section.main" var="lbSectMain"/>
<spring:message code="newRate.li.div" var="lbLiDiv"/>
<spring:message code="contact.head.title" var="lbHeadTitle"/>
<spring:message code="contact.div.ul.liA" var="lbUlLiA"/>
<spring:message code="contact.div.ul.liC" var="lbUlLiC"/>
<spring:message code="contact.div.ul.liD" var="lbUlLiD"/>
<spring:message code="contact.div.ul.liE" var="lbUlLiE"/>


<spring:message code="newRate.section.trB.tdA" var="lbSectionBA"/>
<spring:message code="newRate.section.trB.tdB" var="lbSectionBB"/>
<spring:message code="newRate.section.trB.tdC" var="lbSectionBC"/>
<spring:message code="newRate.section.trB.tdD" var="lbSectionBD"/>
<spring:message code="newRate.section.trC.tdA" var="lbSectionCA"/>
<spring:message code="newRate.section.trC.tdB" var="lbSectionCB"/>
<spring:message code="newRate.section.trC.tdC" var="lbSectionCC"/>
<spring:message code="newRate.section.trC.tdD" var="lbSectionCD"/>
<spring:message code="newRate.section.trD.tdA" var="lbSectionDA"/>
<spring:message code="newRate.section.trE.tdA" var="lbSectionEA"/>

<spring:message code="rate.head.title" var="lbTitle"/>
<spring:message code="rate.headerA" var="lbHeaderA"/>
<spring:message code="rate.headerB" var="lbHeaderB"/>
<spring:message code="rate.table.tr" var="lbTableTR"/>
<spring:message code="rate.additional" var="lbAdditional"/>





<html>
<head>
    <title>${lbTitle }</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>

<%@ include file = "menuGeneral.jsp" %>

	<c:if test="${not empty sessionScope.principal and sessionScope.principal.admin}"> 
		<%@ include file = "menuAdmin.jsp" %>
	</c:if>
	<c:if test="${not empty sessionScope.principal and sessionScope.principal.manager}"> 
		<%@ include file = "menuManager.jsp" %>
	</c:if>
	<c:if test="${not empty sessionScope.principal}"> 
		<%@ include file = "menuCustomer.jsp" %>
	</c:if>

<!-- Main -->
<section id="main" class="wrapper">
    <div class="container">
        <form class="registration" method="get" action="${contextPath}/rateform">
          <header class="major special">
            <h2>${lbHeaderA} ${name}</h2>
            <p>${lbHeaderB} ${dateStart } - ${dateEnd}</p>
        </header>
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr ><td class="someTable" colspan="2" width="200" valign="top">
                        ${lbTableTR}
                    </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBA}</b></label>
                            ${weight }
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBB}</b></label>
                            ${length }
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBC}</b></label>
                            ${width }
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBD}</b></label>
                            ${height }
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionCA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            ${costShippingCargo }
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            ${costShippingAir }
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            ${costShippingRail }
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionDA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            ${addCostShippingCargo }
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            ${addCostShippingAir }
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            ${addCostShippingRail }
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionEA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            ${costKmCargo }
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            ${costKmAir}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            ${costKmRail }
                        </td>
                    </tr>
                </table>

            </div>
        </form>
    </div>
    <hr>
    </section>
    

    <!---------------------------------------------------------------------------------------------------------------->



<!-- Scripts -->
<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>

</body>
</html>