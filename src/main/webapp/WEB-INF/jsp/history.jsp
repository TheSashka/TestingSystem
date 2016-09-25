<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="list-group">
    <c:forEach items="${histories}" var="history">
        <a href="/results/${history.id}" class="list-group-item">Test №${history.id} &ensp;&ensp;&ensp; 
        &ensp; Date: ${history.date}</a>
    </c:forEach>
</div>