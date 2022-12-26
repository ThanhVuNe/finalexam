<%@page import="Model.User"%>
<%@page import="AdminDao.UserAdminDao"%>
<%@page import="Model.MatchModel"%>
<%@page import="java.util.List"%>
<%@page import="AdminDao.MatchAdminDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Comment</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	$(document).ready(function() {
		$(".edit").click(function(e) {
			var id = $(this).attr('href');
			console.log(id);
			$.ajax({
				url : 'EditCommentAdmin',
				data : {
					id : id
				},
				success : function(res) {
					var list = res.split("/");
					$("#idE").val(list[0])
					$("#contentE").val(list[1])
					$(".m"+list[2]).prop("selected", "selected");
					$(".u"+list[3]).prop("selected", "selected");
					$("#dateE").val(list[4]);
					
				}
			})
		})

	});
</script>
<style>
	#content{
		 margin-left:230px; 
	}
	#sidebar{
		position: fixed;
	}
</style>
</head>
<body>
	<jsp:include page="support/header.jsp"></jsp:include>
	<div id="content" class="p-4 p-md-5">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<h2>WELCOME ADMIN THANH VU</h2>

		</nav>
		<div class="container">
			<div class="d-flex">
				<h2 class="m-0">Manager Comment</h2>
				<a href="#" class="mx-2 d-flex align-items-center"
					data-bs-toggle="modal" data-bs-target="#modalForm"> <i
					class="fa fa-plus-circle" aria-hidden="true"
					style="font-size: 40px;"></i></a>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>Id</th>
									<th>Content</th>
									<th>Id match</th>
									<th>Id user</th>
									<th>Date</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="a">
									<tr>
										<td>${a.id}</td>
										<td>${a.content}</td>
										<td>${a.id_match}</td>
										<td>${a.id_user}</td>
										<td>${a.date}</td>
										<td> <a data-bs-toggle="modal"
											data-bs-target="#modalFormEdit" href="${a.id }" 
											class="mx-2 edit"> <i class="fa fa-pencil-square-o"
												aria-hidden="true" style="font-size: 20px;"></i>
										</a> <a href="DeleteCommentAdmin?id=${a.id}" class="mx-2"> <i
												class="fa fa-trash-o" aria-hidden="true"
												style="font-size: 20px;"></i>
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- modal ADD  -->
	<%
		MatchAdminDao dao=new MatchAdminDao();
		List<MatchModel>listm=dao.getAll();
		UserAdminDao udao=new UserAdminDao();
		List<User>listu=udao.getAll();
	%>
	<div class="modal fade" id="modalForm" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						ADD COMMENT<span class="addError text-danger fs-5"></span>
					</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="addForm" action="AddCommentAdmin" method="post">
						<div class="mb-3">
							<label class="form-label">Content</label> <input type="text"
								class="form-control" name="content" placeholder="Content"
								required />
						</div>
						
							<div class="mb-3">
							<select class="form-control" name="id_match">
								<%
								for (int i = 0; i < listm.size(); i++) {
								%>
								<option value="<%=listm.get(i).getId()%>"><%=listm.get(i).getDate()%></option>
								<%
								}
								%>
							</select>
						</div>
							<div class="mb-3">
							<select class="form-control" name="id_user">
								<%
								for (int i = 0; i < listu.size(); i++) {
								%>
								<option value="<%=listu.get(i).getId()%>"><%=listu.get(i).getName()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Date</label> <input type="datetime-local"
								class="form-control" id="des" name="date"
								 required />
						</div>
						<div class="modal-footer d-block text-center">
							<button type="submit" class="btn btn-warning">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end modal add  -->
	
	<div class="modal fade" id="modalFormEdit" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						EDIT COMMENT<span class="addError text-danger fs-5"></span>
					</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="addForm" action="EditCommentAdmin" method="post">
					<input type="hidden" id="idE" name="id"/>
						<div class="mb-3">
							<label class="form-label">Content</label> <input type="text"
								class="form-control" id="contentE" name="content" 
								required />
						</div>
						
							<div class="mb-3">
							<label class="form-label">Match Date</label>
							<select class="form-control" name="id_match">
								<%
								for (int i = 0; i < listm.size(); i++) {
								%>
								<option class="m<%=listm.get(i).getId()%>" value="<%=listm.get(i).getId()%>"><%=listm.get(i).getDate()%></option>
								<%
								}
								%>
							</select>
						</div>
							<div class="mb-3">
							<label class="form-label">User</label>
							<select class="form-control" name="id_user">
								<%
								for (int i = 0; i < listu.size(); i++) {
								%>
								<option class="u<%=listu.get(i).getId()%>" value="<%=listu.get(i).getId()%>"><%=listu.get(i).getName()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Date</label> <input type="datetime-local"
								class="form-control" id="dateE" name="date"
								 required />
						</div>
						<div class="modal-footer d-block text-center">
							<button type="submit" class="btn btn-warning">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end modal edit -->
	
	<jsp:include page="support/footer.jsp"></jsp:include>

</body>
</html>