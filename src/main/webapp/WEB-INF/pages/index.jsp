<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<spring:message code="index.title" var="lbTitle"/>
<spring:message code="index.nav.main" var="lbNavMain"/>
<spring:message code="index.nav.rates" var="lbNavRates"/>
<spring:message code="index.nav.auth" var="lbNavAuth"/>

<html>
	<head>
		<title>${lbTitle}</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css"/>"/>
	</head>
	<body class="landing">

		<!-- Header -->
			<header id="header" class="alt">
				<nav id="nav">
					<ul>
						<li><a href="index.html">${lbNavMain}</a></li>
						<li><a href="rate.html">${lbNavRates}</a></li>
						<li><a href="login.html">${lbNavAuth}</a></li>
					</ul>
				</nav>
			</header>

			<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

		<!-- Banner -->
			<section id="banner">
				<h2>АИС "Транспортная логистика"</h2>
				<p>Данная система позволяет рассчитывать стоимость<br />перевозок грузов между филиалами данной компании.<br /><br />Чтобы воспользоваться программой, пройдите авторизацию</p>
				<ul class="actions">
					<li><a href="login.html" class="button special big">Узнать стоимость</a></li>
				</ul>
			</section>

			<!-- One -->
				<section id="one" class="wrapper style1">
					<div class="container 75%">
						<div class="row 200%">
							<div class="6u 12u$(medium)">
								<header class="major">
									<h2>Информация о компании</h2>
								</header>
							</div>
							<div class="6u$ 12u$(medium)">
								<p>Система определяет стоимость перевозки грузов (посылок и конвертов) между филиалами данной компании. Используются грузовые виды транспорта, ЖД перевозки и авиоперевозки, что в совокупности дает вам возможность выбора между наиболее быстрой и минимально дорогой перевозкой посылки</p>
								<p>Стоимость определяется действующим тарифом и дальностью перевозки. Подробнее о тарифах можете узнать во вкладке "Тарифы"</p>
							</div>
						</div>
					</div>
				</section>

		<!-- Scripts -->
			<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
			<script src="<c:url value="/resources/assets/js/skel.min.js"/>"></script>
			<script src="<c:url value="/resources/assets/js/util.js"/>"></script>
			<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

	</body>
</html>