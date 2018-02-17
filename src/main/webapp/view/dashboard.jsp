<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TODO App</title>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2" >
				<div class="page-heading" >
					<h2>TODO App</h2>
					<hr>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2" >
				<form id="addForm" id="addForm" action="/web/todo/add" method="POST" >
				<div class="input-group">
					<input type="text" class="form-control" name="taskName" placeholder="Enter your task..." required="true">
					<div class="input-group-btn">
						<button onclick="submitAddForm()" class="btn btn-success">Add</button>
					</div>
				</div>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2" >
				<h3>TODO List</h3>
				<hr>
				<form id="updateForm" id="updateForm" action="/web/todo/update" method="POST" >
					<input type="hidden" id="todoId" name="todoId" value="" >
					<input type="hidden" id="taskName" name="taskName" value="" >
					<input type="hidden" id="completed" name="completed" value="false" >
					<input type="hidden" id="deleteFlag" name="deleteFlag" value="false" >
					
					<c:forEach items="${todos}" var="todo" >
					<c:if test="${!todo.completed}" >
						<div class="input-group">
							<input type="text" class="form-control" id="taskName${todo.todoId}" name="taskName${todo.todoId}" value="${todo.taskName}">
							<div class="input-group-btn">
								<button onclick="submitUpdateForm('${todo.todoId}')" class="btn btn-primary">Update</button>
								<button onclick="submitUpdateFormForCompleted('${todo.todoId}')" class="btn btn-success">Completed</button>
								<button onclick="submitUpdateFormForDelete('${todo.todoId}')" class="btn btn-danger">Delete</button>
							</div>
						</div>
					</c:if>
					</c:forEach>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2" >
				<h3>Completed TODO</h3>
				<hr>
				<form id="updateForm" id="updateForm" action="/web/todo/update" method="POST" >
					<input type="hidden" id="todoId" name="todoId" value="" >
					<input type="hidden" id="taskName" name="taskName" value="" >
					<input type="hidden" id="completed" name="completed" value="false" >
					<input type="hidden" id="deleteFlag" name="deleteFlag" value="false" >
					
					<c:forEach items="${todos}" var="todo" >
						<c:if test="${todo.completed}" >
							<div class="form-group">
								<input type="text" disabled class="form-control" id="taskName${todo.todoId}" name="taskName${todo.todoId}" value="${todo.taskName}">
							</div>
						</c:if>
					</c:forEach>
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
	function submitAddForm() {
		document.addForm.submit();	
	}
	
	function submitUpdateForm(todoId) {
		document.getElementById("todoId").value = todoId;
		document.getElementById("taskName").value = document.getElementById("taskName" + todoId).value;
		document.updateForm.submit();	
	}
	
	function submitUpdateFormForDelete(todoId) {
		document.getElementById("todoId").value = todoId;
		document.getElementById("deleteFlag").value=true;
		document.updateForm.submit();	
	}
	
	function submitUpdateFormForCompleted(todoId) {
		document.getElementById("todoId").value = todoId;
		document.getElementById("completed").value = true;
		document.updateForm.submit();	
	}
	</script>
</body>
</html>