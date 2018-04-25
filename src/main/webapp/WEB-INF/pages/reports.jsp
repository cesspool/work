<!DOCTYPE HTML>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:message code="newRate.li.div" var="lbLiDiv"/>
<spring:message code="index.section.main" var="lbSectMain"/>
<spring:message code="contact.head.title" var="lbHeadTitle"/>
<spring:message code="newRate.ulA" var="lbUlA"/>
<spring:message code="newRate.ulB" var="lbUlB"/>
<spring:message code="newRate.ulC" var="lbUlC"/>
<spring:message code="newRate.ulD" var="lbUlD"/>
<spring:message code="newRate.ulE" var="lbUlE"/>
<spring:message code="personal.section.p" var="lbSectionP"/>
<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>
<spring:message code="contact.div.ul.liA" var="lbUlLiA"/>
<spring:message code="contact.save" var="lbSave"/>
<spring:message code="contact.cancel" var="lbCancel"/>
<spring:message code="statusOrder.searching" var="lbSearch"/>
<spring:message code="statusOrder.place.recipient" var="lbPlaceRecipient"/>

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
<spring:message code="statusOrder.ready" var="lbReady"/>
<spring:message code="adminManager.head.title" var="lbManagerTitle"/>

<spring:message code="report.pieChart.urgency" var="lbPieUrgency"/>
<spring:message code="report.pieChart.economy" var="lbPieEconomy"/>
<spring:message code="report.pieChart.typeOrder" var="lbPieTypeOrder"/>
<spring:message code="report.pieChart.quantity" var="lbPieQuantity"/>
<spring:message code="report.pieChart.title" var="lbPieTitle"/>
<spring:message code="report.comboChart.day" var="lbComboDay"/>
<spring:message code="report.comboChart.inTime" var="lbComboInTime"/>
<spring:message code="report.comboChart.later" var="lbComboLater"/>
<spring:message code="report.comboChart.earlier" var="lbComboEarlier"/>
<spring:message code="report.comboChart.average" var="lbComboAverage"/>
<spring:message code="report.comboChart.deliveryOrders" var="lbComboDeliveryOrders"/>
<spring:message code="report.comboChart.orders" var="lbComboOrders"/>
<spring:message code="report.comboChart.days" var="lbComboDays"/>

<spring:message code="report.information.title" var="lbPieInformationTitle"/>
<spring:message code="report.information.text" var="lbPieInformationText"/>
<spring:message code="report.information.combo.title" var="lbComboInformationTitle"/>
<spring:message code="report.information.combo.text" var="lbComboInformationText"/>


<html>
<head>
    <title>${lbManagerTitle}</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  	<link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/personal.css"/>"/>
    <link rel="icon" type="image/png" href="<c:url value="/resources/Login_v2/images/icons/favicon.ico"/>"/>

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400;300" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
     <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      
      var day = new Date();
      var d1 = day.getDate()-1;
      var d2 = day.getDate()-2;
      var d3 = day.getDate()-3;
      var d4 = day.getDate()-4;
      var d5 = day.getDate()-5;

      function drawChart() {
    	  //(${fn:length(readyEqual[0])} + ${fn:length(readyMore[0])} + ${fn:length(readyLess[0])})/3
    	  var info = [
              ['${lbPieTypeOrder}', '${lbPieQuantity}'],
              ['${lbPieEconomy}',     ${fn:length(ecOrd)}],
              ['${lbPieUrgency}',      ${fn:length(urgOrd)}]
            ]

        var data = google.visualization.arrayToDataTable(info);

        var options = {
          title: '${lbPieTitle}'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
    
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
         ['${lbComboDay}', '${lbComboInTime}',    '${lbComboLater}',    '${lbComboEarlier}',   '${lbComboAverage}'],
         [d1,  ${fn:length(readyEqual[0])},      ${fn:length(readyMore[0])},        ${fn:length(readyLess[0])},          ${average[0]}],
         [d2,  ${fn:length(readyEqual[1])},      ${fn:length(readyMore[1])},        ${fn:length(readyLess[1])},          ${average[1]}],
         [d3,  ${fn:length(readyEqual[2])},      ${fn:length(readyMore[2])},        ${fn:length(readyLess[2])},          ${average[2]}],
         [d4,   ${fn:length(readyEqual[3])},      ${fn:length(readyMore[3])},        ${fn:length(readyLess[3])},          ${average[3]}],
         [d5,   ${fn:length(readyEqual[4])},      ${fn:length(readyMore[4])},        ${fn:length(readyLess[4])},          ${average[4]}]
      ]);

    var options = {
      title : '${lbComboDeliveryOrders}',
      vAxis: {title: '${lbComboOrders}'},
      hAxis: {title: '${lbComboDays}'},
      seriesType: 'bars',
      series: {3: {type: 'line'}}
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
    chart.draw(data, options);
  }
    </script>
</head>
<body>


<%@ include file = "menuGeneral.jsp" %>

<c:choose>
        <c:when test="${not empty sessionScope.principal and sessionScope.principal.admin}">
            <%@ include file = "menuAdmin.jsp" %>
        </c:when>
        <c:when test="${not empty sessionScope.principal and sessionScope.principal.manager}">
            <%@ include file = "menuManager.jsp" %>
        </c:when>
        <c:when test="${not empty sessionScope.principal}">
            <%@ include file = "menuCustomer.jsp" %>
        </c:when>
    </c:choose>

<section id="main" class="wrapper">
    <div class="container">
        <header class="major special">
            <h2>${lbReportTitleName }</h2>
        </header>
    </div>
</section>
<form method = "get" action="${contextPath}/report" name="report" id="report">
<section id="one" class="wrapper style1">
	<div class="container 75%">
		<div class="row 200%">
			<div class="6u 12u$(medium)">
				<header class="major">
					<h2>${lbPieInformationTitle}</h2>
				</header>
			</div>
			<div class="6u$ 12u$(medium)">
				<p>${lbPieInformationText} ${pieCost }</p>
			</div>
		</div>
	</div>
</section>

	<div id="piechart" style="width: 900px; height: 500px;"></div>
	
<section id="one" class="wrapper style1">
	<div class="container 75%">
		<div class="row 200%">
			<div class="6u 12u$(medium)">
				<header class="major">
					<h2>${lbComboInformationTitle}</h2>
				</header>
			</div>
			<div class="6u$ 12u$(medium)">
				<p>${lbComboInformationText} ${comboCost }</p>
			</div>
		</div>
	</div>
</section>

	<div id="chart_div" style="width: 900px; height: 500px;"></div>
</form>



<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/menu.js"/>"></script>
</body>
</html>