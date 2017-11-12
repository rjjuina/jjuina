<html>
<head>
    <title>FreeMarker Spring MVC HelloWorld</title>
    <link rel="stylesheet" href="/jjuina/static/css/main.css" type="text/css"/>
</head>
<body>
<div id="header">
    <h2>FreeMarker Spring MVC HelloWorld</h2>
</div>
<div id="content" class="content">
    <fieldset>
        <legend>Add Car</legend>
        <form name="car" action="add" method="post">
            <label for="make">Make:</label>  <input type="text" id="make" name="make"/> <br/>
            <label for="model">Model:</label> <input type="text" id="model" name="model"/> <br/>
            <input type="submit" value="Save"/>
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
</body>
</html>