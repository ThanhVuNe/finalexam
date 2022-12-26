<%@page import="Model.Account"%>
<%@page import="java.util.List"%>
<%@page import="AdminDao.AccountAdminDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>USER</title>
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
				url : 'EditUserAdmin',
				data : {
					id : id
				},
				success : function(res) {
					var list = res.split(">");
					$("#idE").val(list[0])
					$("#nameE").val(list[1])
					$("#ageE").val(list[2])
					$(".l"+list[4]).prop("selected", "selected");
					console.log(list);
				}
			})
		})

	});
</script>
<style>
#content {
	 margin-left: 230px;
}

#sidebar {
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
				<h2 class="m-0">Manager User</h2>
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
									<th>Fullname</th>
									<th>Age</th>
									<th>Image</th>
									<th>Id_account</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="a">
									<tr>
										<td>${a.id }</td>
										<td>${a.name}</td>
										<td>${a.age }</td>
										<td><img src="../${a.img }" alt=""
											style="width: 50px; height: 50px; border-radius:50%;" /></td>
										<td>${a.id_account }</td>
										<td><a data-bs-toggle="modal"
											data-bs-target="#modalFormEdit" href="${a.id}"
											class="mx-2 edit"> <i class="fa fa-pencil-square-o"
												aria-hidden="true" style="font-size: 20px;"></i>
										</a> <a onclick="return confirm('Do you want to delete this user ?')" href="DeleteUserAdmin?id=${a.id }" class="mx-2"> <i class="fa fa-trash-o"
												aria-hidden="true" style="font-size: 20px;"></i>
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

	<%	
		AccountAdminDao dao=new AccountAdminDao();
		List<Account>list=dao.getAll();
	%>
	<!-- modal ADD  -->
	<div class="modal fade" id="modalForm" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						ADD ACCOUNT<span class="addError text-danger fs-5"></span>
					</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="addForm" action="AddUserAdmin" method="post" enctype="multipart/form-data">
						<div class="mb-3">
							<label class="form-label">Fullname</label> <input type="text"
								class="form-control" id="title" name="fullname" placeholder="Fullname"
								required />
						</div>
						<div class="mb-3">
							<label class="form-label">Age</label> <input type="number"
								class="form-control" id="des" name="age"
								placeholder="Age" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Image</label> <input accept="image/png, image/jpeg" type="file"
								class="form-control" id="des" name="img"
								required />
						</div>
						<div class="mb-3">
						<label class="form-label">Account</label>
							<select class="form-control" name="id_account">
								<%
								for (int i = 0; i < list.size(); i++) {
								%>
								<option value="<%=list.get(i).getId()%>"><%=list.get(i).getEmail()%></option>
								<%
								}
								%>
							</select>
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

	<!-- modal edit  -->
	<div class="modal fade" id="modalFormEdit" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						EDIT ACCOUNT<span class="addError text-danger fs-5"></span>
					</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="addForm" action="AddUserAdmin" method="post" enctype="multipart/form-data">
					<input type="hidden" id="idE"/>
						<div class="mb-3">
							<label class="form-label">Fullname</label> <input type="text"
								class="form-control" id="nameE" name="fullname" placeholder="Fullname"
								required />
						</div>
						<div class="mb-3">
							<label class="form-label">Age</label> <input type="number"
								class="form-control" id="ageE" name="age"
								placeholder="Age" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Image</label> <input accept="image/png, image/jpeg" type="file"
								class="form-control" id="des" name="img"
								required />
						</div>
						<div class="mb-3">
						<label class="form-label">Account</label>
							<select class="form-control" name="id_account">
								<%
								for (int i = 0; i < list.size(); i++) {
								%>
								<option class="l<%=list.get(i).getId()%>" value="<%=list.get(i).getId()%>"><%=list.get(i).getEmail()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div class="modal-footer d-block text-center">
							<button type="submit" class="btn btn-warning">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- modal edit  -->

	 <jsp:include page="support/footer.jsp"></jsp:include>

</body>
</html>