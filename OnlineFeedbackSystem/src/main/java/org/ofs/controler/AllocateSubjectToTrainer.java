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

import org.ofs.model.Subject;
import org.ofs.model.TrainerReg;
import org.ofs.services.SubjectServiceImpl;
import org.ofs.services.SubjectServices;
import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;

@WebServlet("/allocatesubjecttotrainer")
public class AllocateSubjectToTrainer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Allocate Subject To Trainer</TITLE>");
		out.println("<link rel='stylesheet' href='CSS/student.css'>");
		out.println("<script type='text/javascript' src='JS/searchtrainer.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<DIV class='stuport'>");

		out.println("<DIV class='subtotrainer'>");
		out.println("<TABLE>");
		out.println("<CAPTION>Allocate Subject To Trainer</CAPTION>");

		out.println("<TR>");
		out.println("<TH>Trainer</TH><TH>Subject</TH>");
		out.println("</TR>");
		out.println("<TR>");
		TrainerServices tServ = new TrainerServicesImpl();
		List<TrainerReg> tlist = tServ.getTrainer();
				out.println( "<TD><SELECT name='tid' id='tid' onChange='getSubject(this.value)'>");
				out.println( "<OPTION selected hidden>Select Trainer</OPTION>");
				for(TrainerReg model : tlist) {
					if(model.getStatus()==1) {
						out.println( "<OPTION value='"+model.getId()+"'>"+model.getName()+"</OPTION>");
					}
				}
				out.println( "</SELECT></TD>");
		SubjectServices sServ = new SubjectServiceImpl();
		List<Subject>slist = sServ.getSubjects();
				out.println( "<TD><SELECT name='sid' id='subid'>");
				out.println( "<OPTION selected hidden>Select Subject</OPTION>");
				for(Subject model : slist) {
					if(model.getStatus()==1) {
						out.println( "<OPTION value='"+model.getSubid()+"'>"+model.getName()+"</OPTION>");
					}
				}
				out.println( "</SELECT></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD colspan='2'><input type='button' name='s' onClick='getSub()' value='Allocate-Subject'></TD>");
		out.println("</TR>");

		out.println("<TR id='output'>");
		out.println("</TR>");

		out.println("</TABLE>");
		out.println("</DIV>");

		out.println("<DIV id='allocatedsubject'>");
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
