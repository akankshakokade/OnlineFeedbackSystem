package org.ofs.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Subject;
import org.ofs.services.SubjectServiceImpl;
import org.ofs.services.SubjectServices;

@WebServlet("/enabledisablesubject")
public class EnableDisableSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Subject sub = new Subject();
		sub.setSubid(Integer.parseInt(request.getParameter("subid")));
		sub.setName(request.getParameter("subname"));
		sub.setStatus(Integer.parseInt(request.getParameter("status")));

		SubjectServices sServ = new SubjectServiceImpl();
		sServ.subjectStatus(sub);

		RequestDispatcher rd = request.getRequestDispatcher("subjectstatus");
		rd.include(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
