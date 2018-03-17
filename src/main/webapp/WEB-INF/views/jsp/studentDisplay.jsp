<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>All Students in System</title>
  <%--<link rel="stylesheet" href="/jjuina/static/css/main.css" type="text/css"/>--%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
<div class="container">

  <%@include file="../header.html" %>

  <div id="content" class="table-responsive">
    <table class="table table-striped table-bordered">
      <thead class="thead-dark">
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Age</th>
        <th scope="col">Sex</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="student" items="${students}">
        <tr>
          <th scope="row">${student.id}</th>
          <td>${student.name}</td>
          <td>${student.age}</td>
          <td>${student.sex}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>

  <div id="footer" class="footer">
    <%@include file="../copyright_footer.html" %>
  </div>
</div>
</body>
</html>
