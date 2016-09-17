<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<style type="text/css"> <%@include file="/WEB-INF/css/register.css" %> </style>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
</head>
<body>
    <div class="form">
        <h1 class="header">Register</h1>
        <form:form commandName="user" cssClass="form-horizontal">
             <div class="textfields">
                <form:input path="login" cssClass="form-control" placeholder="Login"/>
                <form:errors path="login" />

                <form:input path="email" cssClass="form-control" placeholder="Email"/>
                <form:errors path="email" />
                <form:password path="password" cssClass="form-control" placeholder="Password"/>
                <form:errors path="password" />
           
                <input type="password" class="form-control" placeholder="Repeat password"/>
            </div>
            <div class="button">
			    <input type="submit" name="register" value="ОК" class="btn btn-default" />
		       
		        <input type="submit" name="cancel" value="Отмена" class="btn btn-primary" />
		     </div>
        </form:form>
    </div>
<br><br>

<center>
<tiles:insertAttribute name="footer" />
</center>

</body>
</html>