<%@page import="Model.Comment"%>
<%@page import="Model.MatchDetail"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/matchDetail.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<style>
.detail-content {
	width: 60%;
	margin: 10px auto;
}

.detail-img img {
	width: 100%;
	height: 400px;
	object-fit: cover;
}

.score {
	margin: 0 auto;
	margin-bottom: 20px;
}

.score-content {
	padding: 0 10px;
	background-color: red;
	margin: 0 10px;
}

body.modal-open {
	overflow: hidden;
}
</style>
</head>
<body>
	<jsp:include page="support/header.jsp"></jsp:include>
	<!-- end header  -->
	<%
	List<MatchDetail> md = (List) request.getAttribute("md");
	String id_match = String.valueOf(md.get(0).getId_match());
	%>
	<div class="container" style="margin-top: 80px;">
		<div class="wrapper">
			<div class="s_bode">
				<div class="date position-absolute text-white"
					style="top: 0; left: 50%; transform: translateX(-50%);">
					<p><%=md.get(0).getDate()%></p>
				</div>
				<div class="left_section">
					<img src="<%=md.get(0).getLogo()%>" alt="">
					<h2><%=md.get(0).getName()%><span>(<%=md.get(0).getStatus() == 1 ? "Win" : "Loss"%>)
						</span>
					</h2>

					<c:forEach items="${pd1}" var="p1">
						<p>
							${p1.name} <span>(${p1.minute}')</span>
						</p>
					</c:forEach>

				</div>

				<div class="mid_section">
					<h1><%=md.get(0).getScore()%>
						-
						<%=md.get(1).getScore()%></h1>
				</div>
				<div class="right_section">
					<img src="<%=md.get(1).getLogo()%>" alt="">
					<h2><%=md.get(1).getName()%><span>(<%=md.get(1).getStatus() == 1 ? "Win" : "Loss"%>)
						</span>
					</h2>
					<c:forEach items="${pd2}" var="p2">
						<p>
							${p2.name} <span>(${p2.minute}')</span>
						</p>
					</c:forEach>
				</div>
			</div>
		</div>

		<div class="wrapper-comment">
			<section style="background-color: #eee;">
				<div class="container p-0 my-5 py-5">
					<div class="row d-flex justify-content-center">
						<div class="col-md-12 col-lg-10 col-xl-8">
							<div class="card">
								<form action="AddCommentServlet" method="post">
									<div class="card-footer py-3 border-0"
										style="background-color: #f8f9fa;">
										<div class="d-flex flex-start w-100">
											<img class="rounded-circle shadow-1-strong me-3"
												src="${sessionScope.user.img}" alt="avatar" width="40"
												height="40" />
											<div class="form-outline w-100">
												<textarea class="form-control" name="comment"
													id="textAreaExample" rows="2" style="background: #fff;"
													required="required"></textarea>
												<input type="hidden" name="id_match" value="<%=id_match%>" />
												<input type="hidden" name="url"
													value="${requestScope['javax.servlet.forward.request_uri']}?<%=request.getQueryString() %>" />
												<label class="form-label" for="textAreaExample">Your
													Comment</label>
											</div>
										</div>
										<div class="float-end mt-2 pt-1">
											<button type="submit" class="btn btn-primary btn-sm">Post
												comment</button>
											<button type="button" class="btn btn-outline-primary btn-sm">Cancel</button>
										</div>
									</div>
								</form>
								<%
								List<Comment> a = (List) request.getAttribute("currentUser");
								if (a != null)
									for (int i = 0; i < a.size(); i++) {
								%>

								<div class="card-body">
									<div class="d-flex flex-start align-items-center">
										<img class="rounded-circle shadow-1-strong me-3"
											src="<%=a.get(i).getImg()%>" alt="avatar" width="60"
											height="60" />
										<div>
											<h6 class="fw-bold text-primary mb-1"><%=a.get(i).getFullName()%></h6>
											<p class="text-muted small mb-0"><%=a.get(i).getDate()%></p>
										</div>
									</div>
									<p class="mt-3 mb-4 pb-2" data-target="content<%=a.get(i).getId()%>"><%=a.get(i).getContent()%></p>
									<div class="small d-flex justify-content-start">
										<a href="#" class="d-flex align-items-center me-3 text-decoration-none"
											data-role="edit" data-id="<%=a.get(i).getId()%>" style="font-weight: 600;"> <i
											class="far fa-thumbs-up me-2"></i>
											<p class="mb-0">Edit</p>
										</a>
										<form action="DeleteCommentServlet" method="post">
											<input type="hidden" name="id" value="<%=a.get(i).getId()%>" /> <input
												type="hidden" name="url"
												value="${requestScope['javax.servlet.forward.request_uri']}?<%=request.getQueryString() %>" />
											<input onclick="return confirm('Do you want to delete!')" type="submit" value="Delete"
												style="border: none; outline: none; background-color: white; color: #0d6efd; font-weight: 600;" />
										</form>
									</div>
								</div>
								<%
								}
								%>


								<%
								List<Comment> o = (List) request.getAttribute("otherUser");
								if (o != null)
									for (int i = 0; i < o.size(); i++) {
								%>

								<div class="card-body">
									<div class="d-flex flex-start align-items-center">
										<img class="rounded-circle shadow-1-strong me-3"
											src="<%=o.get(i).getImg()%>" alt="avatar" width="60"
											height="60" />
										<div>
											<h6 class="fw-bold text-primary mb-1"><%=o.get(i).getFullName()%></h6>
											<p class="text-muted small mb-0"><%=o.get(i).getDate()%></p>
										</div>
									</div>
									<p class="mt-3 mb-4 pb-2">
										<%=o.get(i).getContent()%></p>

								</div>
								<%
								}
								%>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<!-- Modal Edit Comment -->
	<div class="modal fade" id="ModalEdit" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Edit Comment</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<input type="text" id="content"
						style="width: 100%; outline: none; padding: 5px;" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button id="save" type="button" class="btn btn-primary">Save
						changes</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="support/footer.jsp"></jsp:include>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
		integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
		crossorigin="anonymous"></script>
</body>
<script type="text/javascript" src="js/comment.js"></script>
</html>