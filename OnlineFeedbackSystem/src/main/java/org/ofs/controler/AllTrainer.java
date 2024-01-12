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

import org.ofs.model.TrainerReg;
import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;

@WebServlet("/viewalltrainer")
public class AllTrainer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	//	out.println("<>");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>View All Trainers</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/viewalltrainer.css'>");
		out.println("<script type='text/javascript' src='JS/searchtrainer.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<DIV class='port'>");
		out.println("<DIV class='table-container'>");
		out.println("<DIV class='search-bar'>");
			out.println("<INPUT type='text' onKeyup='searchTrainer(this.value)' Placeholder='Search Here'>");
			out.println("<SELECT id='searchBy'>");
			out.println("<OPTION selected value='name'>Search By Name</OPTION>");
			out.println("<OPTION value='tid'>Search By Id</OPTION>");
			out.println("<OPTION value='email'>Search By E-Mail</OPTION>");
			out.println("<OPTION value='contact'>Search By Contact</OPTION>");
			out.println("</SELECT>");
		out.println("</DIV>");
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
			List <TrainerReg>tlist = tServ.getTrainer();
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
