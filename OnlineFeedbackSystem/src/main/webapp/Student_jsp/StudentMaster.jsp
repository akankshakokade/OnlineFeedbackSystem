<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Master</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel='stylesheet' href="../CSS/studentmaster.css">
	<%@ page import="org.ofs.model.Student" %>
</head>
<body>
	<nav class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
					<div
						class="d-flex flex-column align-items-center align-items-sm-start bg-danger px-3 pt-2 fs-5 text-white min-vh-100">
						<a href="#" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
							<span class="fs-2 d-none d-sm-inline p-2 border border-dark bg-info fw-bold rounded-pill shadow">SOFT-TECH</span>
						</a>
						<ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
								<li class="nav-item"><a href="StudentMaster.jsp" class="nav-link align-middle px-0"> 
									<i class="fs-4 bi-house"></i>
									<span class="ms-1 d-none d-sm-inline text-white fw-bold">Home</span>
							</a></li>
							
							<li><a href="StudentSubjects.jsp" class="nav-link px-0 align-middle"> 
									<i class="fs-4 bi-table"></i>
									<span class="ms-1 d-none d-sm-inline text-white fw-bold">Subjects</span></a></li>
									
							<li><a href="Feedback.jsp" class="nav-link px-0 align-middle"> 
									<i class="fs-4 bi-table"></i>
									<span class="ms-1 d-none d-sm-inline text-white fw-bold">FeedBack</span></a></li>
									
							<li><a href="#submenu2" data-bs-toggle="collapse" class="nav-link px-0 align-middle "> 
								<i class="fs-4 bi-bootstrap"></i> 
									<span class="ms-1 d-none d-sm-inline  text-white  fw-bold">Feedback</span></a>
								<ul class="collapse nav flex-column ms-1" id="submenu2" data-bs-parent="#menu">
									<li class="w-100 ms-5"><a href="#" class="nav-link px-0"> 
									<span class="d-none d-sm-inline text-info">Item</span>
									</a></li>
									<li class="w-100 ms-5"><a href="#" class="nav-link px-0"> 
										<span class="d-none d-sm-inline">Item</span>
									</a></li>
								</ul></li>
								
							<li><a href="#submenu3" data-bs-toggle="collapse" class="nav-link px-0 align-middle"> 
									<i class="fs-4 bi-grid"></i>
									<span class="ms-1 d-none d-sm-inline text-white  fw-bold">Products</span>
							</a>
								<ul class="collapse nav flex-column ms-1" id="submenu3"
									data-bs-parent="#menu">
									
									<li class="w-100">
									<a href="#" class="nav-link px-0 "><span class="d-none d-sm-inline">Product 1</span>
									</a></li>
									
									<li class="w-100"><a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product 2</span>
									</a></li>
									
									<li class="w-100"><a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product 3</span>
									</a></li>
									
									<li class="w-100"><a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product 4</span>
									</a></li>
									
								</ul></li>
								
							<li><a href="#" class="nav-link px-0 align-middle"> <i
									class="fs-4 bi-people"></i> <span
									class="ms-1 d-none d-sm-inline  text-white  fw-bold">Customers</span>
							</a></li>
							
						</ul>
						<hr>
						<%
							Student student = (Student)session.getAttribute("user");
							String name[] = student.getStuname().split(" "); 
							String n = name[0];
						%>
						<div class="dropdown pb-4">
							<a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false"> 
								<img src="../images/21.png" alt="hugenerd" width="30" height="30" class="rounded-circle">
								<span class="d-none d-sm-inline mx-1"><%= n %></span>
							</a>
							<ul class="dropdown-menu dropdown-menu-white text-small">
								<li><a class="dropdown-item" href="#">Profile</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="#">Sign out</a></li>
							</ul>
						</div>
					</div>
				</div>
	</nav>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>