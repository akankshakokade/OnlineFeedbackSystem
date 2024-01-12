package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Collage;
import org.ofs.model.Degree;
import org.ofs.services.CollageServImpl;
import org.ofs.services.CollageServices;
import org.ofs.services.DegreeServImpl;
import org.ofs.services.DegreeServices;
import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;

@WebServlet("/trainerqualification")
public class TrainerQualification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//use url rewriting for tid
		int tid = Integer.parseInt(request.getParameter("tid"));

		TrainerServices tServ = new TrainerServicesImpl();
	//	out.println("<>");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Update Trainer Data</TITLE>");
		out.println("<link rel='stylesheet' href='CSS/viewalltrainer.css'>");
		out.println("<LINK rel='stylesheet' href='CSS/trainerregistration.css'>");
		out.println("<script type='text/javascript' src='JS/searchtrainer.js'></script>");
		out.println("<script type='text/javascript' src='JS/Qualification.js'></script>");

		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<DIV class='port4'>");

		out.println("<DIV class='psk-container'>");
		out.println("<ul class='update-nav'>");
		out.println("<li ><a href='updatetrainerdata?tid="+tid+"'>Update Personale Information</a></li>");
		out.println("<li ><a href='updatetrainerskill?tid="+tid+"'>Update Skill</a></li>");
		out.println("<li ><a href='trainerqualification?tid="+tid+"'>Update Qualification</a></li>");
		out.println("</ul>");
	//Qualification
			Vector<Object[]> v = tServ.getTrainerQualification(tid);
			out.println("<div id='qli'>");
			out.println("<DIV class='quali-table'>");
			out.println("<TABLE>");
			out.println("<caption><h2>Qualification:</h2></caption>");
			out.println("<TR>");
				out.println("<TH class='update-tr'>Degree</TH>"
						+ "<TH>College Name</TH>"
						+ "<TH class='update-tr'>University</TH>"
						+ "<TH class='update-tr'>Delete</TH>");
			out.println("</TR>");

			for(Object sk[] : v) {
				out.println("<TR>");
					out.println("<TD class='update-tr'>"+sk[1]+"</TD>"		//degree
							+ "<TD>"+sk[3]+"</TD>"			//college
							+ "<TD class='update-tr'>"+sk[4]+"</TD>");		//university
					int degree = (int) sk[0];
					int cid = (int) sk[2];
				out.println("<TD class='update-tr'><input type='button' onClick='deleteQualifi("+tid+","+degree+","+cid+")' value='Delete'></TD>");
				out.println("</TR>");
			}
			out.println("</TABLE>");
			out.println("</DIV>");
			out.println("</div>");
	//update qualification
			out.println("<DIV class='psk-container quali-container'>");
			out.println("<form name='frm' action='' method='POST' class='container container2'>");
			//College
			out.println("<div class='element'>"
					+ "	<center><h2>Add Qualification</h2></center>"
					+ "	</div>");
			out.println("<div class='element'>");
			out.println("<h3>NOTE:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;If you want to add multiple Qualification, add one "
					+ "by one and after that Click on Profile Complete.</h3>");
			out.println("</div>");

				out.println("<div class='element'>");
				CollageServices cServ = new CollageServImpl();
				List <Collage>list = cServ.getCollages();
				out.println("<label for='cid'>Select College:</label>");
				out.println("<select id='cid' name='clgid'>");
				for(Collage clg : list) {
					out.println("<option value='"+clg.getClgid()+"'>"+clg.getName()+"</option>");
				}
				out.println("</select><br>");
				out.println("</div>");

				out.println("<div class='element'>");
				out.println("<a href='addcollege'>Add New Colllage</a>");
				out.println("</div>");

			//Degrees
				out.println("<div class='element'>");
				DegreeServices dServ = new DegreeServImpl();
				List <Degree>dlist = dServ.getDegrees();
				out.println("<label for='dg'>Select Degree:</label>");
				out.println("<select id='dg' name='dgid'>");
				for(Degree dgr : dlist) {
					out.println("<option value='"+dgr.getDid()+"'>"+dgr.getName()+"</option>");
				}
				out.println("</select><br>");
				out.println("</div>");

				out.println("<div class='college-container1'>");
				out.println("<input type='button' onclick='addDegree()' value='Add New Degree'>");
				out.println("<div id='adddegree'></div>");
				out.println("</div>");

				out.println("<div class='element btn'>"
				+ "                <input type='submit' id='s' name='s' value='Add Qualification'/>"
				+ "                <span id=''></span>"
				+ "          </div>");
		        out.println("</form>");
			//page submission
				String btn = request.getParameter("s");
				if(btn!=null) {
					try {
						int clgid = Integer.parseInt(request.getParameter("clgid"));
						int dgid = Integer.parseInt(request.getParameter("dgid"));

						TrainerServices tServ1 = new TrainerServicesImpl();
						boolean b = tServ1.addTrainerQualification(tid, clgid, dgid);
						if(b) {
							RequestDispatcher rd1 = request.getRequestDispatcher("trainerqualification");
							rd1.forward(request, response);
						}
					}catch(Exception ex) {
						out.println("<center>Please Select College/Degree</center>");
					}
				}
		        out.println("<div>");
		        out.println("<div class='profile-btn'>"
		    			+ "                <a href='updatetrainer'>Back</a>"
		    			+ "          </div>");
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
