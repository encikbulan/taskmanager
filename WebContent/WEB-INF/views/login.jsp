<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login Page</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.slim.min.js"></script>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
   	<script src="https://use.fontawesome.com/releases/v5.8.2/css/all.css"></script>
	
</head>
<body>
	<div class="container">
	    <div class="row">
	      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
	        <div class="card card-signin my-5">
	          <div class="card-body">
	            <h5 class="card-title text-center">Form Manager</h5>
	            <br>
	            <form class="form-signin" action="<%=request.getContextPath()%>/login" method="post">
	              <div class="form-label-group">
	                <input type="text" id="inputEmail" name="username" class="form-control" placeholder="Email address" required autofocus>
	                <label for="inputEmail">Username</label>
	              </div>
	
	              <div class="form-label-group">
	                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
	                <label for="inputPassword">Password</label>
	              </div>
	              <br><p>${message}</p>
	              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
	              <hr class="my-4">
	              Not a member? <a href="<%=request.getContextPath()%>/register">Register</a>
	            </form>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
</body>
</html>