<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:message code="registration.span" var="lbMain"/>
<spring:message code="newRate.section.p" var="lbSection"/>

<spring:message code="contact.tableB.trA.tdA" var="lbTableBAA"/>
<spring:message code="contact.tableB.trA.tdB" var="lbTableBAB"/>
<spring:message code="contact.tableB.trB.tdA" var="lbTableBBA"/>
<spring:message code="contact.tableB.trB.tdB" var="lbTableBBB"/>
<spring:message code="contact.tableB.trB.tdC" var="lbTableBBC"/>
<spring:message code="contact.tableB.trC.tdA" var="lbTableBCA"/>
<spring:message code="contact.tableB.trA.tdC" var="lbTableBAC"/>
<spring:message code="contact.tableB.trC.tdB" var="lbTableBCB"/>

<spring:message code="contact.save" var="lbSave"/>
<spring:message code="contact.cancel" var="lbCancel"/>

<spring:message code="adminMain.place.city" var="lbPlaceCity"/>
<spring:message code="contact.place.pswRepeat" var="lbPlacePswRepeat"/>
<spring:message code="contact.place.psw" var="lbPlacePsw"/>
<spring:message code="contact.place.Mname" var="lbPlaceMname"/>
<spring:message code="contact.place.Lname" var="lbPlaceLname"/>
<spring:message code="contact.place.Fname" var="lbPlaceFname"/>
<spring:message code="input.warning.massages" var="lbInputMsg"/>

<spring:message code="registration.type.privilege" var="lbPrivilege"/>
<spring:message code="registration.type.privilege.ordinary" var="lbPrivilegeOrdinary"/>
<spring:message code="registration.type.privilege.manager" var="lbPrivilegeManager"/>
<spring:message code="registration.type.privilege.admin" var="lbPrivilegeAdmin"/>

<spring:message code="registration.psw.match" var="lbMatch"/>
<spring:message code="registration.psw.notmatch" var="lbNotMatch"/>

<html>
<head>
    <title>${lbMain}</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- link rel="stylesheet" href="<c:url value="/resources/CSS/registration.css"/>"/-->
	<link rel="icon" type="image/png" href="<c:url value="/resources/Login_v2/images/icons/favicon.ico"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <script>
    var check = function() {
    	  if (document.getElementById('psw').value ==
    	    document.getElementById('pswRepeat').value) {
    	    document.getElementById('message').style.color = 'green';
    	    document.getElementById('message').innerHTML = '${lbMatch}';
    	  } else {
    	    document.getElementById('message').style.color = 'red';
    	    document.getElementById('message').innerHTML = '${lbNotMatch}';
    	  }
    	}
    </script>
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

<form class="registration" method="post" action="${contextPath}/registration">
    <div class="container limiter">
           <header class="major special">
	            <h2>${lbMain}</h2>
	            <p>${lbSection}</p>
        </header>
    <table width="100%" cellspacing="0" cellpadding="5">
            <td width="200" valign="top">
                <label for="email"><b>${lbTableBAA}</b></label>
                <input type="text" placeholder="paulkapay@gmail.com" value="${customer.email}" name="email" id="email" required />

                <label for="telephone"><b>${lbTableBAB}</b></label>
                <input type="text" placeholder="+7(926)723-16-50" value="${customer.telephone}" name="telephone" id="telephone" required />

                <label for="city"><b>${lbTableBAC}</b></label>
                <input type="text" placeholder="${lbPlaceCity}" value="${customer.city}" name="city" id="city" required />
            </td>
            <td width="200" valign="top">
                <label for="firstName"><b>${lbTableBBA}</b></label>
                <input type="text" placeholder="${lbPlaceFname }" value="${customer.firstName}" name="firstName" id="firstName" required />

                <label for="lastName"><b>${lbTableBBB }</b></label>
                <input type="text" placeholder="${lbPlaceLname }" value="${customer.lastName}" name="lastName" id="lastName" required
                oninvalid="this.setCustomValidity('')" />

                <label for="patronymic"><b>${lbTableBBC}</b></label>
                <input type="text" placeholder="${lbPlaceMname}" value="${customer.patronymic}" name="patronymic" id="patronymic" required
                oninvalid="this.setCustomValidity('')" />
            </td>
            
            <td width="200" valign="top">
                <label for="psw"><b>${lbTableBCA}</b></label>
                <input type="password" placeholder="${lbPlacePsw}" name="psw" id="psw" required
                oninvalid="this.setCustomValidity('')" onkeyup='check();' />

                <label for="pswRepeat"><b>${lbTableBCB}</b></label>
                <input type="password" placeholder="${lbPlacePswRepeat}" name="pswRepeat" id="pswRepeat" required
                oninvalid="this.setCustomValidity('')" onkeyup='check();' />
                 <span id='message'></span>

                <c:if test="${not empty sessionScope.principal and sessionScope.principal.admin}">                
					<label for="privilege"><b>${lbPrivilege }</b></label>
	                <select id="privilege" name="privilege" class="form-select">
						<option name = "ordinary" id = "ordinary" value = "0">${lbPrivilegeOrdinary}</option>
	                    <option name = "manager" id = "manager" value = "1">${lbPrivilegeManager }</option>
	                    <option name = "admin" id = "admin" value = "2">${lbPrivilegeAdmin }</option>
	                </select>
                </c:if>
             </td>
            

    </table>
            <div class="clearfix">
                <button onclick="location.href = '${contextPath}/loginform';" type="button" class="cancelbtn">${lbCancel }</button>
                <button type="submit" class="signupbtn">${lbSave }</button>
            </div>
    </div>
</form>

</body>
</html>
