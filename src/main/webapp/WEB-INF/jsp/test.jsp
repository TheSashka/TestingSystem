<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


This is test page
<div>
    <c:forEach items="${tests}" var="test">
		<ul class="list-group">
			<li class="list-group-item">
				<c:out value="${test.question}" />
                <div>
                <c:forEach items="${test.answers}" var="answer">
                    <label class="radio-inline">
                        <input type="radio" name="inlineRadioOptions${answer.idQuestion}" 
                        id="inlineRadio${answer.id}" value="option${answer.id}">
                        <c:out value="${answer.text}" />
                    </label>
                </c:forEach>
                </div>
            </li>
		</ul>
	</c:forEach>
</div>
<div align="right">
    <button type="submit" class="btn btn-default">Проверка теста</button>
</div>
