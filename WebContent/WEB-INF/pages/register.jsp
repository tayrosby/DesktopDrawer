<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

 <div class="container">
	<h2>Register a New User Account</h2>
	<div class="form-container">
	<form:form method="POST" modelAttribute="user" action="registerUser">
		<div class="form-group">
				<form:label class="control-label col-xs-2" path="firstName">FirstName:</form:label>
				<form:input class="col-xs-9" path="firstName"/><form:errors class="errors" path="firstName"/>
		</div>
		<div class="form-group">
				<form:label class="control-label col-xs-2" path="lastName">LastName:</form:label>
				<form:input class="col-xs-9" path="lastName"/><form:errors class="errors" path="lastName"/>
		</div>
		<div class="form-group">
				<form:label class="control-label col-xs-2" path="credentials.email">Email:</form:label>
				<form:input class="col-xs-9" path="credentials.email"/><form:errors class="errors" path="credentials.email"/>
		</div>
		<div class="form-group">
				<form:label class="control-label col-xs-2" path="credentials.password">Password:</form:label>
				<form:password class="col-xs-9" path="credentials.password"/><form:errors class="errors" path="credentials.password"/>
		</div>
		<div class="form-group">
				<form:label class="control-label col-xs-2" path="username">Username:</form:label>
				<form:input class="col-xs-9" path="username"/><form:errors class="errors" path="username"/>
		</div>
			
		<div class="form-group">
				<form:label class="control-label col-xs-2" path="phonenumber">Phonenumber:</form:label>
				<form:input class="col-xs-9" path="phonenumber"/><form:errors class="errors" path="phonenumber"/>
		</div>
		<br>
		<div class="form-group">
				<button>Submit</button>
		</div>
	</form:form>
	  </div>
  </div>