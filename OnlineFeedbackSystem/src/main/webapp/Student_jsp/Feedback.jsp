<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link rel='stylesheet' href="../CSS/studentmaster.css">
	<%@ page import="org.ofs.services.*" %>
	<%@ page import="java.util.*" %>
	<%@ page import="org.ofs.model.*" %>
</head>
<body class="bg-light">
	<header class="container mt-2 p-1 rounded shadow text-center">
		<h1>ABT SOFT-TECH</h1>
	</header>
	<div class="container mt-5">
	<div class="">
		<button class="ps-5 pe-5 pt-1 pb-1 shadow rounded" onclick="history.back()">Back</button>
		<input class="form-control w-50 d-inline float-end" type="text" name="searchtext" id="searchtext" placeholder="Search Here...">
	</div>
			<table class="mt-5 table table-striped border border-dark rounded">
					<thead>
					<tr><th>Sr.no</th><th>Subject</th><th>Status</th><th>Select Trainer</th><th>Give Feedback</th></tr>
					</thead>
					<tbody>
		<%
			Student s = (Student)session.getAttribute("user");
			List<Subject> subjects = new StudentServImpl().getAllocatedSubjectOfStudent(s.getSid());
			int count = 1;
			for(Subject sub : subjects){
				List<TrainerReg> trainers = new SubjectServiceImpl().getSubjectWiseTrainer(sub.getSubid());
				%>
					<tr>
					<td><%= count++ %></td>
					<td><%= sub.getName() %></td>
					<td><%= sub.getStatus()==1 ? "Enable" : "Disable" %></td>
					<td>
						<select class="form-select">
							<%
								for(TrainerReg tr : trainers){
									%>
									<option class=""><%= tr.getName() %></option>
									<%
								}
							%>
						</select>
					</td>
					<%
						if(sub.getStatus()==1){
							%>
								<td><a href="#">Click</a></td>
							<%
						}
					%>
					</tr>
				<%
			}
		%>
		</tbody>
			</table>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>