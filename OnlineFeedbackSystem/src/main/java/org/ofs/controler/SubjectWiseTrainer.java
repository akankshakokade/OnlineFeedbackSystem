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

@WebServlet("/subjectwisetrainer")
public class SubjectWiseTrainer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<HTML lang=\"en\">");
		out.println("<HEAD>");
		out.println("<meta charset=\"UTF-8\">\r\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<TITLE>Subject Wise Trainer</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/report.css'>");
		out.println("<script type='text/javascript' src='JS/report.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<div class='rptport'>");

			out.println("<DIV class='sub-container'>");
			SubjectServices sServ = new SubjectServiceImpl();
			List<Subject>slist = sServ.getSubjects();
			out.println("<SELECT onChange='subjectWiseTrainer(this.value)'>");
				out.println("<OPTION selected hidden>Select Subject</OPTION>");
				for(Subject s : slist) {
					out.println("<OPTION value='"+s.getSubid()+"'>"+s.getName()+"</OPTION>");
				}
			out.println("</SELECT>");
			out.println("</DIV>");

			out.println("<DIV id='subjectwisetrainer'>");
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