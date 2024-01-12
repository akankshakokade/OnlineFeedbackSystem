package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Student;
import org.ofs.services.StudentServImpl;
import org.ofs.services.StudentServices;

@WebServlet("/viewstudents")
public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>View Student</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/student.css'>");
		out.println("<script type='text/javascript' src='JS/student.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<DIV class='stuport'>");

		out.println("<DIV CLASS='search-container'>");
		out.println("<INPUT TYPE='text' onKeyUp='searchStudents(this.value)' NAME='srctext' PLACEHOLDER='Search Here By Id, Name, E-Mail, Contact'>");
		out.println("</DIV>");
			out.println("<DIV id='viewstudent' class='table-container allstudent'>");

			out.println("<TABLE>");
			out.println("<THEAD>");
			out.println("<TR>");
			out.println("<TH>ID</TH>"
						+ "<TH>Name</TH>"
						+ "<TH>E-Mail</TH>"
						+ "<TH>Contact</TH>"
						+ "<TH>Status</TH>"
						+ "<TH>Update</TH>"
						+ "<TH>Delete</TH>"
						+ "<TH>All Details</TH>");
			out.println("</TR>");
			out.println("</THEAD>");
			out.println("<TBODY>");
			StudentServices sServ = new StudentServImpl();
			List<Student>slist = sServ.getStudents();
			for(Student s : slist) {
			out.println("<TR>");
			out.println("<TD>"+s.getSid()+"</TD>"
						+ "<TD>"+s.getStuname()+"</TD>"
						+ "<TD>"+s.getEmail()+"</TD>"
						+ "<TD>"+s.getContact()+"</TD>");
						if(s.getStatus()==0) {
							out.println( "<TD><BUTTON id='status' onClick='studentStatus("+s.getSid()+","+1+")'>Disable</BUTTON></TD>");
						}
						else {
							out.println( "<TD><BUTTON id='status' onClick='studentStatus("+s.getSid()+","+0+")'>Enable</BUTTON></TD>");
						}
			out.println(  "<TD><BUTTON onClick='goToUpdateStudent("+s.getSid()+")'>Update</BUTTON></TD>"
						+ "<TD><BUTTON onClick='deleteStudent("+s.getSid()+")'>Delete</BUTTON></TD>"
						+ "<TD><A href='indivisualstudentview?id="+s.getSid()+"'>View</A></TD>");
			out.println("</TR>");
			}
			out.println("</TBODY>");
			out.println("</TABLE>");
	        out.println("</DIV>");
	    out.println("</DIV>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
