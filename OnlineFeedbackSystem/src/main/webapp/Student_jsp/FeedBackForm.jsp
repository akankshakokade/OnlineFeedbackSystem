<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link rel='stylesheet' href="../CSS/studentmaster.css">
	<%@ page import="org.ofs.services.AdminServicesImpl" %>
	<%@ page import="org.ofs.model.Questions" %>
	<%@ page import="java.util.List" %>
</head>
<body>
	<div>
	<div class="container">
	<%
		List <Questions> qlist = new AdminServicesImpl().getQuestions();
		int count = 0;
			do{
				Questions qn = qlist.get(count);
	%>
			<h4 class="fw-bold text-center mt-3">Question no : <%= ++count %></h4>
				<p class="fw-bold"><%= qn.getQuestion() %></p>
				<div class="form-check mb-2 d-flex justify-content-center">
					<input class="form-check-input" type="radio" name="exampleForm" id="radioExample1" />
						<label class="form-check-label" for="radioExample1"> Option 1 </label>
				</div>
				<div class="form-check mb-2 d-flex justify-content-center">
					<input class="form-check-input" type="radio" name="exampleForm" id="radioExample3" />
						<label class="form-check-label" for="radioExample3"> Option 2 </label>
				</div>
				<div class="form-check mb-2 d-flex justify-content-center">
					<input class="form-check-input" type="radio" name="exampleForm" id="radioExample3" /> 
					<label class="form-check-label"	for="radioExample3"> Option 3 </label>
				</div>
				<div class="form-check mb-2 d-flex justify-content-center">
					<input class="form-check-input" type="radio" name="exampleForm" id="radioExample3" />
					<label class="form-check-label" for="radioExample3"> Option 4 </label>
				</div>
				<div>
					<input type="button" id="next" name="next" value="Next">
				</div>
	<%
			}while(request.getParameter("Next")!=null);
	%>
	</div>
	<div class="text-end">
		<input type="Submit" id="s" value="Submit" class="btn btn-primary float-start">
	</div>
	<%
		if(request.getParameter("s")!=null){
			%>
				<h1><%= count %></h1>
			<%
		}
	%>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>