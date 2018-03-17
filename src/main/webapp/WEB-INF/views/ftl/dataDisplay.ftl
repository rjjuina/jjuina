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
      <form name="requestData" action="doHttpRequest" method="post">
        <div class="form-group">
          <label for="requestUrl">requestUrl:</label> <input type="text" id="requestUrl" name="requestUrl" class="form-control"/>
        </div>
        <div class="form-group">
          <label for="destinations">destinations:</label> <textarea type="text" id="destinations" name="destinations" class="form-control"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">search</button>
      </form>
    </fieldset>
    <br/>
    <div id="content" class="table-responsive">
      <table class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr>
          <th scope="col">flag</th>
        </tr>
        </thead>
        <tbody>
        <#list dataList as data>
          <tr>
            <th scope="row">${data}</th>
          </tr>
        </#list>
        </tbody>
      </table>
    </div>
  </div>

  <div id="footer" class="footer">
    <#include "copyright_footer.html">
  </div>
</div>
</body>
</html>