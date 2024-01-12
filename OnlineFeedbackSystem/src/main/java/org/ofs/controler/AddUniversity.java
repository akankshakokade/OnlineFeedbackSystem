package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.University;
import org.ofs.services.UniversityServices;
import org.ofs.services.UniversityServicesImpl;


@WebServlet("/adduniversity")
public class AddUniversity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String uniname = request.getParameter("uniname");

		University uni = new University();
		uni.setName(uniname);

		UniversityServices uServ = new UniversityServicesImpl();
		boolean b =uServ.addUniversiity(uni);
		out.println("<div id='adduni'>");
		if(b)
			out.println("University added");
		else
			out.println("University Not Added");
		out.println("</div>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
