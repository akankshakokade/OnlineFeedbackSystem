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

import org.ofs.model.Collage;
import org.ofs.model.University;
import org.ofs.services.CollageServImpl;
import org.ofs.services.CollageServices;
import org.ofs.services.UniversityServices;
import org.ofs.services.UniversityServicesImpl;

@WebServlet("/addcollege")
public class AddCollege extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	//	out.println("");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Add New College</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/adddata.css'>");
		out.println("<LINK rel='stylesheet' href='CSS/adminmaster.css'>");
		out.println("<script type='text/javascript' src='JS/Qualification.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<div class='port'>");
		out.println("<div class='container'>");
		out.println("<form name='frm' action='' method='Post'>");

			out.println("<div><h2>Add New College</h2></div>");
	        out.println("<div><input type='text' name='clgname' value='' id='' placeholder='Enter Collage Name' required/></div>");
	        out.println("<div><select name='uid'>");
	        UniversityServices uServ = new UniversityServicesImpl();
	        List<University> ulist = uServ.getUniversitys();
	        out.println("<option selected hidden>Select University</option>");
	        for(University uni: ulist) {
	        	out.println("<option value='"+uni.getUid()+"'>"+uni.getName()+"</option>");
	        }
	        out.println("</select></div>");
	        out.println("<div><input type='button' onClick='addUniversity()' value='Add New University'></div>");
	        out.println("<div id='adduni'></div>");
	        out.println("<input type='submit' name='s' value='Add College' class='btn' />");

	        out.println("</form>");
//	    	page submit

			if(request.getParameter("s")!=null) {
				Collage model = new Collage();
				model.setUid(Integer.parseInt(request.getParameter("uid")));
				model.setName(request.getParameter("clgname"));
				CollageServices cServ = new CollageServImpl();
				boolean b = cServ.addCollage(model);
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

		doGet(request, response);
	}

}
