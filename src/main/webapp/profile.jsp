<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');

* {
	padding: 0;
	margin: 0;
	font-family: 'Poppins', sans-serif
}

.container {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #eee
}

.card {
	width: 350px;
	height: auto;
	background-color: #fff;
	box-shadow: 0px 15px 30px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	overflow: hidden
}

.card .info {
	padding: 15px;
	display: flex;
	justify-content: space-between;
	border-bottom: 1px solid #e1dede;
	background-color: #e5e5e5
}

.card .info button {
	height: 30px;
	width: 80px;
	border: none;
	color: #fff;
	border-radius: 4px;
	background-color: #000;
	cursor: pointer;
	text-transform: uppercase
}

.card .forms {
	padding: 15px
}

.card .inputs {
	display: flex;
	flex-direction: column;
	margin-bottom: 10px
}

.card .inputs span {
	font-size: 12px
}

.card .inputs input {
	height: 40px;
	padding: 0px 10px;
	font-size: 17px;
	box-shadow: none;
	outline: none
}

.card .inputs input[type="text"][readonly] {
	border: 2px solid rgba(0, 0, 0, 0)
}

.card .inputs input[type="number"][readonly] {
	border: 2px solid rgba(0, 0, 0, 0)
}

.hidden {
	display: none;
}
</style>
</head>
<body>

	<div class="container" style="position: relative;">
		<a class="btn btn-primary" href="HomeServlet"
			style="position: absolute; left: 0; top:0;">GO BACK</a>
		<div class="card">
			<div class="info">
				<span>Edit user</span>
				<button id="savebutton">edit</button>
			</div>
			<div class="forms">
				<form action="EditProfileServlet" method="post"
					enctype="multipart/form-data">
					<div class="image d-flex justify-content-center">
						<img style="height: 250px; width: 250px; border-radius: 50%;"
							src="${sessionScope.user.img}" alt="">
					</div>

					<div class="inputs">
						<span>Image (Please choose file png, jpeg)</span> <input
							name="image" class="hidden" type="file" readonly value="John"
							accept="image/png, image/jpeg">
					</div>
					<div class="inputs">
						<span>Full name</span> <input type="text" name="name" readonly
							value="${sessionScope.user.name}" required>
					</div>
					<div class="inputs">
						<span>Age</span> <input type="number" name="age" readonly
							value="${sessionScope.user.age}" required>
					</div>
					<div class="submit text-center hidden">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		var savebutton = document.getElementById('savebutton');
		var readonly = true;
		var inputs = document.querySelectorAll('.inputs input');
		savebutton.addEventListener('click', function() {
			for (var i = 0; i < inputs.length; i++) {
				inputs[i].toggleAttribute('readonly');
			}
			;

			if (savebutton.innerHTML == "edit") {
				savebutton.innerHTML = "unedit";
			} else {
				savebutton.innerHTML = "edit";
			}
			//hidden file
			var file = document.querySelector('input[type="file"]');
			file.classList.toggle('hidden');
			//button hidden
			var submit = document.querySelector('.submit');
			submit.classList.toggle('hidden');
		});
	</script>
</body>
</html>