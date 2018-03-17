<!doctype html>
<html lang="en">
<html>
<head>
  <title>FreeMarker Spring MVC HelloWorld</title>
<#--<link rel="stylesheet" href="/jjuina/static/css/main.css" type="text/css"/>-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div id="container" class="container">
  <div id="header">
    <#include "header.html">
  </div>

  <div class="content">
    <fieldset>
      <legend>Add Car</legend>
      <form name="car" action="add" method="post">
        <div class="form-group">
          <label for="make">Make:</label> <input type="text" id="make" name="make" class="form-control"/>
        </div>
        <div class="form-group">
          <label for="model">Model:</label> <input type="text" id="model" name="model" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
      </form>
    </fieldset>
    <br/>
    <table id="datatable" class="datatable">
      <tr>
        <th>Make</th>
        <th>Model</th>
      </tr>
      <#list carList as car>
          <tr>
            <td>${car.make}</td>
            <td>${car.model}</td>
          </tr>
      </#list>
    </table>
  </div>

  <div id="footer" class="footer">
    <#include "copyright_footer.html">
  </div>
</div>
</body>
</html>