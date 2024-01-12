package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Subject;
import org.ofs.services.StudentServImpl;
import org.ofs.services.StudentServices;

@WebServlet("/getallocatedsubjecttostudent")
public class GetAllocatedSubjectToStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int stid = Integer.parseInt(request.getParameter("id"));

		out.println("<DIV class='subtotrainer' id='allocatedsubject'>");
		StudentServices sServ = new StudentServImpl();
		List <Subject> slist = sServ.getAllocatedSubjectOfStudent(stid);

		if(slist==null) {
			out.println("<H1>Subject is Not Allocated...</H1>");
		}else {
			int count=0;
			out.println("<TABLE>");
				out.println("<CAPTION>Allocated Subject</CAPTION>");
				out.println("<TR>");
					out.println("<TH>Sr.No</TH><TH>Subject</TH><TH>Remove Subject</TH>");
				out.println("</TR>");

				for(Subject s: slist) {
					out.println("<TR>");
					out.println("<TD>"+(++count)+"</TD><TD>"+s.getName()+"</TD><TD><BUTTON onClick='removeAllocatedSubject("+stid+","+s.getSubid()+")'>Remove</BUTTON></TD>");
					out.println("</TR>");
				}

			out.println("</TABLE>");
		}
		out.println("</DIV>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
