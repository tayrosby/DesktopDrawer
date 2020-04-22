<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<h1 style="color:white; align:left;">List of Posts</h1>
	<div class="form-container">

<form>
<c:forEach var="post" items="${posts}">
<div class="postcontainer">
		<input type="hidden" value="$post.id"></input>
		<h1 class="title">${post.title}</h1><hr class="sep">
		<h2 class="content">${post.content}</h2>
				<div class="form-container">
				<form:form method="POST" modelAttribute="post"
					action="goToEditPost">
					<div class="form-group">
						<form:input class="col-xs-9" type="hidden" path="ID"
							value="${post.ID}" />
					</div>
					<div class="form-group">
						<form:input class="col-xs-9" type="hidden" path="title"
							value="${post.title}" />
					</div>
					<div class="form-group">
						<form:input class="col-xs-9" type="hidden" path="content"
							value="${post.content}" />
					</div>
					<div class="form-group">
						<button class="edit">Edit</button>
					</div>
				</form:form>
				</div>
				<div class="form-container">
					<form:form method="POST" modelAttribute="post" action="deletePost">
						<div class="form-group">
							<form:input class="col-xs-9" type="hidden" path="ID" value="${post.ID}" />
							<button class="opener">Delete</button>
						</div>
					</form:form>
					</div>
	</div>
</c:forEach>
</form>
			
</div>
