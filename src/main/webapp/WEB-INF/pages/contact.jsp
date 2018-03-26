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
<spring:message code="contact.section.headerA" var="lbSectionHeaderA"/>
<spring:message code="contact.section.headerB" var="lbSectionHeaderB"/>
<spring:message code="contact.section.selectA" var="lbSectionSelectA"/>
<spring:message code="contact.section.selectB" var="lbSectionSelectB"/>
<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="contact.tableA.trA.tdA" var="lbTableAAA"/>
<spring:message code="contact.tableA.trA.tdB" var="lbTableAAB"/>
<spring:message code="contact.tableA.trB.tdA" var="lbTableABA"/>
<spring:message code="contact.tableA.trB.tdB" var="lbTableABB"/>
<spring:message code="contact.tableA.trB.tdC" var="lbTableABC"/>
<spring:message code="contact.tableB.spanA" var="lbTableBspanA"/>
<spring:message code="contact.tableB.spanB" var="lbTableBspanB"/>
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


<spring:message code="contact.place.pswRepeat" var="lbPlacePswRepeat"/>
<spring:message code="contact.place.psw" var="lbPlacePsw"/>
<spring:message code="contact.place.Mname" var="lbPlaceMname"/>
<spring:message code="contact.place.Lname" var="lbPlaceLname"/>
<spring:message code="contact.place.Fname" var="lbPlaceFname"/>
<spring:message code="contact.place.city" var="lbPlaceCity"/>




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
<%@ include file = "menuCustomer.jsp" %>

<!--div id="test3" class="hideable"> GREEN COLOR DIV </div-->

<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbSectionHeaderA}</h2>
            <p>${lbSectionHeaderB }</p>
        </header>

        <select id="selColor">
            <option selected>${lbSectionSelectA}</option>
            <option>${lbSectionSelectB}</option>
            <!--option>Изменение пароля</option-->
        </select>

        <div id="test1" class="hideable">

            <form class="registration">
                <div class="container limiter">

                    <table width="100%" cellspacing="0" cellpadding="5">
                        <tr >
                            <td colspan="2" width="200" valign="top">
                                ${lbTableAAA} <data>First last middle name</data>
                            </td>
                            <td colspan="2" width="200" valign="top">
                                ${lbTableAAB} <data> yes </data>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" width="200" valign="top">
                                ${lbTableABA} <data>Moscow, Molodeznaya street, 6</data>
                            </td>
                            <td width="200" valign="top">
                                ${lbTableABB}<data>8(926)723-16-50</data>
                            </td>
                            <td width="300" valign="top">
                                ${lbTableABC} <data>paulkapay@gmail.com</data>
                            </td>
                        </tr>
                    </table>

                </div>
            </form>

        </div>

        <div id="test2" class="hideable">

            <form class="registration">
                <div class="container limiter">
            <span class="login100-form-title p-b-26">
                ${lbTableBspanA}.
            </span>
                    <span class="p-b-26">${lbTableBspanB }</span>
                    <table width="100%" cellspacing="0" cellpadding="5">
                        <td width="200" valign="top">
                            <label for="email"><b>${lbTableBAA}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" id="email" required>

                            <label for="telephone"><b>${lbTableBAB}</b></label>
                            <input type="text" placeholder="+7(926)723-16-50" name="telephone" id="telephone" required>

                            <label for="city"><b>${lbTableBAC}</b></label>
                            <input type="text" placeholder="${lbPlaceCity}" name="city" id="city" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbTableBBA}</b></label>
                            <input type="text" placeholder="${lbPlaceLname}" name="lastName" id="lastName" required>

                            <label for="firstName"><b>${lbTableBBB}</b></label>
                            <input type="text" placeholder="${lbPlaceFname}" name="firstName" id="firstName" required>

                            <label for="patronymic"><b>${lbTableBBC}</b></label>
                            <input type="text" placeholder="${lbPlaceMname}" name="patronymic" id="patronymic"  required>
                        </td>

                        <td width="200" valign="top">
                            <label for="psw"><b>${lbTableBCA}</b></label>
                            <input type="password" placeholder="${lbPlacePsw}" name="psw" id="psw" required>

                            <label for="pswRepeat"><b>${lbTableBCB}</b></label>
                            <input type="password" placeholder="${lbPlacePswRepeat}" name="pswRepeat" id="pswRepeat" required>
                        </td>

                    </table>
                    <div class="clearfix">
                        <button type="button" class="cancelbtn">${lbCancel}</button>
                        <button type="submit" class="signupbtn">${lbSave}</button>
                    </div>
                </div>
            </form>

        </div>
    </div>

</section>

<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>

<script src="<c:url value="/resources/js/contact.js"/>"></script>
</body>
</html>