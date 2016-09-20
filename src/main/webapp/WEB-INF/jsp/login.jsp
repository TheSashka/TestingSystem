<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<style type="text/css"> <%@include file="/WEB-INF/css/login.css" %> </style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>

        <form class="form" role="form" action="<spring:url value="/j_spring_security_check" />" method="POST">
            <h1 class="header">Sign in</h1>
            <div class="textfields">
                <input type="text" name="j_username" path="login" class="form-control" placeholder="Login">
                <input type="password" name="j_password" path="password" class="form-control" placeholder="Password">
            </div>
            <div align="right">
                <button type="submit" name="enter"  class="btn btn-primary">Вход</button>
            </div>
</form>
<br><br>

<center>
<tiles:insertAttribute name="footer" />
</center>

</body>
</html>