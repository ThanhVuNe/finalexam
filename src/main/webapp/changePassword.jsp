<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	background-color: #1f2029;
	min-height: 100vh;
}

form {
	display: flex;
	flex-direction: column;
}

#pass, #rePass {
	padding: 15px;
	width: 300px;
	color: gray;
	border-radius: 10px;
	opacity: .5;
}

#submit {
	width: 100px;
	margin: 0 auto;
	margin-bottom: 10px;
	padding: 10px;
	border-radius: 20px;
	background-color: gray;
}
</style>
</head>
<body>
	<h2 style="color: red;" class="mess"></h2>
	<p style="color: gray; font-size: 20px; font-weigth: bold;">${mess}</p>
	<form action="changePasswordServlet" method="post" id="formLogin">
		<input type="hidden" value="${email}" name="email" /> <input
			type="password" id="pass" name="pass" placeholder="New Password" /><br />
		<br /> <input type="password" id="rePass" name="rePass"
			placeholder="Confirm Password" /><br />
		<br /> <input type="submit" id="submit" value="Submit" />
	</form>
	<a href="loginAndSignup.jsp" style="color: gray; font-size: 20px;">Home</a>
	<script>
		var form = document.getElementById("formLogin");
		var user = document.querySelector("#email");
		var pass = document.querySelector("#pass");
		var repass = document.querySelector("#rePass");
		var btn = document.querySelector("#submit");
		var mess = document.querySelector(".mess");
		var messE = '';
		console.log(pass);
		form.addEventListener("submit", function(e) {

			if (checkPasswordValidation(pass.value) === true) {
				if(pass.value!=repass.value){
					messE="Wrong password";
				}else{
					messE = ''							
				}
			} else {
				messE = checkPasswordValidation(pass.value);
			}

			if (messE != '') {
				e.preventDefault();
				mess.innerText = messE;
			} else {
				mess.innerText = "";
			}
		});
		function checkPasswordValidation(value) {
			const isWhitespace = /^(?=.*\s)/;
			if (isWhitespace.test(value)) {
				return "Password must not contain Whitespaces.";
			}

			const isContainsUppercase = /^(?=.*[A-Z])/;
			if (!isContainsUppercase.test(value)) {
				return "Password must have at least one Uppercase Character.";
			}

			const isContainsLowercase = /^(?=.*[a-z])/;
			if (!isContainsLowercase.test(value)) {
				return "Password must have at least one Lowercase Character.";
			}

			const isContainsNumber = /^(?=.*[0-9])/;
			if (!isContainsNumber.test(value)) {
				return "Password must contain at least one Digit.";
			}

			const isContainsSymbol = /^(?=.*[~`!@#$%^&*()--+={}\[\]|\\:;"'<>,.?/_₹])/;
			if (!isContainsSymbol.test(value)) {
				return "Password must contain at least one Special Symbol.";
			}

			const isValidLength = /^.{8,}$/;
			if (!isValidLength.test(value)) {
				return "Password must be 8 Characters up.";
			}
			return true;
		}
	</script>
</body>
</html>