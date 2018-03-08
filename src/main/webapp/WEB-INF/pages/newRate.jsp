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

<spring:message code="newRate.section.header" var="lbUlA"/>
<spring:message code="newRate.section.p" var="lbUlB"/>
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
</head>
<body>


<!-- Header -->
<header id="header">
    <h1><strong>${lbSectMain}</strong></h1>
    <nav id="nav">
        <ul>
            <li><a href="index.html">${lbNavMain}</a></li>
			<li><a href="rate.html">${lbNavRates}</a></li>
			<li><a href="login.html">${lbNavAuth}</a></li>
            <li>
                <div>
                    <div style="color: brown" class="icon-menu">
                        <img class="contact" src="<c:url value="/resources/images/contact.png"/>"/>${lbLiDiv}
                    </div>
                </div>
            </li>
        </ul>
    </nav>
</header>

<div class="menu">

    <!-- ÐÐºÐ¾Ð½ÐºÐ° Ð¼ÐµÐ½Ñ -->
    <div class="icon-close">
        <img src="<c:url value="/resources/images/close-btn.png"/>"/>
    </div>

    <!-- ÐÐµÐ½Ñ -->
    <ul>
        <li><a href="statusOrder.html">${lbUlA}</a></li>
        <li><a href="adminMain.html">${lbUlB}</a></li>
        <li><a href="newRate.html">${lbUlC}</a></li>
        <li><a href="newBoxing.html">${lbUlD}</a></li>
        <li><a href="index.html">${lbUlE}</a></li>
    </ul>
</div>

<!-- Main body -->
<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbUlA}</h2>
            <p>${lbUlB}</p>
        </header>
        <form class="registration">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr >
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionAA}</b></label>
                            <input type="date" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionAB}</b></label>
                            <input type="date" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td colspan="2" width="200" valign="top">
                            <label for="lastName"><b>${lbSectionAC}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBA}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBB}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBC}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBD}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionCA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionDA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionEA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            <input type="text" placeholder="paulkapay@gmail.com" name="email" required>
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