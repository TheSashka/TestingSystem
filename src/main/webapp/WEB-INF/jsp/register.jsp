<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<style type="text/css"> <%@include file="/WEB-INF/css/index.css" %> </style>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
</head>
<body>
        <div class="form">
            <h1 class="header">Testing System</h1>
            <div class="textfields">
                <input type="text" class="form-control" placeholder="Login">
                <input type="text" class="form-control" placeholder="Email">
                <input type="password" class="form-control" placeholder="Password">
                <input type="password" class="form-control" placeholder="Repeat password">
            </div>
            <div class="button">
            <button type="button" class="btn btn-default">ОК</button>
            <button type="button" class="btn btn-primary">Отмена</button>
            </div>
        </div>

<br><br>

<center>
<tiles:insertAttribute name="footer" />
</center>

</body>
</html>