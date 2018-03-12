<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:message code="registration.span" var="lbMain"/>
<spring:message code="newRate.section.p" var="lbSection"/>

<spring:message code="contact.tableB.trA.tdA" var="lbTableBAA"/>
<spring:message code="contact.tableB.trA.tdB" var="lbTableBAB"/>
<spring:message code="contact.tableB.trA.tdC" var="lbTableBAC"/>
<spring:message code="contact.tableB.trB.tdA" var="lbTableBBA"/>
<spring:message code="contact.tableB.trB.tdB" var="lbTableBBB"/>
<spring:message code="contact.tableB.trB.tdC" var="lbTableBBC"/>
<spring:message code="contact.tableB.trC.tdA" var="lbTableBCA"/>
<spring:message code="contact.tableB.trC.tdB" var="lbTableBCB"/>

<spring:message code="contact.save" var="lbSave"/>
<spring:message code="contact.cancel" var="lbCancel"/>

<html>
<head>
    <title>${lbMain}</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- link rel="stylesheet" href="<c:url value="/resources/CSS/registration.css"/>"/-->

    <link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>

<body>

<form class="registration">
    <div class="container limiter">
           <header class="major special">
	            <h2>${lbMain}</h2>
	            <p>${lbSection}</p>
        </header>
    <table width="100%" cellspacing="0" cellpadding="5">
            <td width="200" valign="top">
                <label for="email"><b>${lbTableBAA }</b></label>
                <input type="text" placeholder="paulkapay@gmail.com" name="email" required>

                <label for="phone"><b>${lbTableBAB }</b></label>
                <input type="text" placeholder="+7(926)723-16-50" name="email" required>

                <label for="city"><b>${lbTableBAC}</b></label>
                <input type="text" placeholder="ÐÐ¾ÑÐºÐ²Ð°" name="email" required>
            </td>
            <td width="200" valign="top">
                <label for="lastName"><b>${lbTableBBA}</b></label>
                <input type="text" placeholder="ÐÐ²Ð°Ð½Ð¾Ð²" name="email" required>

                <label for="firstName"><b>${lbTableBBB }</b></label>
                <input type="text" placeholder="ÐÐ²Ð°Ð½" name="email" required>

                <label for="patronymic"><b>${lbTableBBC}</b></label>
                <input type="text" placeholder="ÐÐ²Ð°Ð½Ð¾Ð²Ð¸Ñ" name="email" required>
            </td>
            
            <td width="200" valign="top">
                <label for="psw"><b>${lbTableBCA}</b></label>
                <input type="password" placeholder="ÐÐ²ÐµÐ´Ð¸ÑÐµ Ð¿Ð°ÑÐ¾Ð»Ñ" name="psw" required>

                <label for="psw-repeat"><b>${lbTableBCB}</b></label>
                <input type="password" placeholder="ÐÐ²ÐµÐ´Ð¸ÑÐµ Ð¿Ð°ÑÐ¾Ð»Ñ ÐµÑÐµ ÑÐ°Ð·" name="psw-repeat" required>
            </td>

    </table>
            <div class="clearfix">
                <button type="button" class="cancelbtn">${lbCancel }</button>
                <button type="submit" class="signupbtn">${lbSave }</button>
            </div>
    </div>
</form>

</body>
</html>
