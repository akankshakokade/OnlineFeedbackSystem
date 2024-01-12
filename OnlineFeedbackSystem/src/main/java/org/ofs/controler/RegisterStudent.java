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


@WebServlet("/registerstudent")
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<!DOCTYPE html>\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "<meta charset=\"UTF-8\">\r\n"
			+ "<title>Register Student</title>\r\n"
			+ "<link rel=\"stylesheet\" href=\"CSS/adminmaster.css\">\r\n"
			+ "<link rel=\"stylesheet\" href=\"CSS/student.css\">\r\n"
			+ "<script type='text/javascript' src='JS/validation.js'></script>"
			+ "</head>");
	out.println("<body>");
		RequestDispatcher rd=request.getRequestDispatcher("adminmasterservlet");
		rd.include(request,response);
	out.println("<div class='stuport'>\r\n"
			+ "	<h1 id='heading'>Register Student</h1>\r\n"
			+ "	<div class='student-container'>\r\n"
			+ "	<form name='frm' action='' method='post'>\r\n"
			+ "	<label for='name'>Name :</label><br>\r\n"
			+ "	<input type='text' name='name' id='name' onKeyUp='nameValidation(this.value)' Placeholder='Enter Name' required><br>\r\n"
			+ "	<span id='validname'></span><br>\r\n"
			+ "	<label for='email'>E-Mail :</label><br>\r\n"
			+ "	<input type='email' name='email' id='email' onKeyUp='emailValidation(this.value)' Placeholder='Enter E-Mail' required><br>\r\n"
			+ "	<span id='validemail'></span><br>\r\n"
			+ "	<label for='contact'>Contact :</label><br>\r\n"
			+ "	<input type='text' name='contact' id='contact' onKeyUp='contactValidation(this.value)' maxlength='10' Placeholder='Enter Contact' required><br>\r\n"
			+ "	<span id='validcontact'></span><br>\r\n"
			+ "	<label for='bob'>Date Of Birth :</label><br>\r\n"
			+ "	<input type='date' name='dob' id='dob' onInput='dateOfBirthValidation()' required><br>\r\n"
			+ "	<span id='validdate'></span><br>\r\n"
			+ "	<label for='address'>Address :</label><br>\r\n"
			+ "	<input type='text' name='address' id='address' Placeholder='Enter address' required><br>\r\n"
			+ "	<span id=''></span><br>\r\n"
			+ "	<input id='sub-btn' type='submit' name='s' Value='Add New Student'><br>");
		if(request.getParameter("s")!=null){
			Student model = new Student();
			model.setStuname(request.getParameter("name"));
			model.setEmail(request.getParameter("email"));
			model.setContact(request.getParameter("contact"));
			model.setDob(request.getParameter("dob"));
			model.setAddress(request.getParameter("address"));
			model.setPassword(request.getParameter("contact"));
			model.setStatus(0);

			StudentServices sServ =new StudentServImpl();
			boolean b = sServ.addStudent(model);
			if(b)
				out.println("<span id='result'>Student Added</span>");
			else
				out.println("<span id='result'>Student Not Added</span>");
		}else{
			out.println("<span id='result' style='color:'red''>Student Not Added</span>");
		}
	out.println("</form>\r\n"
			+ "	<div class=\"sub-container\">\r\n"
			+ "		<pre><h1>Make Your Career</h1>\r\n"
			+ "		<h2>Welcome to world of Knowledge</h2></pre>\r\n"
			+ "	</div>\r\n"
			+ "	</div>\r\n"
			+ "	</div>");
	out.println("</body>");
	out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
