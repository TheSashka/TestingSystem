<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style type="text/css"> <%@include file="/WEB-INF/css/profile.css" %> </style>

    <div class="profile" >
        <form:form action="save/${user.id}" commandName="user" cssClass="form-horizontal saveFrom">
             <div class="textfields">
                <div class="form-group">
                    <form:errors path="login" />
                    <label class="col-sm-2 control-label" for="login">Login</label>
                    <div class="col-sm-10">
                    <form:input path="login" cssClass="form-control" placeholder="Login"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:errors path="email" />
                    <label class="col-sm-2 control-label" for="email">Email</label>
                     <div class="col-sm-10">
                    <form:input path="email" cssClass="form-control" placeholder="Email"/>
                     </div>
                </div>
                <div class="form-group">
                    <form:errors path="password" />
                    <label class="col-sm-2 control-label" for="password">Password</label>
                    <div class="col-sm-10">
                    <form:password path="password" cssClass="form-control" placeholder="Password"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:errors path="repeatPassword" />
                    <label class="col-sm-2 control-label" for="repeatPassword">Repeate password</label>
                    <div class="col-sm-10">
                    <form:password path="repeatPassword" class="form-control" placeholder="Repeat password"/>
                    </div>
                </div>  
            </div>
            
            <div align="right">
                <div class="form-group">
			    <input type="submit" name="save" value="Сохранить" class="btn btn-default" />   
                </div>
            </div>
            </form:form> 
    </div>