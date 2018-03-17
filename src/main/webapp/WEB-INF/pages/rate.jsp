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

<spring:message code="rate.head.title" var="lbTitle"/>
<spring:message code="rate.headerA" var="lbHeaderA"/>
<spring:message code="rate.headerB" var="lbHeaderB"/>
<spring:message code="rate.table.tr" var="lbTableTR"/>
<spring:message code="rate.additional" var="lbAdditional"/>


<html>
<head>
    <title>${lbTitle }</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
        </ul>
    </nav>
</header>

<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

<!-- Main -->
<section id="main" class="wrapper">
    <div class="container">

        <header class="major special">
            <h2>${lbHeaderA} <data>name</data></h2>
            <p>${lbHeaderB} <data>10.10.2010 - 10.10.2011</data></p>
        </header>
        <form class="registration">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr ><td class="someTable" colspan="2" width="200" valign="top">
                        ${lbTableTR}
                    </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBA}</b></label>
                            <data>40</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBB}</b></label>
                            <data>40</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBC}</b></label>
                            <data>40</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBD}</b></label>
                            <data>40</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionCA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            <data>20%</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionDA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            <data>20%</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionEA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            <data>20%</data>
                        </td>
                    </tr>
                </table>

            </div>
        </form>
    </div>
    <hr>
    <!---------------------------------------------------------------------------------------------------------------->



    <div class="container">

        <header class="major special">
            <h2>${lbAdditional} <data>name</data></h2>
            <p>${lbHeaderB } <data>10.10.2010 - 10.10.2011</data></p>
        </header>
        <form class="registration">
            <div class="container limiter">

                <table width="100%" cellspacing="0" cellpadding="5">
                    <tr ><td class="someTable" colspan="2" width="200" valign="top">
                        ${lbTableTR }
                    </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBA}</b></label>
                            <data>40</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBB}</b></label>
                            <data>40</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBC}</b></label>
                            <data>40</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionBD}</b></label>
                            <data>40</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionCA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            <data>20%</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionDA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            <data>20%</data>
                        </td>
                    </tr>
                    <tr>
                        <td width="200" valign="top">
                            ${lbSectionEA}
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCB}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCC}</b></label>
                            <data>20%</data>
                        </td>
                        <td width="200" valign="top">
                            <label for="lastName"><b>${lbSectionCD}</b></label>
                            <data>20%</data>
                        </td>
                    </tr>
                </table>

            </div>
        </form>
    </div>
</section>



<!-- Scripts -->
<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

</body>
</html>