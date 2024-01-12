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


@WebServlet("/updatedsubject")
public class UpdatSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		SubjectServices subServ = new SubjectServiceImpl();
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
		out.println("<DIV class='port'>");
		out.println("<div class='container'>");
		out.println("<form name='frm' action='' method='Post' >");
		String sid = request.getParameter("id");
		String name = request.getParameter("name");
			out.println("<div><h2>Update Subject</h2></div>");
			out.println("<div><h4>Subject Id :</h4></div>");
	        out.println("<div><input type='text' name='subid' value='"+sid+"' Disabled/></div>");
			out.println("<div><h4>Subject name :</h4></div>");
	        out.println("<div><input type='text' value='"+name+"' id='' Disabled/></div>");
	        out.println("<div><input type='text' name='subname' value='' id='' placeholder='Enter New Subject Name' /></div>");
	        out.println("<input type='submit' name='s' value='Update Subject' class='btn' />");

	        out.println("</form>");
	      //submit

			String btn = request.getParameter("s");
			if(btn!=null) {
				Subject model = new Subject();
				model.setSubid(Integer.parseInt(sid));
				model.setName(request.getParameter("subname"));

				boolean b = subServ.updateSubject(model);
				if(b) {
					out.println("<center><h3>Subject Updated<h3></center>");
				}
				else {
					out.println("<center><h3>Subject Not Updated<h3></center>");
				}
			}
			 out.println("</div>");
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
