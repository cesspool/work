<spring:message code="contact.div.ul.liB" var="lbUlLiB"/>
<spring:message code="contact.div.ul.liA" var="lbUlLiA"/>
<spring:message code="contact.div.ul.liC" var="lbUlLiC"/>
<spring:message code="contact.div.ul.liD" var="lbUlLiD"/>
<spring:message code="contact.div.ul.liE" var="lbUlLiE"/>

<div class="menu">
     <div class="icon-close">
        <img src="<c:url value="/resources/images/close-btn.png"/>"/>
    </div>

    <ul>
        <li><a href="${contextPath}/personal/${sessionScope.principal.id}">${lbUlLiA}</a></li>
        <li><a href="${contextPath}/history/${sessionScope.principal.id}">${lbUlLiB}</a></li>
        <li><a href="${contextPath}/costCalculation">${lbUlLiC}</a></li>
        <li><a href="${contextPath}/contact/${sessionScope.principal.id}">${lbUlLiD}</a></li>
        <li><a href="${contextPath}/logout">${lbUlLiE}</a></li>
    </ul>
</div>


