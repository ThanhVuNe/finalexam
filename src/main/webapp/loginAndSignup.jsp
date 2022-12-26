<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login and SignUp</title>
<link rel="stylesheet" href="css/form.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</head>

<body>
	<!-- <a href="https://front.codes/" class="logo" target="_blank"> <img
		src="https://assets.codepen.io/1462889/fcy.png" alt="">
	</a> -->

	<%
	Cookie[] arr = request.getCookies();
	String account = "";
	String pass = "";

	if (arr != null) {
		for (Cookie a : arr) {
			if (a.getName().equals("account")) {
				account=a.getValue();
			}
			if(a.getName().equals("pass")){
				pass=a.getValue();
			}
		}
	}
	%>

	<div class="section">
		<div class="container">
			<div class="row full-height justify-content-center">
				<div class="col-12 text-center align-self-center py-5">
					<div class="section pb-5 pt-5 pt-sm-2 text-center">
						<h6 class="mb-0 pb-3 text-white">
							<span>Log In </span><span>Sign Up</span>
						</h6>
						<input ${checked} class="checkbox" type="checkbox" id="reg-log"
							name="reg-log" /> <label for="reg-log"></label>
						<div class="card-3d-wrap mx-auto">
							<div class="card-3d-wrapper">
								<div class="card-front">
									<div class="center-wrap">
										<div class="section text-center">
											<h4 class="mb-4 pb-3 text-white">Log In</h4>
											<form id="formLogin" action="ValidateServlet?action=login"
												method="post">
												<div class="form-group">
													<input type="email" value="<%=account %>" name="email" class="form-style"
														placeholder="Your Email" id="email" autocomplete="off">
													<i class="input-icon uil uil-at"></i>
												</div>
												<div class="form-group mt-2">
													<input type="password" value="<%=pass %>" name="password" class="form-style"
														placeholder="Your Password" id="pass" autocomplete="off">
													<i class="input-icon uil uil-lock-alt"></i>
												</div>
												<div class="mt-2" style="text-align: left; padding: 0 50px;">
													<input id="rem" <%=account.equals("")?"":"checked" %> type="checkbox" name="remember"
														style="position: relative; left: 0;" autocomplete="off">
													<label for="rem" class="text-white">Remember me</label>
												</div>
												<h4 class="mess text-center text-danger">${mess}</h4>
												<h4 class="mess text-center text-danger"></h4>
												<input id="submit" style="color: white;" name="submit"
													type="submit" value="submit" class="btn mt-4">
												<!-- <a href="#" class="btn mt-4">submit</a> -->
											</form>
											<p class="mb-0 mt-4 text-center">
												<a href="forgotPassword.jsp" class="link">Forgot your
													password?</a>
											</p>
										</div>
									</div>
								</div>
								<div class="card-back">
									<div class="center-wrap">
										<div class="section text-center">
											<h4 class="mb-4 pb-3 text-white">Sign Up</h4>
											<form id="formSignup" action="ValidateServlet?action=signup"
												method="post">
												<!-- 	<div class="form-group">
													<input type="text" name="username" class="form-style"
														placeholder="Your Full Name" id="logname"
														autocomplete="off"> <i
														class="input-icon uil uil-user"></i>
												</div> -->
												<div class="form-group">
													<input type="email" name="emailS" class="form-style"
														placeholder="Your Email" id="logemail" autocomplete="off">
													<i class="input-icon uil uil-at"></i>
												</div>
												<div class="form-group mt-2">
													<input type="password" name="passwordS" class="form-style"
														placeholder="Password" id="logpass" autocomplete="off">
													<i class="input-icon uil uil-lock-alt"></i>
												</div>
												<div class="form-group mt-2">
													<input type="password" name="re_passS" class="form-style"
														placeholder="Re-Password" id="logrepass"
														autocomplete="off"> <i
														class="input-icon uil uil-lock-alt"></i>
												</div>
												<h4 class="messS text-center text-danger">${messS}</h4>
												<h4 class="messS text-center text-danger"></h4>
												<input style="color: white;" name="signup" type="submit"
													value="Signup" class="btn mt-4">
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var form = document.getElementById("formLogin");
		var user = document.querySelector("#email");
		var pass = document.querySelector("#pass");
		var btn = document.querySelector("#submit");
		var mess = document.querySelector(".mess");
		var messE = '';

		var formS = document.getElementById("formSignup");
		var emailS = document.querySelector("#logemail");
		var passS = document.querySelector("#logpass");
		var repassS = document.querySelector("#logrepass");
		var messS = document.querySelector(".messS");

		form.addEventListener("submit", function(e) {
			if (user.value == '' || user.value == null) {
				messE = "Please enter user";
			} else {
				if (checkPasswordValidation(pass.value) === true) {
					messE = ''
				} else {
					messE = checkPasswordValidation(pass.value);
				}
			}
			if (messE != '') {
				e.preventDefault();
				mess.innerText = messE;
			} else {
				mess.innerText = "";
			}
		});

		formS.addEventListener("submit", function(e) {
			if (emailS.value == '' || emailS.value == null) {
				messE = "Please enter email";
			} else {
				if (checkPasswordValidation(passS.value) === true) {
					if (passS.value != repassS.value) {
						messE = "Wrong password";
					} else {
						messE = ''
					}
				} else {
					messE = checkPasswordValidation(passS.value);
				}
			}

			if (messE != '') {
				e.preventDefault();
				messS.innerText = messE;
			} else {
				messS.innerText = "";
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