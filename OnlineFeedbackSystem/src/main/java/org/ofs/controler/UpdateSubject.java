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

/**
 * Servlet implementation class UpdateSubject
 */
@WebServlet("/updatesubject")
public class UpdateSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	//	out.println("");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Update Subject</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/adddata.css'>");
		out.println("<LINK rel='stylesheet' href='CSS/adminmaster.css'>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<form name='frm' action='' method='Post' class='port'>");
			out.println("<table  class='table-container'>");
			out.println("<tr>");
			out.println("<th colspan='3'><h1>All Subject</h1></th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th><h3>Id</h3></th><th><h3>Subject Name</h3><th><h3>Update</h3></th>");
			out.println("</tr>");
		SubjectServices sServ = new SubjectServiceImpl();				//call subject service
		List<Subject> list = sServ.getSubjects();						//get all subjects from database
		for (Subject sub : list) {										//display all subjects
			out.println("<tr>");
			out.println("<td>"+sub.getSubid()+"</td>"
					+ "<td>"+sub.getName()+"</td>"
					+ "<td><a href='updatedsubject?id="+sub.getSubid()+"&name="+sub.getName()+"'>Update</a></td>");
			out.println("</tr>");
		}
			out.println("</table>");
	    out.println("</form>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
