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
import org.ofs.model.Subject;
import org.ofs.services.StudentServImpl;
import org.ofs.services.StudentServices;

@WebServlet("/indivisualstudentview")
public class IndivisualStudentView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		List<Subject>sublist = null;

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Add New College</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/student.css'>");
		out.println("</HEAD>");
		out.println("<BODY class='ind-container'>"
				+ "<div class='info-container'>");
			StudentServices sServ = new StudentServImpl();
			Student s = sServ.getStudent(id);
		out.println("<h1 id='heading'>Student Details</h1>"
				+ "<div class='ind1'>"
				+ "<lable >Name: </lable><div>"+s.getStuname()+"</div>"
				+ "<lable >E-Mail: </lable><div>"+s.getEmail()+"</div>"
				+ "<lable >Address: </lable><div>"+s.getAddress()+"</div>"
				+ "</div>"
				+ "<div class='ind2'>"
				+ "<lable >Contact: </lable><div>"+s.getContact()+"</div>");
				if(s.getStatus()==1)
					out.println("<lable >Status: </lable><div>Enable</div><br>");
				else
					out.println("<lable >Status: </lable><div>Disable</div><br>");
				out.println( "<lable >Date Of Birth: </lable><div>"+s.getDob()+"</div>"
				+ "</div>");

			//Allocated Subject
				int count = 0;
				sublist = sServ.getAllocatedSubjectOfStudent(id);
				if(sublist!=null) {
					out.println("<DIV class='subtotrainer'>");
					out.println("<TABLE>");
					out.println("<caption>Allocated Subject<caption>");
					out.println("<TR>");
						out.println("<TH>Sr.No</TH><TH>Subject Name</TH>");
					out.println("</TR>");

					for(Subject s1 : sublist) {
						out.println("<TR>");
						out.println("<TD>"+(++count)+"</TD><TD>"+s1.getName()+"</TD>");
						out.println("</TR>");
					}
					out.println("</TABLE>");
					out.println("</DIV>");

					out.println("<a class='back-btn' onClick='history.back()'>Go-Back</a>");
					out.println("</div>");
				}
		out.println("</BODY>");
		out.println("</HTML>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
