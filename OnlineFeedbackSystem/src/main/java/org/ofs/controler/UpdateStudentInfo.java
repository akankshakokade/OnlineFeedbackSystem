package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Student;
import org.ofs.services.StudentServImpl;
import org.ofs.services.StudentServices;


@WebServlet("/updatestudentinfo")
public class UpdateStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		StudentServices sServ = new StudentServImpl();
		Student s = sServ.getStudent(id);

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>View Student</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/student.css'>");
		out.println("<script type='text/javascript' src='JS/student.js'></script>");
		out.println("<script type='text/javascript' src='JS/validation.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<div class='stuport'>\r\n"
				+ "	<h1 id='heading'>Update Student personal info</h1>\r\n"
				+ "	<div class='student-container'>\r\n"
				+ "	<form name='frm' action='' method='post'>\r\n"
				+ "	<label for='name'>Name :</label><br>\r\n"
				+ "	<input type='text' name='name' id='name' value='"+s.getStuname()+"' onKeyUp='nameValidation(this.value)' Placeholder='Enter Name' required><br>\r\n"
				+ "	<span id='validname'></span><br>\r\n"
				+ "	<label for='email'>E-Mail :</label><br>\r\n"
				+ "	<input type='email' name='email' id='email' value='"+s.getEmail()+"' onKeyUp='emailValidation(this.value)' Placeholder='Enter E-Mail' required><br>\r\n"
				+ "	<span id='validemail'></span><br>\r\n"
				+ "	<label for='contact'>Contact :</label><br>\r\n"
				+ "	<input type='text' name='contact' id='contact' value='"+s.getContact()+"' onKeyUp='contactValidation(this.value)' maxlength='10' Placeholder='Enter Contact' required><br>\r\n"
				+ "	<span id='validcontact'></span><br>\r\n"
				+ "	<label for='bob'>Date Of Birth :</label><br>\r\n"
				+ "	<input type='date' name='dob' id='dob' value='"+s.getDob()+"' onInput='dateOfBirthValidation()' required><br>\r\n"
				+ "	<span id='validdate'></span><br>\r\n"
				+ "	<label for='address'>Address :</label><br>\r\n"
				+ "	<input type='text' name='address' id='address' value='"+s.getAddress()+"' Placeholder='Enter address' required><br>\r\n"
				+ "	<span id=''></span><br>\r\n"
				+ "<select name='status' id='status'>");
				if(s.getStatus()==1) {
					out.println( "<option value='1'>Enable</option>");
					out.println( "<option value='0'>Disable</option>");
				}
				else {
					out.println( "<option value='0'>Disable</option>");
					out.println( "<option value='1'>Enable</option>");
				}
				out.println(  "</select><br>"
				+ "	<input id='sub-btn' type='submit' name='s' Value='Update Student'><br>");

			if(request.getParameter("s")!=null){
				Student model = new Student();
				model.setSid(id);
				model.setStuname(request.getParameter("name"));
				model.setEmail(request.getParameter("email"));
				model.setContact(request.getParameter("contact"));
				model.setDob(request.getParameter("dob"));
				model.setAddress(request.getParameter("address"));
				model.setPassword(request.getParameter("contact"));
				model.setStatus(Integer.parseInt(request.getParameter("status")));

				Student st = sServ.updateStudent(model);
				if(st!=null) {
					out.println("<span id='result'>Student Updated</span>");
				}
				else
					out.println("<span id='result'>Student Not Updated</span>");
			}
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("</HTML>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
