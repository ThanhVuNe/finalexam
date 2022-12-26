<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>ADMIN</title>
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
				url : 'EditAccountAdmin',
				data : {
					id : id
				},
				success : function(res) {
					var list = res.split("/");
					$("#idE").val(list[0])
					$("#emailE").val(list[1])
					$("#passE").val(list[2])
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
				<h2 class="m-0">Manager Account</h2>
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
									<th>Email</th>
									<th>Password</th>
									<th>Role</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="a">
									<tr>
										<td>${a.id }</td>
										<td>${a.email}</td>
										<td>${a.password }</td>
										<td>User</td>
										<td><a data-bs-toggle="modal"
											data-bs-target="#modalFormEdit" href="${a.id}"
											class="mx-2 edit"> <i class="fa fa-pencil-square-o"
												aria-hidden="true" style="font-size: 20px;"></i>
										</a> <a onclick="return confirm('Do you want to delete this account ?')" href="DeleteAccountAdmin?id=${a.id }" class="mx-2"> <i class="fa fa-trash-o"
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
					<form id="addForm" action="AddAccountAdmin" method="post">
						<div class="mb-3">
							<label class="form-label">Email</label> <input type="text"
								class="form-control" id="title" name="email" placeholder="Email"
								required />
						</div>
						<div class="mb-3">
							<label class="form-label">password</label> <input type="password"
								class="form-control" id="des" name="password"
								placeholder="password" required />
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
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">EDIT ACCOUNT</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="addForm" action="EditAccountAdmin" method="post">
						<div class="mb-3">
							<label class="form-label">ID</label> <input readonly type="text"
								class="form-control" id="idE" name="id" />
						</div>
						<div class="mb-3">
							<label class="form-label">Email</label> <input type="text"
								class="form-control" id="emailE" name="email" required />
						</div>
						<div class="mb-3">
							<label class="form-label">password</label> <input type="password"
								class="form-control" id="passE" name="password" required />
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