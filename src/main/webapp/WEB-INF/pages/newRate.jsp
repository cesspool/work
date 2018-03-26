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
<spring:message code="newRate.section.trA.tdA" var="lbSectionAA"/>
<spring:message code="newRate.section.trA.tdB" var="lbSectionAB"/>
<spring:message code="newRate.section.trA.tdC" var="lbSectionAC"/>

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
<%@ include file = "menuAdmin.jsp" %>

<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbUlA}</h2>
            <p>${lbUlSect}</p>
        </header>
        <form class="registration">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr >
                        <td width="200" valign="top">
                            <label for="startAction"><b>${lbSectionAA}</b></label>
                            <input type="date" name="startAction" id="startAction" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="endAction"><b>${lbSectionAB}</b></label>
                            <input type="date" name="endAction" id="endAction" required>
                        </td>
                        <td colspan="2" width="200" valign="top">
                            <label for="name"><b>${lbSectionAC}</b></label>
                            <input type="text" placeholder="Экономный" name="name" id="name" required>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            <label for="totalWeight"><b>${lbSectionBA}</b></label>
                            <input type="text" placeholder="10" name="totalWeight" id="totalWeight" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="maxLength"><b>${lbSectionBB}</b></label>
                            <input type="text" placeholder="0.6" name="maxLength" id="maxLength" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="maxWidth"><b>${lbSectionBC}</b></label>
                            <input type="text" placeholder="0.3" name="maxWidth" id="maxWidth" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="maxHeight"><b>${lbSectionBD}</b></label>
                            <input type="text" placeholder="0.2" name="maxHeight" id="maxHeight" required>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionCA}
                        </td>
                        <td width="200" valign="top">
                            <label for="costShippingCargo"><b>${lbSectionCB}</b></label>
                            <input type="text" placeholder="15" name="costShippingCargo" id="costShippingCargo" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="costShippingAir"><b>${lbSectionCC}</b></label>
                            <input type="text" placeholder="16" name="costShippingAir" id="costShippingAir" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="costShippingRail"><b>${lbSectionCD}</b></label>
                            <input type="text" placeholder="10" name="costShippingRail" id="costShippingRail" required>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionDA}
                        </td>
                        <td width="200" valign="top">
                            <label for="addCostShippingCargo"><b>${lbSectionCB}</b></label>
                            <input type="text" placeholder="10" name="addCostShippingCargo" id="addCostShippingCargo" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="addCostShippingAir"><b>${lbSectionCC}</b></label>
                            <input type="text" placeholder="10" name="addCostShippingAir" id="addCostShippingAir" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="addCostShippingCargo"><b>${lbSectionCD}</b></label>
                            <input type="text" placeholder="10" name="addCostShippingCargo" id="addCostShippingCargo" required>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionEA}
                        </td>
                        <td width="200" valign="top">
                            <label for="costKmCargo"><b>${lbSectionCB}</b></label>
                            <input type="text" placeholder="15" name="costKmCargo" id="costKmCargo" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="costKmAir"><b>${lbSectionCC}</b></label>
                            <input type="text" placeholder="15" name="costKmAir" id="costKmAir" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="costKmRail"><b>${lbSectionCD}</b></label>
                            <input type="text" placeholder="15" name="costKmRail" id="costKmRail" required>
                        </td>
                    </tr>
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