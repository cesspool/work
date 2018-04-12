<spring:message code="changingAgreement.header" var="lbChangAgrHeader"/>
<spring:message code="changingBox.managementBox" var="lbNameTitleBoxMan"/>
<spring:message code="changingBranch.nameTitle" var="lbNameTitleBranch"/>

<div class="menu">

    <div class="icon-close">
        <img src="<c:url value="/resources/images/close-btn.png"/>"/>
    </div>

    <ul>
        <li><a href="${contextPath}/changingBranch">${lbNameTitleBranch}</a></li>
        <li><a href="${contextPath}/changingAgreement">${lbChangAgrHeader}</a></li>
        <li><a href="${contextPath}/changingBox">${lbNameTitleBox}</a></li>
        <li><a href="${contextPath}/index">${lbUlE}</a></li>
    </ul>
</div>