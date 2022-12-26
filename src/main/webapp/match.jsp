<%@page import="Model.Match"%>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
        integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    </script>
    <style>
        .logo {
            width: 50%;
            object-fit: cover;
        }

        .card {
            height: 100%;
        }

        .img-detail img {
            width: 100%;
            height: 200px;
        }

        .two-img {
            width: 50%;
        }

        .two-img img {
            width: 48px;
            height: 48px;
            border-radius: 50%;
        }
    </style>
</head>
<body>
 	<jsp:include page="support/header.jsp"></jsp:include>
    <!-- end header  -->

    <!-- body -->
  <div class=" container list-select d-flex"
		style="margin-top: 80px;">
		<!-- <form action="MatchServlet" method="get">
			<label for="cars">Choose method sort:</label> <select
				name="sort" id="cars">
				<option value="inc">Sort by name increasing</option>
				<option value="dec">Sort by name decreasing</option>
			</select>
		</form> -->
		<form action="MatchServlet">
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
		<%
			List<Match>matchs=(List)request.getAttribute("matchs");
		
		%>
                    <c:if test="${empty matchs}">
							<h3 class="text-center mb-3">NOT FOUND</h3>
						</c:if>	
						<%
							for(int i=0;i<matchs.size()-1;i+=2){
						%>
                        <div class="col-md-12 col-lg-4 mb-4 ">
                            <div class="card text-black">
                                <div class="card-body">
                                    <div class="text-center mb-2">
                                        <img class="logo"
                                            src="images/logo/bundesliga.png"
                                            alt="">
                                    </div>
                                    <div class="text-center mt-1">
                                        <h4 class="card-title fw-bold text-uppercase text-muted"><%=matchs.get(i).getName()%></h4>
                                    </div>
                                    <div class="text-center mb-3">
                                        <div class="two-img d-flex m-auto justify-content-between">
                                            <img src="<%=matchs.get(i).getLogo() %>"
                                                alt="">
                                            <p class="fs-4 m-0 lh-lg">VS</p>
                                            <img src="<%=matchs.get(i+1).getLogo() %>"
                                                alt="">
                                        </div>
                                    </div>
                                    <div class="text-center mt-1">
                                        <h4 class="card-title fw-bold text-uppercase text-muted"><%=matchs.get(i+1).getName() %></h4>
                                    </div>
                                    <div class="d-flex flex-row justify-content-center">
                                        <a href="MatchDetailServlet?id_match=<%=matchs.get(i).getId_match() %>&id_team1=<%=matchs.get(i).getId_team() %>&id_team2=<%=matchs.get(i+1).getId_team() %>" class="btn btn-primary">VIEW DETAIL</a>
                                    </div>
                                </div>
                            </div>
                        </div>
						<%} %>
                    </div>
                    <!-- pagination -->
                <nav class="d-flex" aria-label="Page navigation example">
						<ul class="pagination m-auto">
							<!-- <li class="page-item"><a class="page-link" href="#">Previous</a></li> -->
								<c:forEach var="i" begin="1" end="${pageSize}">
								<li class="page-item">
									<a class="page-link" href="MatchServlet?page=${i}&search=${valueSearch}">
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

    <jsp:include page="support/footer.jsp"></jsp:include>
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
        integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
        crossorigin="anonymous"></script>
</body>
</html>