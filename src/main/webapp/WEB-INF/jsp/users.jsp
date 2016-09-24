<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="list-group">
     <c:forEach items="${users}" var="user">
        <a href="/user-detail/${user.id}" class="list-group-item">${user.login}</a>
    </c:forEach>
</div>