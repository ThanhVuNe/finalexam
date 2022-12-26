<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Season</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
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
				<h2 class="m-0">Manager Season</h2>
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
									<th>Year Start</th>
									<th>Year End</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="a">
									<tr>
										<td>${a.id }</td>
										<td>${a.yearS}</td>
										<td>${a.yearE }</td>
										<td> <a onclick="return confirm('Do you want to delete this season ?')" href="DeleteSeasonAdmin?id=${a.id}" class="mx-2"> <i
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
						ADD SEASON<span class="addError text-danger fs-5"></span>
					</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="addForm" action="AddSeasonAdmin" method="post">
						<div class="mb-3">
							<label class="form-label">YEAR START</label> <input min=2015 type="number"
								class="form-control yearS" name="yearS" 
								required />
						</div>
						<div class="mb-3">
							<label class="form-label">YEAR END</label> <input readonly type="number"
								class="form-control yearE" name="yearE"
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
	
	<script>
		var yearS=document.querySelector(".yearS");
		var yearE=document.querySelector(".yearE");
		yearS.addEventListener('input', function(){
			yearE.value=parseInt(yearS.value)+1;
			console.log(yearE);
		});
	</script>
	<jsp:include page="support/footer.jsp"></jsp:include>

</body>
</html>