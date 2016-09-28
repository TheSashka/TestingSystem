<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


 <form:form action="addQuestion" commandName="multipleChoice" cssClass="form-horizontal addQuestionForm">

    <c:if test="${param.success eq true}">
		<div class="alert alert-success">Add question successfull!</div>
	</c:if>

    <div class="textfields">
        <div class="form-group">
            <label for="questionText" class="col-sm-2 control-label">Текст вопроса</label>
            <div class="col-sm-10">
                <form:errors path="question" />
                <form:input path="question" id="questionText" cssClass="form-control" 
                placeholder="Question text"/>
            </div>
        </div>

        <div class="form-group">
            <label for="difficult" class="col-sm-2 control-label">Сложность</label>
            <div class="col-sm-10">
                <form:errors path="difficult" />
                <form:input path="difficult" id="difficult" cssClass="form-control" 
                placeholder="Difficult"/>
            </div>
        </div>

        <div class="form-group">
            <label for="answerText0" class="col-sm-2 control-label">Текст ответа 1</label>
            <div class="col-sm-10">
                <form:errors path="answers[0].text" />
                <form:input path="answers[0].text" id="answerText0" 
                cssClass="form-control" placeholder="Answer text"/>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <form:errors path="answers[0].isTrue" />
                <form:checkbox path="answers[0].isTrue" value="isTrue"/>Правильный ответ 1
            </div>
        </div>

        <div class="form-group">
            <label for="answerText1" class="col-sm-2 control-label">Текст ответа 2</label>
            <div class="col-sm-10">
                <form:errors path="answers[1].text" />
                <form:input path="answers[1].text" id="answerText1" 
                cssClass="form-control" placeholder="Answer text"/>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <form:errors path="answers[1].isTrue" />
                <form:checkbox path="answers[1].isTrue" value="isTrue"/>Правильный ответ 2
            </div>
        </div>

        <div class="form-group">
            <label for="answerText2" class="col-sm-2 control-label">Текст ответа 3</label>
            <div class="col-sm-10">
                <form:errors path="answers[2].text" />
                <form:input path="answers[2].text" id="answerText2" 
                cssClass="form-control" placeholder="Answer text"/>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <form:errors path="answers[2].isTrue" />
                <form:checkbox path="answers[2].isTrue" value="isTrue"/>Правильный ответ 3
            </div>
        </div>

        <div class="form-group">
            <label for="answerText3" class="col-sm-2 control-label">Текст ответа 4</label>
            <div class="col-sm-10">
                <form:errors path="answers[3].text" />
                <form:input path="answers[3].text" id="answerText3" 
                cssClass="form-control" placeholder="Answer text"/>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <form:errors path="answers[3].isTrue" />
                <form:checkbox path="answers[3].isTrue" value="isTrue"/>Правильный ответ 4
            </div>
        </div>

    </div>
    <div align="right">
        <div class="form-group">
			<input type="submit" name="addQuestion" value="Добавить вопрос" class="btn btn-default" />   
        </div>
    </div>
</form:form> 