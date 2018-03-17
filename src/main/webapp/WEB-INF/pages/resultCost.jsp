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
<spring:message code="personal.section.p" var="lbSectionP"/>
<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="contact.cancel" var="lbCancel"/>
<spring:message code="resultCost.issue" var="lbIssue"/>

<spring:message code="resultCost.header.H" var="lbHeaderH"/>
<spring:message code="resultCost.header.P" var="lbHEaderP"/>
<spring:message code="resultCost.table.trA.tdA" var="lbTableAA"/>
<spring:message code="resultCost.table.trA.tdB" var="lbTableAB"/>
<spring:message code="resultCost.table.trB.tdA" var="lbTableBA"/>
<spring:message code="resultCost.table.trB.tdB" var="lbTableBB"/>
<spring:message code="resultCost.table.trC.tdA" var="lbTableCA"/>



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
<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

<div class="menu">

    <!-- ÐÐºÐ¾Ð½ÐºÐ° Ð¼ÐµÐ½Ñ -->
     <div class="icon-close">
        <img src="<c:url value="/resources/images/close-btn.png"/>"/>
    </div>

    <!-- ÐÐµÐ½Ñ -->
    <ul>
        <li><a href="personal.html">${lbUlLiA}</a></li>
        <li><a href="history.html">${lbUlLiB}</a></li>
        <li><a href="personCost.html">${lbUlLiC}</a></li>
        <li><a href="contact.html">${lbUlLiD}</a></li>
        <li><a href="index.html">${lbUlLiE}</a></li>
    </ul>
</div>


<!-- Main body -->
<!-- Main -->
<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbHeaderH }</h2>
            <p>${lbHEaderP}</p>
        </header>
        <form class="registration">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr ><td colspan="4" width="200" valign="top">
                       ${lbTableAA} авто/жд/грузо/смешанная
                    </td>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableAB} 1561 руб.
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableBA} 21.01.2017
                        </td>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableBB} 30.01.2017
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" width="200" valign="top">
                            ${lbTableCA} Москва-поезд-Уфа-самолет-Самара
                        </td>
                    </tr>
                </table>

                <div class="clearfix">
                    <button type="button" class="cancelbtn">${lbCancel }</button>
                    <button type="submit" class="signupbtn"><a href="personOrder.html">${lbIssue}</a></button>
                </div>

            </div>
        </form>
    </div>
</section>

<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>
</body>
</html>