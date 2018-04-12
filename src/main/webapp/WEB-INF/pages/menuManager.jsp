<spring:message code="report.nameTitle.rep" var="lbReportTitleName"/>
<spring:message code="order.orders" var="lbStatusOrder"/>



<div class="menu">

     <div class="icon-close">
        <img src="<c:url value="/resources/images/close-btn.png"/>"/>
    </div>

    <ul>
        <li><a href="${contextPath}/status">${lbStatusOrder}</a></li>
        <li><a href="${contextPath}/report">${lbReportTitleName }</a></li>
    </ul>
</div>