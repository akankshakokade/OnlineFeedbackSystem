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

import org.ofs.model.Collage;
import org.ofs.model.Degree;
import org.ofs.model.Skill;
import org.ofs.model.TrainerReg;
import org.ofs.services.CollageServImpl;
import org.ofs.services.CollageServices;
import org.ofs.services.DegreeServImpl;
import org.ofs.services.DegreeServices;
import org.ofs.services.SkillServImpl;
import org.ofs.services.SkillServices;
import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;

@WebServlet("/registertrainer")
public class TrainerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	//	out.println("");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Register Trainer</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/trainerregistration.css'>");
		out.println("<script type='text/javascript' src='JS/Qualification.js'></script>");
		out.println("<script type='text/javascript' src='JS/validation.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<div class='port1'>");
		out.println("<form name='frm' action='' method='POST' class='container'>");

			out.println("			<div class='element'>"
					+ "				<center><h2>Add New Trainer</h2></center>"
					+ "				</div>"
					+ "				<div class='element'>\r\n"
					+ "                <label for='name'>Name :</label><span id='validname'></span>\r\n"
					+ "                <input type='text' id='name' onKeyUp='nameValidation(this.value)' name='name' value='' placeholder='Enter Name' required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class='element'>\r\n"
					+ "                <label for='email'>E-Mail:</label><span id='validemail'></span>\r\n"
					+ "                <input type='email' id='email' name='email' onKeyUp='emailValidation(this.value)' value='' placeholder='Enter Email' required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class='element'>\r\n"
					+ "                <label for='contact'>Contact:</label><span id='validcontact'></span>\r\n"
					+ "                <input type='text' id='contact' name='contact' onKeyUp='contactValidation(this.value)' value='' placeholder='Enter Contact' maxlenght='10' required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class='element dob-btn'>\r\n"
					+ "                <label for='dob'>Date Of Birth:</label><span id='validdate'></span>\r\n"
					+ "                <input type='date' id='dob' name='dob' value='' onChange='validdate()' required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class='element'>\r\n"
					+ "                <label for='expe'>Experience:</label><span id=''></span>\r\n"
					+ "                <input type='text' id='expe' name='expe' value='' placeholder='Enter Experience' required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class='element'>\r\n"
					+ "                <label for='pass'>Password:</label><span id=''></span>\r\n"
					+ "                <input type='password' id='pass' name='pass' value='' placeholder='Enter Password' required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class='element'>\r\n"
					+ "                <label for='cpass'>Conform Password:</label><span id=''></span>\r\n"
					+ "                <input type='password' id='cpass' name='cpass' value='' placeholder='Conform Password'>\r\n"
					+ "            </div>\r\n");
		//College
			out.println("<div class='element'>");
			CollageServices cServ = new CollageServImpl();
			List <Collage>list = cServ.getCollages();
			out.println("<label for='cid'>Select College:</label>");
			out.println("<select id='cid' name='clgid'>");
			out.println("<option selected hidden>Select Collage</option>");
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
			out.println("<option selected hidden>Select Degree</option>");
			for(Degree dgr : dlist) {
				out.println("<option value='"+dgr.getDid()+"'>"+dgr.getName()+"</option>");
			}
			out.println("</select><br>");
			out.println("</div>");

			out.println("<div class='college-container1'>");
			out.println("<input type='button' onclick='addDegree()' value='Add New Degree'>");
			out.println("<div id='adddegree'></div>");
			out.println("</div>");
		//skills
			out.println("<div class='skill-container'>");
			SkillServices skServ = new SkillServImpl();
			List <Skill>sklist = skServ.getSkills();
			if(sklist!=null) {
				Skill skl;
				Iterator<Skill> i = sklist.iterator();
				out.println("<caption>Select Skills:</caption>");
				out.println("<table>");
				while(i.hasNext()) {
					skl = new Skill();
					skl = i.next();
					out.println("<tr><td><input type='checkbox' name='skil' value='"+skl.getSkid()+"'/>"+skl.getName()+"</td>");
					if(i.hasNext()) {
					skl = i.next();
						out.println("<td><input type='checkbox' name='skil' value='"+skl.getSkid()+"'/>"+skl.getName()+"</td>");
					}
					if(i.hasNext()) {
						skl = i.next();
							out.println("<td><input type='checkbox' name='skil' value='"+skl.getSkid()+"'/>"+skl.getName()+"</td></tr>");
					}
				}
				out.println("</table>");
			}else {
				out.println("<h2>data is not present<h2>");
			}
			out.println("</div>");

			out.println("<div class='college-container1'>");
			out.println("<input type='button' onclick='addSkill()' value='Add New Skill'>");
			out.println("<div id='addskills'></div>");
			out.println("</div>");

			out.println("<div class='element btn'>"
			+ "                <input type='submit' id='s' name='s' value='Register'/>"
			+ "                <span id=''></span>"
			+ "          </div>");
	        out.println("</form>");
			//page submission
			String btn = request.getParameter("s");
			if(btn!=null) {
				TrainerReg tr = new TrainerReg();
				tr.setName(request.getParameter("name"));
				tr.setEmail(request.getParameter("email"));
				tr.setContact(request.getParameter("contact"));
				tr.setDob(request.getParameter("dob"));			//date of birth
			//	System.out.println(tr.getDob());
				tr.setExp(Integer.parseInt(request.getParameter("expe")));
			//	System.out.println("exp is"+request.getParameter("expe"));
				tr.setPass(request.getParameter("pass"));

				TrainerServices tServ = new TrainerServicesImpl();
				int val = tServ.addTrainer(tr);
			//	System.out.println("val is = "+val);
				if(val>0) {
					int clgid = Integer.parseInt(request.getParameter("clgid"));
					int dgid = Integer.parseInt(request.getParameter("dgid"));
					String skillarr[] = request.getParameterValues("skil");
					List <Integer> sklistar = new ArrayList<>();
					for(String str : skillarr) {
						sklistar.add(Integer.parseInt(str));
					}
					boolean b2 = tServ.addTrainerQualification(val, clgid, dgid);
					boolean b1 = tServ.addTrainerSkills(val, sklistar);
					if(b1 && b2)
						out.println("<center>data added sucssesfully</center>");
					else
						out.println("<center>data not added</center>");
				}
				else{
					out.println("<center><h2>not updated</h2></center>");
				}
			}

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
