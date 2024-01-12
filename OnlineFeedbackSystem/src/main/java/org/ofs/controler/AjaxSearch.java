package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Skill;
import org.ofs.model.TrainerReg;
import org.ofs.services.SkillServImpl;
import org.ofs.services.SkillServices;
import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;

@WebServlet("/searchtrainer")
public class AjaxSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if(Integer.parseInt(request.getParameter("page"))==1) {
			String str = request.getParameter("data");
			String searchBy = request.getParameter("searchby");

			out.println("<DIV id='searchTrainers'>");
			out.println("<TABLE>");
			out.println("<THEAD>");
			out.println("<TR><TH class='th-size'>ID</TH>"
					+ "<TH class='tdm-size'>NAME</TH>"
					+ "<TH class='tdc-size'>CONTACT</TH>"
					+ "<TH class='tdm-size'>E-Mail</TH>"
					+ "<TH class='th-size'>DETAILS</TH></TR>");
			out.println("</THEAD>");
			out.println("<TBODY>");

				TrainerServices tServ = new TrainerServicesImpl();
				List <TrainerReg>tlist = tServ.getTrainer(str,searchBy);
				for(TrainerReg tr : tlist) {
					out.println("<TR>"
							+ "<TD  class='th-size'>"+tr.getId()+"</TD>"
							+ "<TD  class='tdm-size'>"+tr.getName()+"</TD>"
							+ "<TD  class='tdc-size'>"+tr.getContact()+"</TD>"
							+ "<TD  class='tdm-size'>"+tr.getEmail()+"</TD>"
							+ "<TD  class='th-size'><a class='a-btn1' href='individualtrainerview?tid="+tr.getId()+"'>Full-Details</a></TD>"
							+ "</TR>");
				}
			out.println("</TBODY>");
			out.println("</TABLE>");
			out.println("</DIV>");
		}else if(Integer.parseInt(request.getParameter("page"))==2){
			String str = request.getParameter("data");
			String searchBy = request.getParameter("searchby");

			out.println("<DIV id='searchTrainers'>");
			out.println("<TABLE>");
			out.println("<THEAD>");
			out.println("<TR><TH class='th-size'>ID</TH>"
					+ "<TH>NAME</TH>"
					+ "<TH class='update-tr'>Current Status</TH>"
					+ "<TH class='update-tr'>Update Trainer</TH>"
					+ "<TH class='update-tr'>Delete Trainer</TH></TR>");
			out.println("</THEAD>");
			out.println("<TBODY>");
				TrainerServices tServ = new TrainerServicesImpl();
				List <TrainerReg>tlist = tServ.getTrainer(str,searchBy);
			for(TrainerReg tr : tlist) {
				out.println("<TR>"
						+ "<TD  class='th-size'>"+tr.getId()+"</TD>"
						+ "<TD>"+tr.getName()+"</TD>");
						if(tr.getStatus()==1) {
							out.println("<TD><input type='button' onClick='trainerStatus("+tr.getId()+","+0+")' value='Enable'></TD>");
						}else {
							out.println("<TD class='disable-btn'><input type='button' onClick='trainerStatus("+tr.getId()+","+1+")' value='Disable'></TD>");
						}
						out.println("<TD><a class='a-btn' href='updatetrainerdata?tid="+tr.getId()+"'>Update</a></TD>"
						+ "<TD><input type='button' onClick='trainerDelete("+tr.getId()+")' value='Delete'></TD>"
						+ "</TR>");
			}
			out.println("</TBODY>");
			out.println("</TABLE>");
			out.println("</DIV>");
		}else if(Integer.parseInt(request.getParameter("page"))==3) {

			int tid = Integer.parseInt(request.getParameter("tid"));

			SkillServices sServ = new SkillServImpl();
			List<Skill> slist = sServ.getTrainerSkill(tid);
			out.println("<DIV id='skillcontainer'>");
			out.println("<TABLE>");
			out.println("<caption><h2>Skills<h2><caption>");
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
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}