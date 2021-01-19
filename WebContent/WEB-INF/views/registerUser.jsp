<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register</title>
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
	            <h5 class="card-title text-center">Register</h5>
	            <form class="form-signin" action="<%= request.getContextPath()%>/register" method="post">
	              <div class="form-label-group">
	                <input type="text" id="firstName" name="firstName" class="form-control" placeholder="First name" required autofocus>
	                <label for="firstName">First Name</label>
	              </div>
	              <div class="form-label-group">
	                <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Last name" required autofocus>
	                <label for="lastName">Last Name</label>
	              </div>
	              <div class="form-label-group">
	                <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
	                <label for="username">Username</label>
	              </div>
				  <div class="form-label-group">
	                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required autofocus>
	                <label for="password">Password</label>
	              </div>
	              <div class="form-label-group">
	                <input type="text" id="address" name="address" class="form-control" placeholder="Adress" required autofocus>
	                <label for="address">Address</label>
	              </div>
	              <div class="form-label-group">
	                <input type="text" id="contact" name="contact" class="form-control" placeholder="Contact" required autofocus>
	                <label for="contact">Contact No</label>
	              </div>
	              <br>
	              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
	              <hr class="my-4">
	              Already a member? <a href="<%=request.getContextPath()%>/login">Log-in</a>
	            </form>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</body>
</html>