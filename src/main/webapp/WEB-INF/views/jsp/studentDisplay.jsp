<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Spring MVC Hello World</title>
    <link rel="stylesheet" href="/jjuina/static/css/main.css" type="text/css"/>
</head>

<body>
<h2>All Students in System<br/>${testaaa}</h2>
<div id="content" class="content">
    <table class="datatable">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Sex</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.sex}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="footer" class="footer">
    <%@include file="copyright_footer.html" %>
</div>
</body>
</html>
