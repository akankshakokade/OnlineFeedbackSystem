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

@WebServlet("/subjectwisestudent")
public class SubjectWiseStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Subject Wise Studnet</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/report.css'>");
		out.println("<script type='text/javascript' src='JS/report.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
			out.println("<div class='rptport'>");
			out.println("<Div class='sub-container'>");
			SubjectServices sServ = new SubjectServiceImpl();
			List<Subject>slist = sServ.getSubjects();
			out.println("<SELECT onChange='subjectWiseStudent(this.value)'>");
				out.println("<OPTION selected hidden>Select Subject</OPTION>");
				for(Subject s : slist) {
					out.println("<OPTION value='"+s.getSubid()+"'>"+s.getName()+"</OPTION>");
				}
			out.println("</SELECT>");
			out.println("</Div>");

			out.println("<DIV id='subjectwisestudent'>");
			out.println("</DIV>");

	        out.println("</div>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
