package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.TrainerReg;
import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;

@WebServlet("/deletetrainer")
public class TrainerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int tid = Integer.parseInt(request.getParameter("tid"));

		TrainerServices tServ = new TrainerServicesImpl();
		tServ.deleteTrainer(tid);
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
			List <TrainerReg>tlist = tServ.getTrainer();
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
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
