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
import org.ofs.model.Subject;
import org.ofs.services.StudentServImpl;
import org.ofs.services.StudentServices;
import org.ofs.services.SubjectServiceImpl;
import org.ofs.services.SubjectServices;


@WebServlet("/allocatesubjecttostudent")
public class AllocateSubjectToStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Allocate Subject To Student</TITLE>");
		out.println("<link rel='stylesheet' href='CSS/student.css'>");
		out.println("<script type='text/javascript' src='JS/student.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<DIV class='stuport'>");

		out.println("<DIV class='subtotrainer'>");
		out.println("<TABLE>");
		out.println("<CAPTION>Allocate Subject To Student</CAPTION>");

		out.println("<TR>");
		out.println("<TH>Student</TH><TH>Subject</TH>");
		out.println("</TR>");
		out.println("<TR>");
		StudentServices stServ = new StudentServImpl();
		List<Student> stlist = stServ.getStudents();
				out.println( "<TD><SELECT name='stid' id='stid' onChange='getSubject(this.value)'>");
				out.println( "<OPTION selected hidden>Select Student</OPTION>");
				for(Student model : stlist) {
					if(model.getStatus()==1) {
						out.println( "<OPTION value='"+model.getSid()+"'>"+model.getStuname()+"</OPTION>");
					}
				}
				out.println( "</SELECT></TD>");
		SubjectServices sServ = new SubjectServiceImpl();
		List<Subject>slist = sServ.getSubjects();
				out.println( "<TD><SELECT name='sid' id='subid'>");
				out.println( "<OPTION selected hidden>Select Subject</OPTION>");
				for(Subject model : slist) {
					if(model.getStatus()==1) {
						out.println( "<OPTION value='"+model.getSubid()+"'>"+model.getName()+"</OPTION>");
					}
				}
				out.println( "</SELECT></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD colspan='2'><input type='button' name='s' onClick='getSub()' value='Allocate-Subject'></TD>");
		out.println("</TR>");

		out.println("<TR id='output'>");
		out.println("</TR>");

		out.println("</TABLE>");
		out.println("</DIV>");

		out.println("<DIV id='allocatedsubject'>");
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
