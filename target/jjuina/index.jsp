<!doctype html>
<html lang="en">
<head>
  <title>Jjuina</title>
  <%--<link rel="stylesheet" href="/jjuina/static/css/main.css" type="text/css"/>--%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div id="container" class="container-fluid">
  <%@include file="/WEB-INF/views/header.html"%>


  <div class="content">
    <ul class="nav flex-column">
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:9000/jjuina/student/getAllStudents">getAllStudents</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:9000/jjuina/car/getAllCars">getAllCars</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:9000/jjuina/data/getAll">getAllDatas</a>
      </li>
    </ul>
  </div>

  <%@include file="/WEB-INF/views/copyright_footer.html"%>
</div>
</body>
</html>
