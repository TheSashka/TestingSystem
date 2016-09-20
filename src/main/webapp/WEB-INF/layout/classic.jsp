<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<style type="text/css"> <%@include file="/WEB-INF/css/classic.css" %> </style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
<div class="form">
  <nav class="navbar navbar-default">
    <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href='<spring:url value="/home" />'>Home</a>
      </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="${current == '/test' ? 'active' : ''}"><a href='<spring:url value="/test" />'>Тест</a></li>
          <li class="${current == '/history' ? 'active' : ''}"><a href='<spring:url value="/history" />'>История</a></li>
          <li class="${current == '/settings' ? 'active' : ''}"><a href='<spring:url value="/settings" />'>Настройки</a></li>
        </ul>
          <ul class="nav navbar-nav navbar-right">
            <security:authorize access="!isAuthenticated()">
              <li class="${current == 'login' ? 'active' : ''}"><a href="<spring:url value="/login" />">Войти</a></li>
              <li class="${current == 'registration' ? 'active' : ''}"><a href="<spring:url value="/registration" />">Регистрация</a></li>
              </security:authorize>
              <security:authorize access="isAuthenticated()">
              	<li><a href='<spring:url value="/logout" />'>Выход</a></li>
              </security:authorize>
            
          </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>
  <tiles:insertAttribute name="body" />
</div>
<center>
  <tiles:insertAttribute name="footer" />
</center>

</body>
</html>