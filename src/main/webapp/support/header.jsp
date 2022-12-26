<!-- Navbar -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-dark position-fixed top-0 start-0 end-0 "
		style="z-index: 99;">
		<div class="container">
			<a class="navbar-brand text-white" href="HomeServlet">HOME</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item mx-5"><a class="nav-link text-white"
						aria-current="page" href="TeamServlet">TEAM</a></li>
					<li class="nav-item"><a class="nav-link text-white"
						href="MatchServlet">MATCH</a></li>
				</ul>

				<div class="dropdown me-5">
					<button class="btn dropdown-toggle text-white" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">
						<img style="width: 30px; height: 30px; border-radius: 50%;"
							src="${sessionScope.user.img}"
							alt="">
					</button>
					<ul class="dropdown-menu me-5" style="left: -50px;">
						<li><a class="dropdown-item" href="profile.jsp">Profile</a></li>
						<li><a class="dropdown-item" href="season.jsp">Season</a></li>
						<li><a class="dropdown-item" href="LogoutServlet">LOG OUT</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<!-- Navbar -->