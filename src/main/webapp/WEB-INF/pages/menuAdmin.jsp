<spring:message code="changingAgreement.header" var="lbChangAgrHeader"/>
<spring:message code="changingBox.managementBox" var="lbNameTitleBoxMan"/>
<spring:message code="changingBranch.nameTitle" var="lbNameTitleBranch"/>
<spring:message code="contact.div.ul.liE" var="lbUlLiE"/>

<div class="menu">
    <div class="icon-close">
        <img src="<c:url value="/resources/images/close-btn.png"/>"/>
    </div>

    <ul>
        <li><a href="${contextPath}/changingBranch">${lbNameTitleBranch}</a></li>
        <li><a href="${contextPath}/changingAgreement">${lbChangAgrHeader}</a></li>
        <li><a href="${contextPath}/changingBox">${lbNameTitleBoxMan}</a></li>
        <li><a href="${contextPath}/logout">${lbUlLiE}</a></li>
    </ul>
</div>