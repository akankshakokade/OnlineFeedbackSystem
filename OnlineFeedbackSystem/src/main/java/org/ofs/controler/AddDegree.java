package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Degree;
import org.ofs.services.DegreeServImpl;
import org.ofs.services.DegreeServices;


@WebServlet("/adddegree")
public class AddDegree extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String dname = request.getParameter("dname");

		Degree dg = new Degree();
		dg.setName(dname);

		DegreeServices dServ = new DegreeServImpl();
		boolean b = dServ.addDegree(dg);
		out.println("<div id='adddegree'>");
		if(b)
			out.println("Degree added");
		else
			out.println("Degree Not Added");
		out.println("</div>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
