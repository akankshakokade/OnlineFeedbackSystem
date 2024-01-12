package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.TrainerReg;
import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;

@WebServlet("/updatetrainerdata")
public class UpdateTrainerData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int tid = Integer.parseInt(request.getParameter("tid"));
		TrainerServices tServ = new TrainerServicesImpl();
		TrainerReg trainer = tServ.getTrainer(tid);
	//	out.println("<>");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Update Trainer Data</TITLE>");
		out.println("<link rel='stylesheet' href='CSS/viewalltrainer.css'>");
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
	//personal info
		out.println("<FORM  class='pi-data' name='frm' action='' method='POST'>");
			out.println("<TABLE>");
			out.println("<caption><h2>Personal Information<h2><caption>");
				out.println("<TR>");
					out.println("<TH>Id:</TH><TD><input class='id' type='text' name='tid' value='"+trainer.getId()+"' disabled></TD>");
				out.println("</TR>");
				out.println("<TR>");
					out.println("<TH>Name:</TH><TD><input type='text' name='name' value='"+trainer.getName()+"' placeholder='Enter Name' required></TD>");
				out.println("</TR>");
				out.println("<TR>");
					out.println("<TH>E-Mail:</TH><TD><input type='email' name='email' value='"+trainer.getEmail()+"' placeholder='Enter Name' required></TD>");
				out.println("</TR>");
				out.println("<TR>");
					out.println("<TH>Contact No:</TH><TD><input type='text' name='contact' value='"+trainer.getContact()+"' placeholder='Enter Name' required></TD>");
				out.println("</TR>");
				out.println("<TR>");
					out.println("<TH>Date Of Birth:</TH><TD><input type='date' name='dob' value='"+trainer.getDob()+"' placeholder='Enter Name' required></TD>");
				out.println("</TR>");
				out.println("<TR>");
					out.println("<TH>Experience:</TH><TD><input type='text' name='exp' value='"+trainer.getExp()+"' placeholder='Enter Experience' required></TD>");
				out.println("</TR>");
				out.println("<TR>");
				out.println("<TH>Status:</TH>");
					out.println("<TD><SELECT name='status'>");
						if(trainer.getStatus()==1) {
							out.println("<OPTION SELECTED name='status' value='"+1+"'>Enable</OPTION>");
							out.println("<OPTION name='status' value='"+0+"'>Disable</OPTION>");
						}
						else {
							out.println("<OPTION SELECTED name='status' value='"+0+"'>Disable</OPTION>");
							out.println("<OPTION name='status' value='"+1+"'>Enable</OPTION>");
						}
					out.println("</SELECT></TD>");
			out.println("</TR>");
			out.println("</TABLE>");
			out.println("<DIV class='up-btn'>");
			out.println("<INPUT type='submit' value='Update' name='s'>");
			out.println("</DIV>");
		out.println("</FORM>");
		if(request.getParameter("s")!=null) {
			TrainerReg tr = new TrainerReg();
			tr.setId(tid);
			tr.setName(request.getParameter("name"));
			tr.setEmail(request.getParameter("email"));
			tr.setContact(request.getParameter("contact"));
			tr.setDob(request.getParameter("dob"));			//date of birth
			tr.setExp(Integer.parseInt(request.getParameter("exp")));
			tr.setStatus(Integer.parseInt(request.getParameter("status")));

			boolean val = tServ.updateTrainer(tr);
			if(val)
				out.println("<center>Updated Successfully</center>");
			else
				out.println("<center>Not Updated</center>");
		}
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
