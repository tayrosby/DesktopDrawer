<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<div class="container">
	<h2>Login to an Account</h2>
	<div class="form-container">
	<form:form method="POST" modelAttribute="credentials" action="displayLogin">
		<div class="form-group">
			<form:label class="control-label col-xs-2" path="email">Email:</form:label>
			<form:input class="col-xs-9" path="email"/><form:errors class="errors" path="email"/>
		</div>
		<div class="form-group">
			<form:label class="control-label col-xs-2" path="password">Password:</form:label>
			<form:password class="col-xs-9" path="password"/><form:errors class="errors" path="password"/>
		</div>
		<div class="form-group">
				<button>Submit</button>
		</div>
	</form:form>
	</div>
	</div>
