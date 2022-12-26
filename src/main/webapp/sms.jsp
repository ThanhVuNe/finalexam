<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js" />
<style>
.card {
	width: 350px;
	padding: 10px;
	border-radius: 20px;
	background: #fff;
	border: none;
	height: 350px;
	position: relative;
}

.container {
	height: 100vh;
}

body {
	background: #eee;
}

.mobile-text {
	color: #989696b8;
	font-size: 15px;
}

.form-control {
	margin-right: 12px;
}

.form-control:focus {
	color: #495057;
	background-color: #fff;
	border-color: #ff8880;
	outline: 0;
	box-shadow: none;
}

.cursor {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="text-center mb-5"><h3
					class="font-weight-bold text-danger cursor">${mess}</h3>
			</div>
	<div class="d-flex justify-content-center align-items-center container">
		
		<div class="card py-5 px-3">
			<h5 class="m-0">Mobile phone verification</h5>
			<span class="mobile-text">Enter the code we just send on your
				email </span>
			<form action="CheckSmsServlet" method="post">
				<div class="d-flex flex-row mt-2">
					<input type="hidden" value="${email}"/>
					<input type="text" name="otp1" class="form-control" autofocus="">
					<input type="text" name="otp2" class="form-control"> <input
						type="text" name="otp3" class="form-control"> <input
						type="text" name="otp4" class="form-control"> <input
						type="text" name="otp5" class="form-control"> <input
						type="text" name="otp6" class="form-control"><br />
				</div>
				<div class="text-center mt-5">
						<input type="submit" class="btn btn-primary" value="submit" />
					</div>
			</form>
			<div class="text-center mt-5">
				<span class="d-block mobile-text">Don't receive the code?</span><span
					class="font-weight-bold text-danger cursor">Resend</span>
			</div>
		</div>
	</div>
</body>
</html>