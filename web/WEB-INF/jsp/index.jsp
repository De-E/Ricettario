<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="ricettario" ng-controller="controller" >
    <head>
        <link href="node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" src="img/favicon.ico"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ricettario</title>
    </head>

    <body>
        <h1>{{rest.txt}}</h1>
        {{rest.values}}
    </body>
    <script src="node_modules/angular/angular.min.js" type="text/javascript"></script>
    <script src="node_modules/angular-route/angular-route.min.js" type="text/javascript"></script>
    <script src="node_modules/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="node_modules/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/app.js" type="text/javascript"></script>
</html>
