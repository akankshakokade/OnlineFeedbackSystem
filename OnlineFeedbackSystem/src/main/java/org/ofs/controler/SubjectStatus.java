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


@WebServlet("/subjectstatus")
public class SubjectStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	//	out.println("");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Subject Status</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/adddata.css'>");
		out.println("<LINK rel='stylesheet' href='CSS/adminmaster.css'>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<form name='frm' action='' method='Post' class='port'>");
			out.println("<table class='status-table'>");
			out.println("<tr>");
			out.println("<th colspan='3'><h1>Enable/Disable Subject</h1></th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th><h3>Subject Id</h3></th><th><h3>Subject Name</h3></th><th><h3>Current Status</h3></th>");
			out.println("</tr>");
		SubjectServices sServ = new SubjectServiceImpl();				//call subject service
		List<Subject> list = sServ.getSubjects();						//get all subjects from database
		for (Subject sub : list) {										//display all subjects
			if(sub.getStatus()==1) {
			out.println("<tr>");
					out.println("<td>"+sub.getSubid()+"</td><td>"+sub.getName()+"</td>"
							+ "<td><a class='enable-btn' href='enabledisablesubject?subid="+sub.getSubid()+"&subname="+sub.getName()+"&status="+0+"'>Enable</a></td>");
					out.println("</tr>");
			}else {
				out.println("<tr>");
				out.println("<td>"+sub.getSubid()+"</td><td>"+sub.getName()+"</td>"
						+ "<td><a class='disable-btn' href='enabledisablesubject?subid="+sub.getSubid()+"&subname="+sub.getName()+"&status="+1+"'>Disable</a></td>");
				out.println("</tr>");
			}
		}
			out.println("</table>");
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
