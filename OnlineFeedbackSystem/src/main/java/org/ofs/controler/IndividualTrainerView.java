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

import org.ofs.model.Skill;
import org.ofs.model.Subject;
import org.ofs.model.TrainerReg;
import org.ofs.services.SkillServImpl;
import org.ofs.services.SkillServices;
import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;

@WebServlet("/individualtrainerview")
public class IndividualTrainerView extends HttpServlet {
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
		out.println("<TITLE>Indivisual Trainer</TITLE>");
		out.println("<link rel='stylesheet' href='CSS/adminmaster.css'>");
		out.println("<link rel='stylesheet' href='CSS/viewalltrainer.css'>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<DIV class='port1'>");
	//personal info
			out.println("<DIV class='pi-container com-container'>");
			out.println("<TABLE>");
			out.println("<caption cap-bar>Personal Information<caption>");

				out.println("<TR>");
					out.println("<TH>Id :</TH><TD>"+trainer.getId()+"</TD>");
				out.println("</TR>");
				out.println("<TR>");
					out.println("<TH>Name :</TH><TD>"+trainer.getName()+"</TD>");
				out.println("</TR>");
				out.println("<TR>");
					out.println("<TH>E-Mail :</TH><TD>"+trainer.getEmail()+"</TD>");
				out.println("</TR>");
				out.println("<TR>");
					out.println("<TH>Contact No :</TH><TD>"+trainer.getContact()+"</TD>");
				out.println("</TR>");
				out.println("<TR>");
					out.println("<TH>Date Of Birth :</TH><TD>"+trainer.getDob()+"</TD>");
				out.println("</TR>");
				out.println("<TR>");
					if(trainer.getStatus()==1)
						out.println("<TH>Current Status :</TH><TD>Enable</TD>");
					else
						out.println("<TH>Current Status :</TH><TD>Disable</TD>");
				out.println("</TR>");
			out.println("</TABLE>");
			out.println("</DIV>");
	//skills
			out.println("<DIV class='sk-container pi-container com-container'>");
			SkillServices sServ = new SkillServImpl();
			List<Skill> slist = sServ.getTrainerSkill(tid);
			out.println("<TABLE>");
			out.println("<caption class='cap-bar'>Skills<caption>");
			for(Skill sk : slist) {
				out.println("<TR>");
					out.println("<TD>"+sk.getName()+"</TD>");
				out.println("</TR>");
			}
			out.println("</TABLE>");
			out.println("</DIV>");
	//Qualification
			Vector<Object[]> v = tServ.getTrainerQualification(tid);
			out.println("<DIV class='pi-container com-container quali-container margin5'>");
			out.println("<TABLE>");
			out.println("<caption class='cap-bar'>Qualification<caption>");
			out.println("<TR>");
				out.println("<TH>Degree</TH><TH>College Name</TH><TH>University</TH>");
			out.println("</TR>");

			for(Object sk[] : v) {
				out.println("<TR>");
				out.println("<TD>"+sk[1]+"</TD><TD>"+sk[3]+"</TD><TD>"+sk[4]+"</TD>");
				out.println("</TR>");
			}
			out.println("</TABLE>");
			out.println("</DIV>");

	//Allocated Subject
			int count = 0;
			List<Subject>sublist = tServ.getAllocatedSubject(tid);
			out.println("<DIV class='pi-container com-container quali-container margin5'>");
			out.println("<TABLE>");
			out.println("<caption class='cap-bar'>Allocated Subject<caption>");
			out.println("<TR>");
				out.println("<TH>Sr.No</TH><TH>Subject Name</TH>");
			out.println("</TR>");

			for(Subject s : sublist) {
				out.println("<TR>");
				out.println("<TD>"+(++count)+"</TD><TD>"+s.getName()+"</TD>");
				out.println("</TR>");
			}
			out.println("</TABLE>");
			out.println("</DIV>");

			out.println("<DIV class=' back-btn'>");
				out.println("<a onclick='history.back()'>Back</a>");
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
