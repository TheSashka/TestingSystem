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
<style type="text/css"> <%@include file="/WEB-INF/css/newPassword.css" %> </style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="form">
    <form:form action="/settingNewPassword" commandName="user" cssClass="form-horizontal restorPasswordForm">
        <h1 class="header">Enter New Password for ${user.email}</h1>
        <div class="textfields">
            <form:hidden path="email" value="${user.email}" />
            <div class="form-group">
                <form:errors path="password" />
                <form:password path="password" cssClass="form-control" placeholder="Password"/>
            </div>
            <div class="form-group">
                <form:errors path="repeatPassword" />
                <form:password path="repeatPassword" cssClass="form-control" placeholder="Repeat password"/>
            </div>  
        </div>
            
        <div align="right">
            <div class="form-group">
			    <input type="submit" name="save" value="Сохранить пароль" class="btn btn-default" />   
            </div>
        </div>
    </form:form> 
</div>
<br><br>

<center>
<tiles:insertAttribute name="footer" />
</center>

</body>
</html>