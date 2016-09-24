<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="list-group">
    <c:forEach items="${histories}" var="history">
        <a href="/results/${history.id}" class="list-group-item">Test №${history.id}</a>
    </c:forEach>
</div>