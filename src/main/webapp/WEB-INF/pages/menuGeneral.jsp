<!-- Header -->
<header id="header">
    <h1><strong>${lbSectMain}</strong></h1>
    <nav id="nav">
        <ul>
            <li><a href="${contextPath}/index">${lbNavMain}</a></li>
			<li><a href="${contextPath}/rateform">${lbNavRates}</a></li>
			<c:if test="${empty sessionScope.principal}">
				<li><a href="${contextPath}/loginform">${lbNavAuth}</a></li>
			</c:if>
			<c:if test="${not empty sessionScope.principal}">
	            <li>
	                <div>
	                    <div style="color: brown" class="icon-menu">
	                        <img class="contact" src="<c:url value="/resources/images/contact.png"/>"/>${lbLiDiv}
	                    </div>
	                </div>
	            </li>
            </c:if>
        </ul>
    </nav>
</header>
<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>