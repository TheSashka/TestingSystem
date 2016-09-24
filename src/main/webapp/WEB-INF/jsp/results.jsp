<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div>
    <c:forEach items="${results}" var="result">
		<ul class="list-group">
			<li class="list-group-item">
				${result.question}
                <div>
                    <c:if test="${result.isTrue eq true}">
                        <label class="radio-inline">
                            <input type="radio" checked><p class="text-success">
                                <c:out value="${result.answer}"/></p>
                        </label>
	                </c:if>
                    <c:if test="${result.isTrue eq false}">
                        <label class="radio-inline">
                            <input type="radio" checked><p class="text-danger">
                                <c:out value="${result.answer}" /></p>
                        </label>
	                </c:if>
                </div>
            </li>
		</ul>
	</c:forEach>
</div>
