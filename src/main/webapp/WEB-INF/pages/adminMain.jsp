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

<spring:message code="newRate.section.p" var="lbUlB"/>
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

    <!-- Иконка меню -->
    <div class="icon-close">
        <img src="<c:url value="/resources/images/close-btn.png"/>"/>
    </div>

    <!-- Меню -->
    <ul>
        <li><a href="statusOrder.html">${lbUlA}</a></li>
        <li><a href="adminMain.html">${lbHeader}</a></li>
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
            <h2>${lbHeader}</h2>
            <p>${lbUlB}</p>
        </header>
        <form class="registration">
            <div class="container limiter">
                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr>
                        <label for="name"><b>${lbTableAA}</b></label>
                        <td width="200" valign="top">
                            <input type="text" placeholder="${lbPlaceBranch}" name="name" id="name" required>
                        </td>

                        <td>
                            <input type="checkbox" id="airport" name="airport" value="air">
                            <label for="airport">${lbTableAB}</label>
                        </td>
                        <td>
                            <input type="checkbox" id="railway" name="railway" value="rail">
                            <label for="railway">${lbTableAC}</label>
                        </td>
                    </tr>

                    <tr>
                        <td width="200" valign="top">
                            <label for="coordinateX"><b>${lbTableBA}</b></label>
                            <input type="text" placeholder="1424.1525" name="coordinateX" id="coordinateX" required>
                        </td>
                        <td>
                            <label for="coordinateY"><b>${lbTableBB}</b></label>
                            <input type="text" placeholder="12515.152" name="coordinateY" id="coordinateY" required>
                        </td>
                        <td>
                            <label for="address"><b>${lbTableBC}</b></label>
                            <input type="text" placeholder="${lbPlaceAddress}" name="address" id="address" required>
                        </td>
                        <td width="200" valign="top">
                            <label for="city"><b>${lbTableBD}</b></label>
                            <input type="text" placeholder="${lbPlaceCity}" name="city" id="city" required>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            <div class="input_fields_wrap">
                                <button class="add_field_button">${lbTableCA}</button>
                                <div> <select name="field_sity_tid" class="form-select">
                                	<data>
                                    	<option value="103">Moscow</option>
                                    	<option value="104">Ufa</option>
                                    	<option value="105">Dolgoprudny</option>
                                    </data>
                                </select></div>
                            </div>
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

<script src="<c:url value="/resources/js/link.js"/>"></script>

</body>
</html>