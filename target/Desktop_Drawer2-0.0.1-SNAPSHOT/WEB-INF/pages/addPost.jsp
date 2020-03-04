<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
<h2>Add a Post</h2>
	<div class="form-container">
	<form:form method="POST" modelAttribute="post" action="addPost">
		
			<div class="form-group">
				<form:label class="control-label col-xs-2" path="title">Title:</form:label>
				<form:input class="col-xs-9" path="title"/><form:errors class="errors" path="title"/>
			</div>
			<div class="form-group">
				<form:label class="control-label col-xs-2" path="content">Content:</form:label>
				<form:input class="col-xs-9" path="content"/><form:errors class="errors" path="content"/>
			</div>
			<div class="form-group">
				<button>Submit</button>
			</div>

		<br/>
	</form:form>
	</div>
	</div>