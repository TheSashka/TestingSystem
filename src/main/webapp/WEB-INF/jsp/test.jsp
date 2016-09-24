<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style type="text/css"> <%@include file="/WEB-INF/css/test.css" %> </style>

<form:form method="POST" action="/result" commandName="resultForm">
    <ul class="list-group">
		<li class="list-group-item">
            ${questionText}
            <div>
                <c:forEach items="${answersText}" var="answero">
                    <div class="radio">
                        <label>
                            <form:radiobutton path="id"  value="${answero.id}"/>${answero.text}
                        </label>
                    </div>
                </c:forEach>
            </div>
        </li>
	</ul>
<div align="right">
    <button type="submit" class="btn btn-default">Проверка теста</button>
</div>
</form:form>