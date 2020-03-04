<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script>
	function openDialog() {
		$(".dialog-confirm").dialog({
			autoOpen : false,
			show : {
				effect : "blind",
				duration : 1000
			},
			hide : {
				effect : "explode",
				duration : 1000
			},
			resizable : false,
			height : "auto",
			width : 400,
			modal : true,
			buttons : {
				"Delete" : function() {
					document.forms["DeletePost"].submit();
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			}
		});
		$(".opener").on("click", function() {
			$(".dialog-confirm").dialog().dialog("open");
		});
	}
	$(document).ready(openDialog);
</script>


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
								
						<div class="dialog-confirm" title="Delete?">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin: 12px 12px 20px 0;"></span>This item
								will be permanently deleted and cannot be recovered. Are you
								sure?
							</p>
						</div>
		
						<button class="opener">Delete</button> <form:form
							name="DeletePost" method="POST" modelAttribute="post"
							action="deletePost">
							
								<form:input class="delete-id" type="hidden" path="ID"
										value="${post.ID}" />
						
						</form:form>
			
				</div>
			</c:forEach>
			</form>
			
</div>