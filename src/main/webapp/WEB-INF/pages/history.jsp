<!DOCTYPE HTML>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="contact.div.ul.liB" var="lbUlLiB"/>
<spring:message code="index.section.main" var="lbSectMain"/>
<spring:message code="newRate.li.div" var="lbLiDiv"/>
<spring:message code="contact.head.title" var="lbHeadTitle"/>
<spring:message code="contact.div.ul.liA" var="lbUlLiA"/>
<spring:message code="contact.div.ul.liC" var="lbUlLiC"/>
<spring:message code="contact.div.ul.liD" var="lbUlLiD"/>
<spring:message code="contact.div.ul.liE" var="lbUlLiE"/>


<spring:message code="history.section.h" var="lbSectionHeaderA"/>
<spring:message code="history.section.p" var="lbSectionHeaderB"/>
<spring:message code="history.table.trA.tdA" var="lbTableAA"/>
<spring:message code="history.table.trA.tdB" var="lbTableAB"/>
<spring:message code="history.table.trB.tdA" var="lbTableBA"/>
<spring:message code="history.table.trB.tdB" var="lbTableBB"/>
<spring:message code="history.table.trB.tdC" var="lbTableBC"/>
<spring:message code="history.table.trB.tdD" var="lbTableBD"/>
<spring:message code="history.table.trC.tdA" var="lbTableCA"/>
<spring:message code="history.table.trC.tdB" var="lbTableCB"/>
<spring:message code="history.table.trC.tdC" var="lbTableCC"/>
<spring:message code="history.table.trC.tdD" var="lbTableCD"/>
<spring:message code="history.table.trD.tdA" var="lbTableDA"/>
<spring:message code="history.table.trD.tdB" var="lbTableDB"/>
<spring:message code="history.table.trD.tdC" var="lbTableDC"/>
<spring:message code="history.table.trD.tdD" var="lbTableDD"/>
<spring:message code="history.table.trE.tdA" var="lbTableEA"/>
<spring:message code="history.table.trE.tdB" var="lbTableEB"/>
<spring:message code="history.table.trE.tdC" var="lbTableEC"/>



<html>
<head>
    <title>${lbUlLiB}</title>
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

    <!-- Иконка меню -->
    <div class="icon-close">
        <img src="<c:url value="/resources/images/close-btn.png"/>"/>
    </div>

    <!-- Меню -->
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
            <h2>${lbSectionHeaderA}</h2>
            <p>${lbSectionHeaderA}</p>
        </header>
        <form class="registration">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr ><td class="someTable" colspan="2" width="200" valign="top">
                            ${lbTableAA} <data>14251</data>
                        </td>
                        <td class="someTable" colspan="2" width="200" valign="top">
                            ${lbTableAB} <data>1561 руб</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbTableBA} <data>экспресс</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableBB} <data>стандартная</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableBC} <data>название</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableBD} <data>1.5</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbTableCA} <data>Москва</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableCB} <data>Уфа</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableCC} <data>Конверт </data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableCD} <data>1</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbTableDA} <data>10.10.2017</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableDB} <data>12.12.2017</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableDC} <data>1</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableDD} <data>1</data>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" width="200" valign="top">
                            ${lbTableEA} <data>Иван Иванов Иванович</data>
                        </td>

                        <td width="200" valign="top">
                            ${lbTableEB} <data>1</data>
                        </td>
                        <td width="200" valign="top">
                            ${lbTableEC} <data>1</data>
                        </td>
                    </tr>
                </table>

            </div>
        </form>
    </div>


    <hr>


</section>

<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>
</body>
</html>