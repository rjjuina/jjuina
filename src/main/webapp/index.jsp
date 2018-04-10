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

  <div class="svg-practice" style="margin-bottom: 200px">
    <svg xmlns="http:/.www.w3.org/2000/svg"
      xmlns:xlink="http://www.w3.org/1999/xlink"
      viewBox="0 0 400 200" width="4in" height="2in">
      <title xml:lang="en">Fill-rule comparision</title>
      <rect fill="lightSkyBlue" height="100%" width="100%" />

      <polygon id="p" fill="blueViolet" stroke="navy"
        points="20,180 20,20 180,20 180,180 60,60 140,60"/>
      <use xlink:href="#p" x="50%" fill-rule="evenodd" />
    </svg>
  </div>

  <%@include file="/WEB-INF/views/copyright_footer.html"%>
</div>
</body>
</html>
