<%@page import="Model.Season"%>
<%@page import="java.util.List"%>
<%@page import="Dao.SeasonDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            min-height: 100vh;
            align-items: center;
            background-color: darkgray;
        }
        select{
            width: 400px;
            height: 50px;
            font-size: 20px;
            cursor: pointer;
            text-align: center;
        }
        input{
            width: 80px;
            height: 30px;
            border-radius: 10px;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
	<%
		SeasonDao dao=new SeasonDao();
		List<Season>seasons=dao.getAllSeason();
	%>
    <div class="container">
        <h1>PlEASE CHOOSE A SEASON</h1>
        <form action="HomeServlet" method="post">
            <select name="season" id="">
            <% for(int i=0;i<seasons.size();i++){ %>
                <option value="<%=seasons.get(i).getId() %>"><%=seasons.get(i).getYearS()%>-<%=seasons.get(i).getYearE() %></option>
              <%} %>
            </select>
            <input onclick="return confirm('Are you sure?')" type="submit" value="SELECT">
        </form>
    </div>
  
</body>
</html>