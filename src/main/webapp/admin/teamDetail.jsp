<%@page import="Model.Season"%>
<%@page import="AdminDao.SeasonAdminDao"%>
<%@page import="AdminDao.TeamAdminDao"%>
<%@page import="AdminDao.TeamDetailAdminDao"%>
<%@page import="Model.Team"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Team Detail</title>
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
			var idl=id.split("&")
			console.log(idl[0]+idl[1]);
			$(".s"+idl[0]).prop("selected", "selected");
			$(".t"+idl[1]).prop("selected", "selected");
			$(".idH").val(idl[2]);
			console.log(idl[2])
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
				<h2 class="m-0">Manager Team Detail</h2>
				<a href="#" class="mx-2 d-flex align-items-center"
					data-bs-toggle="modal" data-bs-target="#modalForm"> <i
					class="fa fa-plus-circle" aria-hidden="true"
					style="font-size: 40px;"></i></a>
			</div>
				<h3 class="text-danger">${err }</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>Id</th>
									<th>Id Season</th>
									<th>Id Team</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="a">
									<tr>
										<td>${a.id}</td>
										<td>${a.id_season}</td>
										<td>${a.id_team}</td>
										<td><a data-bs-toggle="modal"
											data-bs-target="#modalFormEdit" href="${a.id_season}&${a.id_team}&${a.id}"
											class="mx-2 edit"> <i class="fa fa-pencil-square-o"
												aria-hidden="true" style="font-size: 20px;"></i>
										</a> <a onclick="return confirm('Do you want to delete this ?')" href="DeleteTeamDetailAdmin?id_season=${a.id_season }&id_team=${a.id_team}" class="mx-2"> <i class="fa fa-trash-o"
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
	<%
		TeamAdminDao dao=new TeamAdminDao();
		List<Team>teams=dao.getAll();
		SeasonAdminDao sdao=new SeasonAdminDao();
		List<Season>seasons=sdao.getAll();
		
	%>
	<div class="modal fade" id="modalForm" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						ADD Team Detail In Season<span class="addError text-danger fs-5"></span>
					</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="addForm" action="AddTeamDetail	Admin" method="post">
							<div class="mb-3">
							<select class="form-control" name="id_season">
								<%
								for (int i = 0; i <seasons.size(); i++) {
								%>
								<option value="<%=seasons.get(i).getId()%>"><%=seasons.get(i).getYearS()%>-<%=seasons.get(i).getYearE()%> (Id= <%=teams.get(i).getId() %>)</option>
								<%
								}
								%>
							</select>
							</div>
							<div class="mb-3">
							<select class="form-control" name="id_team">
								<%
								for (int i = 0; i < teams.size(); i++) {
								%>
								<option value="<%=teams.get(i).getId()%>"><%=teams.get(i).getName()%> (Id= <%=teams.get(i).getId() %>)</option>
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
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">EDIT ACCOUNT</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="addForm" action="EditTeamDetailAdmin" method="post">
						<input type="hidden" name="id" class="idH"/>
						<div class="mb-3">
							<select class="form-control" name="id_season">
								<%
								for (int i = 0; i <seasons.size(); i++) {
								%>
								<option class="s<%=seasons.get(i).getId()%>" value="<%=seasons.get(i).getId()%>"><%=seasons.get(i).getYearS()%>-<%=seasons.get(i).getYearE()%> (Id= <%=teams.get(i).getId() %>)</option>
								<%
								}
								%>
							</select>
							</div>
							<div class="mb-3">
							<select class="form-control" name="id_team">
								<%
								for (int i = 0; i < teams.size(); i++) {
								%>
								<option class="t<%=teams.get(i).getId()%>" value="<%=teams.get(i).getId()%>"><%=teams.get(i).getName()%> (Id= <%=teams.get(i).getId() %>)</option>
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