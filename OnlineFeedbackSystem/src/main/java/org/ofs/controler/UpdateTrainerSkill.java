package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Skill;
import org.ofs.services.SkillServImpl;
import org.ofs.services.SkillServices;
import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;

@WebServlet("/updatetrainerskill")
public class UpdateTrainerSkill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int tid = Integer.parseInt(request.getParameter("tid"));
	//	out.println("<>");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Update Trainer Skill</TITLE>");
		out.println("<link rel='stylesheet' href='CSS/viewalltrainer.css'>");
		out.println("<script type='text/javascript' src='JS/Qualification.js'></script>");
		out.println("<script type='text/javascript' src='JS/searchtrainer.js'></script>");

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
	//skills
			SkillServices sServ = new SkillServImpl();
			List<Skill> slist = sServ.getTrainerSkill(tid);
			out.println("<DIV class='psk-container'>");
			out.println("<DIV id='skillcontainer'>");
			out.println("<TABLE>");
			out.println("<caption><h2>Trainer-Skills<h2><caption>");
			int count=0;
			for(Skill sk : slist) {
				out.println("<TR>");
					out.println("<TD class='update-tr'>"+(++count)+"</TD>"
							+ "<TD class=''>"+sk.getName()+"</TD>"
							+ "<TD class='update-tr'><input type='button' onclick='deleteSkill("+tid+","+sk.getSkid()+")' value='Delete'></TD>");
				out.println("</TR>");
			}
			out.println("</TABLE>");
			out.println("</DIV>");
			out.println("</DIV>");
	//skills update
			out.println("<form name='frm' action='' method='POST'>");
			out.println("<div class='skup-container'>");
			SkillServices skServ = new SkillServImpl();
			List <Skill>sklist = skServ.getSkills();
			if(sklist!=null) {
				Skill skl;
				Iterator<Skill> i = sklist.iterator();
				out.println("<table>");
				out.println("<caption>Select New Skills For Trainer:</caption>");

				while(i.hasNext()) {
					skl = new Skill();
					skl = i.next();
					out.println("<tr><td><input type='checkbox' name='skil' value='"+skl.getSkid()+"'/>&nbsp;&nbsp;&nbsp;&nbsp;"+skl.getName()+"</td>");
					if(i.hasNext()) {
					skl = i.next();
						out.println("<td><input type='checkbox' name='skil' value='"+skl.getSkid()+"'/>&nbsp;&nbsp;&nbsp;&nbsp;"+skl.getName()+"</td>");
					}
					if(i.hasNext()) {
						skl = i.next();
							out.println("<td><input type='checkbox' name='skil' value='"+skl.getSkid()+"'/>&nbsp;&nbsp;&nbsp;&nbsp;"+skl.getName()+"</td></tr>");
					}
				}
				out.println("</table>");
			}else {
				out.println("<h2>data is not present<h2>");
			}
			out.println("</div>");

			out.println("<div class='addskill'>");
			out.println("<input type='button' onclick='addSkill()' value='Add New Skill'>");
			out.println("<div id='addskills'></div>");
			out.println("</div>");

			out.println("<div class='up-btn'>"
			+ "                <input type='submit' onClick='addnewSkill("+tid+")' id='s' name='s' value='Add Skill'/>"
			+ "          </div>");
	        out.println("</form>");
			//page submission
			String btn = request.getParameter("s");
			if(btn!=null) {
					String skillarr[] = request.getParameterValues("skil");
					if(skillarr!=null) {
						List <Integer> sklistar = new ArrayList<>();
						for(String str : skillarr) {
							sklistar.add(Integer.parseInt(str));
						}
						TrainerServices tServ = new TrainerServicesImpl();
						boolean b1 = tServ.addTrainerSkills(tid, sklistar);
						if(b1)
							out.println("<center>data added sucssesfully</center>");
						else
							out.println("<center>data not added</center>");
					}else {
						out.println("<center>Plese Select Skill</center>");
					}
				}
	        out.println("</div>");
		//
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
