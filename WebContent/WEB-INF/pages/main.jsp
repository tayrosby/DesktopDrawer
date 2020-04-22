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
					
						</div>
			</c:forEach>
			</form>
			
</div>
