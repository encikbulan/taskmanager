<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dashboard</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	<body>
		   <%
		      if (session != null) {
		         if (session.getAttribute("username") != null) {
		            String name = (String) session.getAttribute("username");
		         }
		      }
		   %>
	 	<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Task Manager</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="#">Home</a></li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Task<span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="ViewTaskServlet">List of Task</a></li>
		          <li><a href="<%=request.getContextPath()%>/SaveTaskServlet">Add new Task</a></li>
		        </ul>
		      </li>
		      <li><a href="<%=request.getContextPath()%>/ViewHistoryServlet">History</a></li>
		      <li><a href="<%=request.getContextPath()%>/ViewUserServlet">User</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="<%=request.getContextPath()%>/EditUserServlet">Profile</a></li>
		      <li><a href="<%=request.getContextPath()%>/Logout"><span class="glyphicon glyphicon-log-in"></span> logout</a></li>
		    </ul>
		  </div>
		</nav>
	 	<div class="container">
	 	<div class="panel panel-body" align="center">
	 		<img src="${pageContext.request.contextPath}/image/welcome.jpg" alt="Avatar" width="771" height="427" >
	 	</div>
		</div>
	</body>
</html>