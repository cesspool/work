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

<html>
<head>
    <title>${lbTitle}</title>
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
        <li><a href="personal.html">${lbUlLiA}</a></li>
        <li><a href="history.html">${lbUlLiB}</a></li>
        <li><a href="personCost.html">${lbUlLiC}</a></li>
        <li><a href="contact.html">${lbUlLiD}</a></li>
        <li><a href="index.html">${lbUlLiE}</a></li>
    </ul>
</div>

<!-- Main body -->
<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbSectionH}</h2>
            <p>${lbSectionP}</p>
        </header>
        <form class="registration">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr ><td width="200" valign="top">
                        <label for="psw-repeat"><b>${lbTableAA}</b></label>
                        <select name="field_sity_tid" class="form-select">
                        <data>
								<option value="106">Москва</option>
                                <option value="107">Уфа</option>
                                <option value="108">Долгопрудный</option>
                        </data>
                        </select>
                        </td>
                        <td width="200" valign="top">
                            <label for="psw-repeat"><b>${lbTableAB}</b></label>
                            <select name="field_sity_tid" class="form-select">
                                <data>
									<option value="106">Москва</option>
	                                <option value="107">Уфа</option>
	                                <option value="108">Долгопрудный</option>
                        		</data>
                            </select>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbTableBC }</b></label>
                            <select name="field_sity_tid" class="form-select">
                            <data>
                                <option value="109">Эконом</option>
                                <option value="110">Экспресс</option>
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
                            <label for="lastName"><b>${lbTableBA}</b></label>
                            <select id="edit-field-sity-tid" name="field_sity_tid" class="form-select">
                            <data>
								<option value="708">Конверт</option>
                                <option value="710">Посылка</option>
                            </data>
                            </select>
                        </td>

                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbTableCD}</b></label>
                            <input type="text" placeholder="ÑÑ." name="email" required>
                        </td>
                    </tr>
                </table>

                <div class="dependent hide">
                    <table>
                        <tr>
                            <td width="200" valign="top">
                                <label for="lastName"><b>${lbTableEB}</b></label>
                                <input type="text" placeholder="ÐÐ²Ð°Ð½Ð¾Ð²" name="email" required>
                            </td>
                            <td width="200" valign="top">
                                <label for="lastName"><b>${lbTableDD }</b></label>
                                <input type="text" placeholder="ÐÐ²Ð°Ð½Ð¾Ð²" name="email" required>
                            </td>
                            <td width="200" valign="top">
                                <label for="lastName"><b>${lbTableDC }</b></label>
                                <input type="text" placeholder="ÐÐ²Ð°Ð½Ð¾Ð²" name="email" required>
                            </td>
                        </tr>
                        <tr>
                            <td width="200" valign="top">
                                <label for="lastName"><b>${lbTableEC }</b></label>
                                <input type="text" placeholder="ÐÐ²Ð°Ð½Ð¾Ð²" name="email" required>
                            </td>
                            <td width="230" valign="top">
                                <label for="lastName"><b>${lbTableCA }</b></label>
                                <select name="field_sity_tid" class="form-select">
                                <data>
                                    <option value="111">Стандартная</option>
                                    <option value="112">Дополнительная</option>
                                </data>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>

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