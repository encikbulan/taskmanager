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
		<style>
		</style>
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
		          <li><a href="SaveTaskServlet">Add new Task</a></li>
		        </ul>
		      </li>
		      <li><a href="#">Page 2</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a><% String name = (String) session.getAttribute("username"); out.print(name); %></a></li>
		      <li><a href="<%=request.getContextPath()%>/Logout"><span class="glyphicon glyphicon-log-in"></span> logout</a></li>
		    </ul>
		  </div>
		</nav>
	 	<div class="container">
	 	<div class="panel panel-body" align="center">
	 		<c:if test="${task != null}">
				<form action="update" method="post">
	        </c:if>
	        <c:if test="${task == null}">
				<form action="insert" method="post">
		        </c:if>
		        <table border="1" cellpadding="5">
		            <caption>
		            	<h2>
		            		<c:if test="${task != null}">
		            			Edit Task
		            		</c:if>
		            		<c:if test="${task == null}">
		            			Add New Task
		            		</c:if>
		            	</h2>
		            </caption>
		        		<c:if test="${task != null}">
		        			<input type="hidden" name="id" value="<c:out value='${task.id}' />" />
		        		</c:if>            
		            <tr>
		                <th>Task Name: </th>
		                <td>
		                	<input type="text" name="name" size="45"
		                			value="<c:out value='${task.name}' />"
		                		/>
		                </td>
		            </tr>
		            <tr>
		                <th>Task Description: </th>
		                <td>
		                	<input type="text" name="description" size="45"
		                			value="<c:out value='${task.description}' />"
		                	/>
		                </td>
		            </tr>
		            <tr>
		            	<td colspan="2" align="center">
		            		<input type="submit" value="Save" />
		            	</td>
		            </tr>
		        </table>
	        </form>
	 	</div>
		</div>
	</body>
</html>