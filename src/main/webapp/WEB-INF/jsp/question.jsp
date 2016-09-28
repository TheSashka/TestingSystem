<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${param.success eq true}">
		<div class="alert alert-success">Delete question successfull!</div>
</c:if>

<c:forEach items="${questions}" var="question">
    <ul class="list-group">
		<li class="list-group-item">
            <div class="form-group">
                ${question.text}
                <div>
                    <a class="btn btn-danger" id="btn" href="delete/${question.id}" role="button">Удалить</a>
                </div>
            </div>
        </li>
	</ul>
</c:forEach>