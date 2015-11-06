<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link href="<c:url value='/resources/css/bootstrap.login.min.css'/>" rel="stylesheet" type="text/css" />

<html ng-app="loginApp">
<div class="row-fluid">
    <div class="jumbotron">
        <h1><spring:message code='project.name'/></h1>
    </div>
</div>
<div class="row-fluid">
    <div class="span4 offset4 well"  ng-controller="loginController">
        <legend><spring:message code="login.header" /></legend>
        <div class="alert alert-error" ng-class="{'': displayLoginError == true, 'none': displayLoginError == false}">
            <spring:message code="login.error" />
        </div>
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form method="post" action="${loginUrl}">
            <div>
                <input name="j_username" id="j_username"  value="admin" type="text" class="span12" placeholder="<spring:message code='sample.email' /> "><br/>
                <input name="j_password" id="j_password" type="password" value="admin" class="span12" placeholder="Password"><br/>
                <button type="submit" name="submit" class="btn btn-inverse btn-block"><spring:message code="login.signIn" /></button>
            </div>
        </form>
    </div>
</div>

<script src="<c:url value='/resources/js/pages/login.js' />"></script>

</html>
