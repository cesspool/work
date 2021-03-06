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
<spring:message code="adminMain.alert.city.select" var="lbAlertCity"/>


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
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>



<%@ include file = "menuGeneral.jsp" %>
<%@ include file = "menuAdmin.jsp" %>

<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbHeader}</h2>
            <p>${lbUlSect}</p>
        </header>
        
 
        <form class="registration" method="post" action="${contextPath}/admin" id="newNodeForm" name="newNodeForm">
        	<input type ="hidden" value = "${node.id}" name = "idNode" id = "idNode">
            <div class="container limiter">
                 <table width="100%" cellspacing="0" cellpadding="5">
                    <tr>
                        <label for="name"><b>${lbTableAA}</b></label>
                        <td width="200" valign="top">
                            <input type="text" value = "${node.name}" placeholder="${lbPlaceBranch}" name="name" id="name" required>
                        </td>

                        <td>
                            <input type="checkbox" id="airport" name="airport" value="2" ${node.airport }>
                            <label for="airport">${lbTableAB}</label>
                        </td>
                        <td>
                            <input type="checkbox" id="railway" name="railway" value="3" ${node.rail}>
                            <label for="railway">${lbTableAC}</label>
                        </td>
                    </tr>

                    <tr>
                        <td width="200" valign="top">
                            <label for="coordinateX"><b>${lbTableBA}</b></label>
                            <input value = "${node.coordinateX}" type="text" placeholder="1424.1525" name="coordinateX" id="coordinateX" required>
                        </td>
                        <td>
                            <label for="coordinateY"><b>${lbTableBB}</b></label>
                            <input value = "${node.coordinateY}" type="text" placeholder="12515.152" name="coordinateY" id="coordinateY" required>
                        </td>
                        <td>
                            <label for="address"><b>${lbTableBC}</b></label>
                            <input value = "${node.address}" type="text" placeholder="${lbPlaceAddress}" name="address" id="address" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="city"><b>${lbTableBD}</b></label>
                            <input value = "${node.city}" type="text" placeholder="${lbPlaceCity}" name="city" id="city" required>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" colspan="4">
                          <div class="cityBox">
                            <div class="leftBox">
                                <div class="leftSel">
                                    <select size="5" name="allCities" id="allCities">
                                      <c:forEach var="city" items="${allCities}">
                                        <option value="${city.key}">${city.value}</option>
                                      </c:forEach>  
                                    </select>
                                </div>
                            </div>
                            <div class="cBox">
                              <div  class="btnBox">
                                  <button type="button" id="btnAdd">${lbBtnAdd}</button>
                                  <button type="button" id="btnRemove">${lbBtnRemove}</button>
                              </div>
                            </div>
                            <div class="rightBox">
                                <div class="rightSel">
                                  <select size="5" name="chosenCities" id="chosenCities">
                                      <c:forEach var="linkedCity" items="${linkedNodes}">
                                        <option value="${linkedCity.key}">${linkedCity.value}</option>
                                      </c:forEach> 
                                  </select>
                                  <input type="hidden" id="selectedCities" name="selectedCities"/>
                                </div>
                            </div>
                          </div>  
                        </td>
                    </tr>

                </table>

                <div class="clearfix">
                    <button onclick="location.href = '${contextPath}/changingBranch';" type="button" class="cancelbtn"> ${lbCancel }</button>
                    <button type="submit" class="signupbtn">${lbSend}</button>
                </div>
            </div>
        </form>

</section>


<!-- Main -->
<script type="text/javascript">
var msgs='${lbAlertCity }'
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>


<!-- Scripts -->
<script src="<c:url value="/resources/js/adminMain.js"/>"></script>
<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>

<script src="<c:url value="/resources/js/link.js"/>"></script>

</body>
</html>