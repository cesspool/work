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
            <h2>Редактирование упаковок</h2>
            <p>Выберите необходимое действие</p>
        </header>

        <select id="selColor">
            <option selected>Добавление упаковки</option>
            <option>Удаление упаковки</option>
            <option>Green</option>
        </select>

        <div id="test1" class="hideable">

            <header class="major special">
            </header>
            <form class="registration">
                <div class="container limiter">

                    <table width="100%" cellspacing="0" cellpadding="5">
                        <tr ><td width="200" valign="top">
                            <label for="lastName"><b>Название упаковки</b></label>
                            <input type="text" placeholder="шт." name="email" required>
                        </td>
                            <td width="200" valign="top">
                                <label for="lastName"><b>Стоимость упаковки</b></label>
                                <input type="text" placeholder="шт." name="email" required>
                            </td>
                        </tr>
                    </table>


                    <div class="clearfix">
                        <button type="button" class="cancelbtn">Отмена</button>
                        <button type="submit" class="signupbtn"><a href="resultCost.html">Добавить</a></button>
                    </div>

                </div>
            </form>

        </div>


        <div id="test2" class="hideable">

            <table width="100%" cellspacing="0" cellpadding="5">
                <tr ><td width="200" valign="top">
                    <label for="lastName"><b>Упаковка</b></label>
                    <select name="field_sity_tid" class="form-select">
                        <option value="111">Стандартная</option>
                        <option value="112">Дополнительная</option>
                    </select>
                </td>
                    <td width="200" valign="top">
                        <label for="lastName"><b>Стоимость упаковки</b></label>
                        500 руб.
                    </td>
                </tr>
            </table>
            <div class="clearfix">
                <button type="button" class="cancelbtn">${lbCancel }</button>
                <button type="submit" class="signupbtn"><a href="resultCost.html">${lbSend}</a></button>
             </div>

        </div>
        <div id="test3" class="hideable"> GREEN COLOR DIV </div>

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