package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class AddSubject
 */
@WebServlet("/addsubject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		SubjectServices subServ = new SubjectServiceImpl();
	//	out.println("");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Add New Subject</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/adminmaster.css'>");
		out.println("<LINK rel='stylesheet' href='CSS/adddata.css'>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<div class='port'>");
		out.println("<div class='container'>");
		out.println("<form name='frm' action='' method='Post'>");

			out.println("<div><h2>Add New Subject</h2></div>");
	        out.println("<div><input type='text' name='subid' value='"+subServ.getSubId()+"' id='' disabled /></div>");
	        out.println("<div><input type='text' name='subname' value='' id='' placeholder='Enter Subject' required/></div>");
	        out.println("<input type='submit' name='s' value='Add Subject' class='btn' />");

	        out.println("</form>");
//	    	page submit

			if(request.getParameter("s")!=null) {
				Subject model = new Subject();
				model.setSubid(subServ.getSubId());
				model.setName(request.getParameter("subname"));

				boolean b = subServ.addSubject(model);
				if(b)
					out.println("<center><span class='oput'>Added Succesfully</span></center>");
				else
					out.println("<center><span class='oput'>Not Added</span></center>");
			}
	        out.println("</div>");
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
