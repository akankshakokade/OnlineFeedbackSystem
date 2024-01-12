<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Subjects</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link rel='stylesheet' href="../CSS/studentmaster.css">
	<%@ page import="org.ofs.services.StudentServImpl" %>
	<%@ page import="java.util.*" %>
	<%@ page import="org.ofs.model.Subject" %>
	<%@ page import="org.ofs.model.Student" %>
</head>
<body>
	<header class="container mt-2">
		<h1>SOFT-TECH</h1>
	</header>
	<div class="container mt-5">
	<div>
		<button onclick="history.back()">Back</button>
	</div>
		<%
			Student s = (Student)session.getAttribute("user");
			List<Subject> subjects = new StudentServImpl().getAllocatedSubjectOfStudent(s.getSid());
			for(Subject sub : subjects){
				%>
					<h3>
					<%= sub.getName() %>
					<%= sub.getStatus()==1 ? "Enable" : "Disable" %>
					<h3>
				<%
			}
		%>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>