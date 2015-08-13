<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="navigation.html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>rta page</title>
</head>
<body>
<p>
<table cellspacing='0' border="false">
    <h3>road accidents</h3>
    <c:forEach items="${rcolls}" var="c">
        <th>
            <c:out value="${c}"/>
        </th>
    </c:forEach>
    <c:forEach items="${rrows}" var="r">
        <tr>
            <td><c:out value="${r.id}"/></td>
            <td><c:out value="${r.date}"/></td>
            <td><c:out value="${r.code}"/></td>
        </tr>
    </c:forEach>
</table>
</p>
</body>
</html>
