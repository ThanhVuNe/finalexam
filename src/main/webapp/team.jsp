<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
	integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<style>
.logo {
	width: 50%;
	height: 150px;
	object-fit: contain;
}

.card {
	height: 100%;
}

.img-detail img {
	width: 100%;
	height: 200px;
}

.form-white.input-group>.form-control:focus {
	border-color: #fff;
	box-shadow: inset 0 0 0 1px #fff;
}

.navbar-dark .navbar-nav .nav-link {
	color: #fff;
}

.navbar-dark .navbar-nav .nav-link:hover, .navbar-dark .navbar-nav .nav-link:focus
	{
	color: rgba(255, 255, 255, 0.75);
}
</style>
<script>
	$(document).ready(function() {
		$(".idTeam").click(function() {
			var id = $(this).val();
			console.log(id)
			 $.ajax({
				method: "GET",
				url : 'ViewDetailTeamServlet',
				data : {
					id : id
				},
				success : function(res) {
					$(".view").html(res)
				}
			})
		})

	});
</script>
</head>

<body>
	<!-- Navbar -->
	<jsp:include page="support/header.jsp"></jsp:include>
	<!-- Navbar -->

	<!-- body -->
	<div class=" container list-select d-flex"
		style="margin-top: 80px;">
		<!-- <form action="TeamServlet" method="get">
			<label for="cars">Choose method sort:</label> <select
				name="sort" id="cars">
				<option value="inc">Sort by name increasing</option>
				<option value="dec">Sort by name decreasing</option>
			</select>
		</form> -->
		<form action="TeamServlet">
			<div class="input-group">
				<input type="search" class="form-control rounded"
					placeholder="Search by name" aria-label="Search"
					aria-describedby="search-addon" name="search"
					value="${valueSearch}"/> <input type="submit"
					class="btn btn-outline-primary" value="Search" />

			</div>
		</form>
	</div>
	<div class="wrapper ">
		<div class="container">
			<section style="background-color: #eee;">
				<div class="container py-5">
					<div class="row">
						<c:if test="${empty teams}">
							<h3 class="text-center mb-3">NOT FOUND</h3>
						</c:if>
						<c:forEach items="${teams}" var="team">
							<div class="col-md-12 col-lg-4 mb-4 ">
								<div class="card text-black">
									<div class="card-body">
										<div class="text-center mb-2">
											<img class="logo" src="${team.logo}" alt="">
										</div>
										<div class="text-center mt-1">
											<h4 class="card-title fw-bold text-uppercase">${team.name}</h4>
										</div>

										<div class="d-flex flex-row">
											<button value="${team.id}" type="button"
												class="edit btn btn-primary flex-fill me-1 idTeam"
												data-mdb-ripple-color="dark" data-bs-toggle="modal"
												data-bs-target="#modalFormEdit">VIEW DETAIL</button>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- pagination -->
					<nav class="d-flex" aria-label="Page navigation example">
						<ul class="pagination m-auto">
							<!-- <li class="page-item"><a class="page-link" href="#">Previous</a></li> -->
								<c:forEach var="i" begin="1" end="${pageSize}">
								<li class="page-item">
									<a class="page-link" href="TeamServlet?page=${i}&search=${valueSearch}">
										${i}
									</a>
								</li>
								</c:forEach>								
							<!-- <li class="page-item"><a class="page-link" href="#">Next</a></li> -->
						</ul>
					</nav>
					<!-- end pagination -->
				</div>
			</section>
		</div>
	</div>

	<!-- end body  -->



	<!-- modal edit  -->
	<div class="modal fade" id="modalFormEdit" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h5 class="modal-title" id="exampleModalLabel">TEAM DETAIL</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body view">
				
				</div>
			</div>
		</div>
	</div>
	<!-- modal edit  -->

	<jsp:include page="support/footer.jsp"></jsp:include>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<!-- <script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.js"></script> -->
</body>

</html>