<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Team</title>
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
				url : 'EditTeamAdmin',
				data : {
					id : id
				},
				success : function(res) {
					var list = res.split(":");
					console.log(list);
					$("#idE").val(list[0])
					$("#nameE").val(list[1])
					$("#nameAE").val(list[2])
					$("#desE").val(list[5])
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
				<h2 class="m-0">Manager Team</h2>
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
									<th>Name</th>
									<th>Name Arena</th>
									<th>Logo</th>
									<th>Image Arena</th>
									<th>Description</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="a">
									<tr>
										<td>${a.id }</td>
										<td>${a.name}</td>
										<td>${a.arena }</td>
										<td><img src="../${a.logo }" alt=""
											style="width: 50px; height: 50px; border-radius:50%;" /></td>
										<td><img src="../${a.img_arena }" alt=""
											style="width: 50px; height: 50px; " /></td>
										<td><p
												style="overflow: hidden; text-overflow: ellipsis; display: -webkit-box; -webkit-line-clamp: 2; /* number of lines to show */ line-clamp: 2; -webkit-box-orient: vertical;">${a.description}</p></td>
										<td><a data-bs-toggle="modal"
											data-bs-target="#modalFormEdit" href="${a.id}"
											class="mx-2 edit"> <i class="fa fa-pencil-square-o"
												aria-hidden="true" style="font-size: 20px;"></i>
										</a> <a
											onclick="return confirm('Do you want to delete this team ?')"
											href="DeleteTeamAdmin?id=${a.id }" class="mx-2"> <i
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
	<div class="modal fade" id="modalForm" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						ADD TEAM<span class="addError text-danger fs-5"></span>
					</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="addForm" action="AddTeamAdmin" method="post"
						enctype="multipart/form-data">
						<div class="mb-3">
							<label class="form-label">Name</label> <input type="text"
								class="form-control" name="name" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Name Arena</label> <input type="text"
								class="form-control" name="nameArena" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Logo</label> <input accept="image/png, image/jpeg" type="file"
								class="form-control" name="logo" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Image Arena</label> <input accept="image/png, image/jpeg" type="file"
								class="form-control" name="imgArena" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Description</label> <input type="text"
								class="form-control" name="description" required />
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
					<h5 class="modal-title" id="exampleModalLabel">EDIT TEAM</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="addForm" action="EditTeamAdmin" method="post">
						<div class="mb-3">
							<label class="form-label">Id</label> <input id="idE" readonly type="number"
								class="form-control" name="id" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Name</label> <input id="nameE" type="text"
								class="form-control" name="name" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Name Arena</label> <input id="nameAE" type="text"
								class="form-control" name="nameArena" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Logo</label> <input id="logoE" type="file"
								class="form-control" name="logo" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Image Arena</label> <input id="imgAE" type="file"
								class="form-control" name="imgArena" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Description</label> <input id="desE" type="text"
								class="form-control" name="description" required />
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