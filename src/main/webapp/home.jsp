<%@page import="Model.Match"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<style>
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

.swiper {
	width: 100%;
	height: auto;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;
	/* Center slide text vertically */
	display: -webkit-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	-webkit-justify-content: center;
	justify-content: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	-webkit-align-items: center;
	align-items: center;
}

.swiper-slide img {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.col {
	margin: 0 20px;
}

.wrapper img {
	height: 200px;
	width: 80%;
	margin: 0 auto;
	object-fit: contain;
}

.next, .prev {
	color: gray;
	opacity: .4;
}

h2 {
	display: inline-block;
	padding: 10px;
}

h2:hover {
	background-color: whitesmoke;
}

.img-match {
	height: 150px;
}

.two-img img {
	width: 48px;
	height: 48px;
	border-radius: 50%;
}
</style>
<title>HOME</title>

</head>

<body>

	<jsp:include page="support/header.jsp"></jsp:include>
	<!-- end header  -->

	<!-- body  -->
	<div class="container p-5"
		style="background-color: darkgray; margin-top: 80px;">
		<div class="team">
			<img
				src="https://s.bundesliga.com/assets/img/30000/27160_imgw968.png"
				alt="" style="width: 100%;">
		</div>
		<a href="TeamServlet" class="text-decoration-none text-muted">
			<h2>
				TEAM... <i class="fa-solid fa-arrow-right"></i>
			</h2>
		</a>
		<div class="row" style="display: flex; margin-bottom: 40px;">
			<div class="swiper mySwiper">
				<div class="swiper-wrapper">
					<c:forEach items="${teams}" var="team">
						<div class="swiper-slide">
							<div class="wrapper">
								<img src="${team.logo}" alt="">
								<h2>${team.name}</h2>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="swiper-button-next next"></div>
				<div class="swiper-button-prev prev"></div>
				<div class="swiper-pagination"></div>
			</div>

		</div>


		<a href="MatchServlet" class="text-decoration-none text-muted">
			<h2>
				MATCH... <i class="fa-solid fa-arrow-right"></i>
			</h2>
		</a>
		<div class="row" style="display: flex; margin-bottom: 40px;">
			<div class="swiper mySwiper">
				<div class="swiper-wrapper">
					<%
					List<Match> matchs = (List) request.getAttribute("matchs");
					for (int i = 0; i < matchs.size() - 1; i += 2) {
					%>
					<div class="swiper-slide">
						<div class="wrapper">
							<img class="img-match" src="images/logo/bundesliga.png" alt="">
							<div class="two-img d-flex mb-3">
								<img src="<%=matchs.get(i).getLogo()%>" alt="">
								<p class="fs-4 m-0 lh-lg">VS</p>
								<img src="<%=matchs.get(i + 1).getLogo()%>" alt="">
							</div>
							<h4><%=matchs.get(i).getScore()%>-<%=matchs.get(i + 1).getScore()%></h4>
						</div>
					</div>
					<%
					}
					%>
				</div>
				<div class="swiper-button-next next"></div>
				<div class="swiper-button-prev prev"></div>
				<div class="swiper-pagination"></div>
			</div>

		</div>
	</div>


	<!-- end body  -->

	<jsp:include page="support/footer.jsp"></jsp:include>

	<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>

	<!-- Initialize Swiper -->
	<script>
		var swiper = new Swiper(".mySwiper", {
			slidesPerView : 3,
			spaceBetween : 30,
			slidesPerGroup : 3,
			loop : true,
			loopFillGroupWithBlank : true,
			pagination : {
				el : ".swiper-pagination",
				clickable : true,
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},
		});
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>

</html>