<spring:message code="changingAgreement.header" var="lbChangAgrHeader"/>
<spring:message code="changingBox.managementBox" var="lbNameTitleBoxMan"/>
<spring:message code="changingBranch.nameTitle" var="lbNameTitleBranch"/>
<spring:message code="contact.div.ul.liE" var="lbUlLiE"/>
<spring:message code="contact.div.ul.liD" var="lbUlLiD"/>
<spring:message code="report.nameTitle.rep" var="lbReportTitleName"/>
<spring:message code="order.orders" var="lbStatusOrder"/>

<div class="menu">
    <div class="icon-close">
        <img src="<c:url value="/resources/images/close-btn.png"/>"/>
    </div>

    <ul>
        <li><a href="${contextPath}/changingBranch">${lbNameTitleBranch}</a></li>
        <li><a href="${contextPath}/changingAgreement">${lbChangAgrHeader}</a></li>
        <li><a href="${contextPath}/changingBox">${lbNameTitleBoxMan}</a></li>
        <li><a href="${contextPath}/status">${lbStatusOrder}</a></li>
        <li><a href="${contextPath}/report">${lbReportTitleName }</a></li>
        <li><a href="${contextPath}/contact/${sessionScope.principal.id}">${lbUlLiD}</a></li>
        <li><a href="${contextPath}/logout">${lbUlLiE}</a></li>
    </ul>
</div>