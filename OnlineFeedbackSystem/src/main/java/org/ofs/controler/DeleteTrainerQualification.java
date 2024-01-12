package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.services.TrainerServicesImpl;

@WebServlet("/deletetrainerqualification")
public class DeleteTrainerQualification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int tid = Integer.parseInt(request.getParameter("tid"));
		int did = Integer.parseInt(request.getParameter("did"));
		int clgid = Integer.parseInt(request.getParameter("clgid"));

		new TrainerServicesImpl().deleteTrainerQualification(tid, did, clgid);
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
			Vector <Object[]>v = new TrainerServicesImpl().getTrainerQualification(tid);
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
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
