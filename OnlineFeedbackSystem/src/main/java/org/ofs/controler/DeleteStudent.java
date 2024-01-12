package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Student;
import org.ofs.services.StudentServImpl;
import org.ofs.services.StudentServices;

@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		StudentServices sServ = new StudentServImpl();
		sServ.deleteStudent(id);

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
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
