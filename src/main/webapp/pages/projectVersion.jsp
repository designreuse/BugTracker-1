<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlados
  Date: 4/18/2016
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="version"/>: ${projectVersion.name}</title>
</head>
<body>
<jsp:include page='navigation.jsp' />
<jsp:include page='deleteProjectVersionForm.jsp'/>

<div class="row" style="margin-right: 0; margin-top: 0; padding-top: -20px; height: 100%">

    <jsp:include page='projectMenu.jsp'/>

    <div class="col-lg-9" style="margin-left: 1%; margin-top: 1%">
        <span><a href="#">Team name </a>/<a href="/project/${project.name}"> ${project.name}</a></span>

        <button type="button" class="btn btn-default pull-right" data-toggle="modal" data-target="#deleteProjectVersion" style="background-color: #eeeeee"><spring:message code="project.version.delete"/></button>

        <h2><spring:message code="version"/>: ${projectVersion.name}</h2>
        <table class="table">
            <thead>
            <tr>
                <th><spring:message code="description"/></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${projectVersion.description}</td>
            </tr>
            </tbody>
        </table>
        <table class="table table-striped">
            <thead>
            <tr>
                <th><spring:message code="issue"/></th>
                <th><spring:message code="description"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${issues}" var="item">
                <tr>
                    <td><a href="/issue/${item.id}"><c:out value="${item.name}"/></a></td>
                    <td><c:out value="${item.description}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>


</body>
</html>

