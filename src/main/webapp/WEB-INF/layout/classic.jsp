<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<tilesx:useAttribute name="current"/>
<div class="form">
  <nav class="navbar navbar-default">
    <div class="container-fluid">      
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="${current == 'home' ? 'active' : ''}">
            <a class="navbar-brand" href='<spring:url value="/"/>'>
            <span class="glyphicon glyphicon-home" aria-hidden="true"></span></a></li>
          <security:authorize access="isAuthenticated() and hasRole('USER')">
            <li class="${current == 'test' ? 'active' : ''}"><a href='<spring:url value="/startTesting" />'>Тест</a></li>
            <li class="${current == 'history' ? 'active' : ''}"><a href='<spring:url value="/history" />'>История</a></li>
            <li class="${current == 'profile' ? 'active' : ''}"><a href='<spring:url value="/profile" />'>Профиль</a></li>
          </security:authorize>
          <security:authorize access="isAuthenticated() and hasRole('ADMIN')">
            <li class="${current == 'users' ? 'active' : ''}"><a href="<spring:url value="/users" />">Аккаунты</a></li>
            <li class="${current == 'history' ? 'active' : ''}"><a href='<spring:url value="/histories" />'>История</a></li>
            <li class="${current == 'addQuestion' ? 'active' : ''}"><a href='<spring:url value="/addQuestion" />'>Добавить вопрос</a></li>
            <li class="${current == 'question' ? 'active' : ''}"><a href='<spring:url value="/question" />'>Вопросы</a></li>
          </security:authorize>
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
      </div>
    </div>
  </nav>
  <tiles:insertAttribute name="body" />
</div>
<center>
  <tiles:insertAttribute name="footer" />
</center>
</body>
</html>