<!DOCTYPE HTML>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:message code="personCost.head.title" var="lbTitle"/>
<spring:message code="newRate.li.div" var="lbLiDiv"/>
<spring:message code="index.section.main" var="lbSectMain"/>

<spring:message code="contact.div.ul.liA" var="lbUlLiA"/>
<spring:message code="contact.div.ul.liB" var="lbUlLiB"/>
<spring:message code="contact.div.ul.liC" var="lbUlLiC"/>
<spring:message code="contact.div.ul.liD" var="lbUlLiD"/>
<spring:message code="contact.div.ul.liE" var="lbUlLiE"/>
<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="contact.tableA.trB.tdA" var="lbTableABA"/>
<spring:message code="history.table.trB.tdC" var="lbTableBC"/>
<spring:message code="history.table.trD.tdC" var="lbTableDC"/>
<spring:message code="history.table.trD.tdD" var="lbTableDD"/>
<spring:message code="history.table.trE.tdB" var="lbTableEB"/>
<spring:message code="history.table.trE.tdC" var="lbTableEC"/>
<spring:message code="personCost.table.trC.tdA" var="lbTableCA"/>
<spring:message code="contact.cancel" var="lbCancel"/>
<spring:message code="personCost.send" var="lbSend"/>
<spring:message code="personCost.section.h" var="lbSectionH"/>
<spring:message code="personCost.section.p" var="lbSectionP"/>
<spring:message code="personCost.table.trA.tdA" var="lbTableAA"/>
<spring:message code="personCost.table.trA.tdB" var="lbTableAB"/>
<spring:message code="personCost.table.trB.tdA" var="lbTableBA"/>
<spring:message code="history.table.trC.tdD" var="lbTableCD"/>

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
            <h2>${lbSectionH}</h2>
            <p>${lbSectionP}</p>
        </header>
        <form class="registration" method="post" action="${contextPath}/costCalculation" name="costCalcForm"  id="costCalcForm">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr ><td width="200" valign="top">
                        <label for="startNode"><b>${lbTableAA}</b></label>
                        <select name="startNode" id="startNode" class="form-select">
                        <data>
								<option value="106">Moscow</option>
                                <option value="107">Ufa</option>
                                <option value="108">Dolgoprudny</option>
                        </data>
                        </select>
                        </td>
                        <td width="200" valign="top">
                            <label for="targetNode"><b>${lbTableAB}</b></label>
                            <select name="targetNode" id ="targetNode" class="form-select">
                                <data>
									<option value="106">Moscow</option>
	                                <option value="107">Ufa</option>
	                                <option value="108">Dolgoprudny</option>
                        		</data>
                            </select>
                        </td>
                        <td width="200" valign="top">
                            <label for="urgency"><b>${lbTableBC }</b></label>
                            <select name="urgency" id="urgency" class="form-select">
                            <data>
                                <option value="109">economy</option>
                                <option value="110">express</option>
                            </data>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbTableABA}
                        </td>
                        <td colspan="3" width="200" valign="top">
                            ${lbTableABA}
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            <label for="envelope"><b>${lbTableBA}</b></label>
                            <select id="envelope" name="field_sity_tid" class="form-select">
                            <data>
								<option value="708">envelop</option>
                                <option value="710">cargo</option>
                            </data>
                            </select>
                        </td>

                        <td width="200" valign="top">
                            <label for="quantity"><b>${lbTableCD}</b></label>
                            <input type="text" placeholder="1" name="quantity" id="quantity" required>
                        </td>
                    </tr>
                </table>

                <div class="dependent hide">
                    <table>
                        <tr>
                            <td width="200" valign="top">
                                <label for="length"><b>${lbTableEB}</b></label>
                                <input type="text" placeholder="1.5" name="length" id="length" required>
                            </td>
                            <td width="200" valign="top">
                                <label for="width"><b>${lbTableDD }</b></label>
                                <input type="text" placeholder="2.1" name="width" id="width" required>
                            </td>
                            <td width="200" valign="top">
                                <label for="height"><b>${lbTableDC }</b></label>
                                <input type="text" placeholder="3.2" name="height" id="height" required>
                            </td>
                        </tr>
                        <tr>
                            <td width="200" valign="top">
                                <label for="weight"><b>${lbTableEC }</b></label>
                                <input type="text" placeholder="3.1" name="weight" id="weight" required>
                            </td>
                            <td width="230" valign="top">
                                <label for="box"><b>${lbTableCA }</b></label>
                                <select name="box" id="box" class="form-select">
                                <data>
                                    <option value="111">Standart</option>
                                    <option value="112">Additional</option>
                                </data>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="clearfix">
                    <button type="button" class="cancelbtn">${lbCancel }</button>
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