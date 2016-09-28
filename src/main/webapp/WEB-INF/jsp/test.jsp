<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style type="text/css"> <%@include file="/WEB-INF/css/test.css" %> </style>

<form:form method="POST" action="/result" commandName="resultForm">
 <c:forEach items="${multipleChoices}" var="multipleChoice" varStatus="status">
    <ul class="list-group">
		<li class="list-group-item">
            ${multipleChoice.question}
            <div>
                <c:forEach items="${multipleChoice.answers}" var="answer">
                    <div class="radio">
                        <label>
                            <form:radiobutton path="answers[${status.index}].id"  
                            value="${answer.id}"/>${answer.text}
                        </label>
                    </div>
                </c:forEach>
            </div>  
        </li>
	</ul>
</c:forEach>
<div align="right">
    <button type="submit" class="btn btn-default">Проверка теста</button>
</div>
</form:form>


