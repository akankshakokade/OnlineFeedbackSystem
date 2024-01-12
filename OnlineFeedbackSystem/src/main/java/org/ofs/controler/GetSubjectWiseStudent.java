package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Student;
import org.ofs.services.SubjectServiceImpl;
import org.ofs.services.SubjectServices;


@WebServlet("/GetSubjectWiseStudent")
public class GetSubjectWiseStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id= Integer.parseInt(request.getParameter("id"));
		SubjectServices sServ = new SubjectServiceImpl();
		List<Student>sList = sServ.getSubjectWiseStudnet(id);

		out.println("<DIV class='trainer-table' id='subjectwisestudent'>");
			out.println("<TABLE>");
			out.println("<THEAD>");
			out.println("<TR>");
				out.println("<TH>Id</TH><TH>Name</TH><TH>E-Mail</TH><TH>Contact</TH><TH>View</TH>");
			out.println("</TR>");
			out.println("</THEAD>");
			out.println("<TBODY>");
			for(Student tr : sList) {
				out.println("<TR>");
				out.println("<TD>"+tr.getSid()+"</TD><TD>"+tr.getStuname()+"</TD><TD>"+tr.getEmail()+"</TD><TD>"+tr.getContact()+"</TD><TD><A href='indivisualstudentview?id="+tr.getSid()+"'>View</A></TD>");
				out.println("</TR>");
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
