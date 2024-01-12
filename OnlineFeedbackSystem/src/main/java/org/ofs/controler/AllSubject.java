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

import org.ofs.model.Subject;
import org.ofs.services.SubjectServiceImpl;
import org.ofs.services.SubjectServices;

@WebServlet("/allsubject")
public class AllSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	//	out.println("");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Add New Subject</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/adddata.css'>");
		out.println("<LINK rel='stylesheet' href='CSS/adminmaster.css'>");
		out.println("<script type='text/javascript' src='JS/searchsubject.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<form name='frm' action='' method='Post' class='port'>");
		out.println("<input type='text' class='search-btn' onkeyup='searchSubject(this.value)' placeholder='Enter Subject Name For Search'>");
			out.println("<div id='st'>");
			out.println("<table  class='table-container'>");
			out.println("<tr>");
			out.println("<th colspan='2'><h1>All Subject Details</h1></th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th><h3>Id</h3></th><th><h3>Subject Name</h3></th>");
			out.println("</tr>");
		SubjectServices sServ = new SubjectServiceImpl();				//call subject service
		List<Subject> list = sServ.getSubjects();						//get all subjects from database
		for (Subject sub : list) {										//display all subjects
			out.println("<tr>");
			out.println("<td>"+sub.getSubid()+"</td><td>"+sub.getName()+"</td>");
			out.println("</tr>");
		}
			out.println("</table>");
			out.println("</div>");
	    out.println("</form>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
