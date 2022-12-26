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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<style>
	#content{
		margin-left:230px;
	}
	#sidebar{
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
			<section style="background-color: #eee;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center">
      <div class="col-md-12 col-xl-4">

        <div class="card" style="border-radius: 15px;">
          <div class="card-body text-center">
            <div class="mt-3 mb-4">
              <img src="../${sessionScope.user.img}"
                class="rounded-circle img-fluid" style="width: 100px;" />
            </div>
            <h4 class="mb-2">${sessionScope.user.name}</h4>
            <p class="text-muted mb-4">@Programmer 
              </p>
            <div class="mb-4 pb-2">
              <button type="button" class="btn btn-outline-primary btn-floating">
                <i class="fab fa-facebook-f fa-lg"></i>
              </button>
              <button type="button" class="btn btn-outline-primary btn-floating">
                <i class="fab fa-twitter fa-lg"></i>
              </button>
              <button type="button" class="btn btn-outline-primary btn-floating">
                <i class="fab fa-skype fa-lg"></i>
              </button>
            </div>
            <button type="button" class="btn btn-primary btn-rounded btn-lg">
              Message now
            </button>
          </div>
        </div>

      </div>
    </div>
  </div>
</section>
		</div>
		<jsp:include page="support/footer.jsp"></jsp:include>
		
</body>
</html>