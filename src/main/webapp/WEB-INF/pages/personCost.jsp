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

<spring:message code="personCost.option.cargo" var="lbOptCargo"/>
<spring:message code="personCost.option.envelop" var="lbOptEnvelop"/>
<spring:message code="personCost.option.economy" var="lbOptEconomy"/>
<spring:message code="personCost.option.express" var="lbOptExpress"/>

<html>
<head>
    <title>${lbTitle}</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  	<link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400;300" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/personCost.css"/>" rel="stylesheet"/>
    
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
            <p> 
            	<c:if test="${not empty message}">
           	      <div>
                     <div> <!-- ERROR MESSAGE BOX -->
                      <h2>Error</h2>
                      <p>${message.msg}</p>
				  	</div>
				  </div>
            	</c:if>
            </p>
        </header>
        <form class="registration" method="post" action="${contextPath}/costCalculation" name="costCalcForm"  id="costCalcForm">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr ><td width="200" valign="top">
                        <label for="startNode"><b>${lbTableAA}</b></label>
                        
                        <div class="dropdown">
                        <input list="cityList" id="cityStart" name="cityStart"> 
						<datalist id="cityList">
							<c:forEach var="city" items="${allCities}">
		                         <option value="${city.value}"/>
		                    </c:forEach>
						</datalist>
						</div>
                        
                        </td>
                        <td width="200" valign="top">
                            <label for="targetNode"><b>${lbTableAB}</b></label>
                            <div class="dropdown">
                        		<input list="cityList" id="cityTarget" name="cityTarget">
								<datalist id="cityList">
									<c:forEach var="city" items="${allCities}">
		                         		<option value="${city.value}"/>
		                    		</c:forEach>
								</datalist>
							</div>
                        </td>
                        <td width="200" valign="top">
                            <label for="urgency"><b>${lbTableBC }</b></label>
                            <select name="urgency" id="urgency" class="form-select">
                            <data>
                                <option name = "economy" id = "economy" value = "${economyVal}">${lbOptEconomy}</option>
                                <option name = "express" id = "express" value = "${expressVal}">${lbOptExpress }</option>
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
                            <select id="envelope" name="envelope" class="form-select">
								<option name = "envelop" id = "envelop" value = "${envelopVal }">${lbOptEnvelop }</option>
                                <option name = "cargo" id = "cargo" value = "${cargoVal }">${lbOptCargo }</option>
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
                                <input type="text" placeholder="1.5" name="length" id="length">
                            </td>
                            <td width="200" valign="top">
                                <label for="width"><b>${lbTableDD }</b></label>
                                <input type="text" placeholder="2.1" name="width" id="width">
                            </td>
                            <td width="200" valign="top">
                                <label for="height"><b>${lbTableDC }</b></label>
                                <input type="text" placeholder="3.2" name="height" id="height">
                            </td>
                        </tr>
                        <tr>
                            <td width="200" valign="top">
                                <label for="weight"><b>${lbTableEC }</b></label>
                                <input type="text" placeholder="3.1" name="weight" id="weight">
                            </td>
                            <td width="230" valign="top">
                                <label for="box"><b>${lbTableCA }</b></label>
                                <select id="boxesList" name="boxesList" class="form-select">
                                    <c:forEach var="box" items="${allBoxes}">
		                         		<option value="${box.key}">${box.value}</option>
		                    		</c:forEach>
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

<!-- script src="<c:url value="/resources/js/personCost.js"/>"></script-->
<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>

</body>
</html>