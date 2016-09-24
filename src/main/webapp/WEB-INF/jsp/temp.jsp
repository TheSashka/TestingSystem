<div>
    <form:form method="post" action="processRadioButtonForm" commandName="result">
    <c:forEach items="${tests}" var="test">
		<ul class="list-group">
			<li class="list-group-item">
                <div>
                <c:forEach items="${test.answers}" var="answer">
                    <div class="radio">
                     <label>
                        <form:radiobutton path="${answer.idQuestion}" value="${answer.id}"/>${answer.text}
                    </label>
                </c:forEach>
                </div>
            </li>
		</ul>
	</c:forEach>
    </form:form>
</div>