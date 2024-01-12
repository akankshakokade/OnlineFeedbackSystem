package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;

@WebServlet("/allocatesubjecttotrainerr")
public class AllocateSubjectTo_Trainer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int tid = Integer.parseInt(request.getParameter("tid"));
		int subid = Integer.parseInt(request.getParameter("subid"));
		TrainerServices tServ = new TrainerServicesImpl();
		out.println("<TR id='output'>");
		boolean b = tServ.allocateSubjectToTrainer(tid, subid);
			if(b) {
				out.println("<TD colspan='2'><H4>Subject Allocated</H4></TD>");
			}
			else {
				out.println("<TD colspan='2'><H4>Subject Not Allocated</H4></TD>");
			}
		out.println("</TR>");

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
