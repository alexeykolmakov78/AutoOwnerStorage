<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="navigation.html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>vehicle page</title>
</head>
<body>
<p>
<table id="my" cellspacing='0' border="false">
    <h3>vehicles</h3>
    <c:forEach items="${vcolls}" var="c">
        <th>
            <c:out value="${c}"/>
        </th>
    </c:forEach>
    <c:forEach items="${vrows}" var="r">
        <tr>
            <td><c:out value="${r.id}"/></td>
            <td><c:out value="${r.brand}"/></td>
            <td><c:out value="${r.model}"/></td>
            <td><c:out value="${r.registrationNumber}"/></td>
            <td><c:out value="${r.productionDate}"/></td>
            <td><c:out value="${r.lastServiceDate}"/></td>
            <td><c:out value="${r.rta}"/></td>
            <td><c:out value="${r.owner}"/></td>
        </tr>
    </c:forEach>
</table>
</p>
</body>
</html>

