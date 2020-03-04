<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="container">
	<h2>Heyo, your registration went through successfully! Here is your submitted information</h2>
	<div class="form-container">
		<div class="form-group">
				<label class="control-label col-xs-2">${user.firstName}</label>
		</div>
		<div class="form-group">
				<label class="control-label col-xs-2">${user.lastName}</label>
		</div>
		<div class="form-group">
				<label class="control-label col-xs-2">${user.credentials.email}</label>
		</div>
		<div class="form-group">
				<label class="control-label col-xs-2">${user.credentials.password}</label>
		</div>
		<div class="form-group">
				<label class="control-label col-xs-2">${user.username}</label>
		</div>
		<div class="form-group">
				<label class="control-label col-xs-2">${user.phonenumber}</label>
		</div>
		<div class="form-group">
				<a href="/Desktop_Drawer2/login/loginUser">Now that you have registered, lets Login!</a>
		</div>
		</div>
		</div>