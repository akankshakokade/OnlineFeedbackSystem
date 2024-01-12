package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ofs.model.Admin;
import org.ofs.services.AdminServicesImpl;


@WebServlet("/validadmin")
public class ValidAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Admin model = new Admin();
		model.setEmail(request.getParameter("user"));
		model.setPassword(request.getParameter("pass"));

		boolean b = new AdminServicesImpl().isValid(model);

		if(b) {
			RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
			rd.forward(request, response);
			HttpSession session = request.getSession(true);
			session.setAttribute("email", model.getEmail());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("adminlogin.html");
			rd.include(request, response);
			out.println("<center><h1>Invalid Username and Password</h1></center>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
