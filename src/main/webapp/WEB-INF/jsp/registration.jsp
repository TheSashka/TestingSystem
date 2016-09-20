<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<style type="text/css"> <%@include file="/WEB-INF/css/register.css" %> </style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="form">
        <h1 class="header">Registration</h1>
        <form:form action="registration" commandName="user" cssClass="form-horizontal registrationForm">

            <c:if test="${param.success eq true}">
		        <div class="alert alert-success">Registration successfull!</div>
	        </c:if>

             <div class="textfields">
                <div class="form-group">
                    <form:errors path="login" />
                    <form:input path="login" cssClass="form-control" placeholder="Login"/>
                </div>
                <div class="form-group">
                    <form:errors path="email" />
                    <form:input path="email" cssClass="form-control" placeholder="Email"/>
                </div>
                <div class="form-group">
                    <form:errors path="password" />
                    <form:password path="password" cssClass="form-control" placeholder="Password"/>
                </div>
                <div class="form-group">
                    <form:errors path="repeatPassword" />
                    <form:password path="repeatPassword" class="form-control" placeholder="Repeat password"/>
                </div>  
            </div>
            
            <div align="right">
                <div class="form-group">
			    <input type="submit" name="register" value="Регистрация" class="btn btn-default" />   
                </div>
            </div>
            </form:form> 
    </div>
<script type="text/javascript">
$(document).ready(function() {
	
	$(".registrationForm").validate(
		{
			rules: {
				login: {
					required : true,
					minlength : 3,
					remote : {
						url: "<spring:url value='/registration/availableLogin/' />",
						type: "get",
						data: {
							login: function() {
								return $("#login").val();
							}
						}
					}
				},
				email: {
					required : true,
					email: true,
					remote : {
						url: "<spring:url value='/registration/availableEmail/' />",
						type: "get",
						data: {
							email: function() {
								return $("#email").val();
							}
						}
					}
				},
				password: {
					required : true,
					minlength : 5
				},
				repeatPassword: {
					required : true,
					minlength : 5,
					equalTo: "#password"
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages: {
				name: {
					remote: "Such username already exists!"
				}
			}
		}
	);
});
</script>
<br><br>

<center>
<tiles:insertAttribute name="footer" />
</center>

</body>
</html>