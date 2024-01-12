<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
	<style>
		.backimg{
			background-image: url("../images/ai.jpg");
			background-repeat: no-repeat;
			background-size: cover;
		}
		.blur{
			backdrop-filter: blur(5px);
		}
	</style>
	<%@ page import="org.ofs.model.Student" %>
	<%@ page import="org.ofs.services.StudentServImpl" %>
	<%@ page session="true" %>
</head>
<body class="p-5">
	<div class="m-5 d-flex justify-content-center rounded-3 align-items-center backimg" style="height: 70vh">
		<div class="w-50 mt-5 border text-white rounded-3 blur">
		<form name="frm" action="" method="post">
			<div class="text-center mt-3">
				<h2>Login Here</h2>
			</div>
			<div class="p-3 w-75 m-auto">
				<label for="email">UserName</label>
				<input type="email" id="email" name="email" placeholder="Enter Email" class="form-control bg-transparent text-white">
			</div>
			<div class="p-3 w-75 m-auto text-white">
				<label for="pass">Password</label>
				<input type="password" id="pass" name="pass" placeholder="Enter Password" class="form-control bg-transparent text-white">
			</div>
			<div class="p-3 w-75 m-auto d-flex justify-content-center">
				<input type="submit" id="s" name="s" value="Log-in" class=" w-50 btn bg-info-subtle border border-danger">
			</div>
	<%
		if(request.getParameter("s")!=null){
		String user = request.getParameter("email");
		String pass = request.getParameter("pass").toString();
		
		System.out.println(pass);
		Student student = new Student();
		student.setEmail(user);
		student.setPassword(pass);
		
		student = new StudentServImpl().validStudent(student);
		if(student != null ){
			session.setAttribute("user", student);
			request.getRequestDispatcher("StudentMaster.jsp").forward(request, response);
		}else{
			%>
			<div class="text-center">
				<span id="result">Wrong Password</span>
			</div>
			<%
		}
	}
	%>
			</form>
		</div>
	</div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" 
	    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>