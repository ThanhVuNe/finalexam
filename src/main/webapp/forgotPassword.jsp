<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
		display: flex;
		min-height: 100vh;
		justify-content: center;
		align-items: center;
		flex-direction: column;
		background-color: #1f2029;
	}
	#email{
		border-radius: 5px;
		height:20px;
		border: none;
		outline: none;
		padding: 10px;
		width: 300px;
		opacity: .5;
    }
    #submit{
    	width: 100px;
    	border-radius: 20px;
    	background-color: gray;
    	margin: 0 auto;
    	margin-top: 10px;
    	padding: 10px;
    }
    form{
    	display: flex;
    	flex-direction: column;
    }
</style>
</head>
<body>
	<form action="ForgotPasswordServlet" method="post">
		<input id="email" type="email" name="email" placeholder="Enter Email"/>	
		<input type="submit" value="Submit" id="submit"/>
	</form>
	<p style="color:red;">${mess}</p>
</body>
</html>