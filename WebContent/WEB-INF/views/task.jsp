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
		      <li><a href="<%=request.getContextPath()%>/HomeServlet">Home</a></li>
		      <li class="dropdown active"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Task<span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="ViewTaskServlet">List of Task</a></li>
		          <li><a href="#">Add new Task</a></li>
		        </ul>
		      </li>
		      <li><a href="ViewHistoryServlet">History</a></li>
		      <li><a href="ViewUserServlet">User</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="<%=request.getContextPath()%>/EditUserServlet">Profile</a></li>
		      <li><a href="<%=request.getContextPath()%>/Logout"><span class="glyphicon glyphicon-log-in"></span> logout</a></li>
		    </ul>
		  </div>
		</nav>
	 	<div class="container">
	 	<div class="panel panel-body" align="center">
	 		<div class="reg">
	 		<h1>Add New Task</h1>  
			<form action="SaveTaskServlet" method="post">  
				<table>  
					<tr>
						<p>
							<th>Name:</th>
							<td><input type="text" name="name"/></td>
							<td></td>
						</p>
					</tr>
					<tr>
						<p>
							<th>Description:</th>
							<td><input type="text" name="description"/></td>
							<td></td>
						</p>
					</tr>
				<tr>
					<td colspan="2 style="text-align:right;><br><p class="submit"><input type="submit" value="Add Task"/></p></td>
				</tr>  
				</table>  
			</form> 
			</div>
	 	</div>
		</div>
	</body>
</html>