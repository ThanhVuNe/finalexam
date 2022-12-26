
<div class="wrapper d-flex align-items-stretch">
	<nav id="sidebar" style="background-color: darkslategrey; top:0;bottom:0;overflow-y:scroll">
		<div class="p-4 pt-1">
			<a href="home.jsp" class="img logo rounded-circle mb-5"
				style="background-image: url(https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png);"></a>
			<h2 class="text-center font-weight-bold text-white">Tran Thanh
				Vu</h2>
			<ul class="list-unstyled components mb-5">
				<li class="${active}"><a href="AccountAdmin">Account</a></li>
				<li class="${active1}"><a href="UserAdmin">User</a></li>
				<li class="${active2}"><a href="SeasonAdmin">Season</a></li>
				<li class="${active3}"><a href="TeamAdmin">Team</a></li>
				<li class="${active33}"><a href="TeamDetailAdmin">Team Detail</a></li>
				<li class="${active4}"><a href="MatchAdmin">Match</a></li>
				<li class="${active5}"><a href="MatchDetailAdmin">Match Detail</a></li>
				<li class="${active6}"><a href="CommentAdmin">Comment</a></li>
				<li class="${active7}"><a href="PlayerAdmin">Player</a></li>
				<li s><a href="LogoutAdmin"
					onclick="return confirm('Do you want to log out')">Logout</a></li>
			</ul>

			<div class="footer">
				<p>Please contact Tran Thanh Vu for work 0702489382
					
				</p>
			</div>

		</div>
	</nav>
	<button type="button" id="sidebarCollapse" class="btn btn-primary"
		style="height: 40px;">
		<i class="fa fa-bars"></i> <span class="sr-only">Toggle Menu</span>
	</button>