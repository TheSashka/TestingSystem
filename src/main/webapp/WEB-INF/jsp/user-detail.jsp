<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form class="form-horizontal">
    <div class="form-group">
        <label class="col-sm-2 control-label">Login</label>
        <div class="col-sm-10">
            <p class="form-control-static">${user.login}</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
            <p class="form-control-static">${user.email}</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Role</label>
        <div class="col-sm-10">
            <p class="form-control-static">${user.role}</p>
        </div>
    </div>
</form>