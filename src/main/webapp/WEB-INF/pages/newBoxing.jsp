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
<spring:message code="history.table.trB.tdB" var="lbTableBB"/>
<spring:message code="newRate.section.p" var="lbUlSect"/>

<spring:message code="newBoxing.section.h" var="lbSectionH"/>
<spring:message code="newBoxing.section.p" var="lbSectionP"/>
<spring:message code="newBoxing.selectA" var="lbSelectA"/>
<spring:message code="newBoxing.selectB" var="lbSelectB"/>
<spring:message code="newBoxing.table.tdA" var="lbTableA"/>
<spring:message code="newBoxing.table.tdB" var="lbTableB"/>
<spring:message code="newBoxing.place.name" var="lbPlaceName"/>
<spring:message code="changingBox.nameTitle" var="lbNameTitle"/>




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
            <h2>${lbNameTitle}</h2>
              <p>${lbUlSect}</p>
        </header>

            <header class="major special">
            </header>
            <form class="registration" method="post" action="${contextPath}/boxing">
                <div class="container limiter">

                    <table width="100%" cellspacing="0" cellpadding="5">
                        <tr ><td width="200" valign="top">
                            <label for="name"><b>${lbTableA }</b></label>
                            <input type="text" placeholder="${lbPlaceName}" name="name" id="name" required>
                        </td>
                            <td width="200" valign="top">
                                <label for="cost"><b>${lbTableB}</b></label>
                                <input type="text" placeholder="5000" name="cost" id="cost" required>
                            </td>
                        </tr>
                    </table>
                      <div class="clearfix">
              			  <button onclick="location.href = '${contextPath}/changingBox';" type="button" class="cancelbtn">${lbCancel }</button>
               			  <button type="submit" class="signupbtn">${lbSend}</button>
             		  </div>

                </div>
            </form>

      
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