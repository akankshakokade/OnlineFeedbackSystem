package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Skill;
import org.ofs.services.SkillServImpl;
import org.ofs.services.SkillServices;

@WebServlet("/addskill")
public class AddSkill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sname = request.getParameter("skname");

		Skill sk = new Skill();
		sk.setName(sname);

		SkillServices sServ = new SkillServImpl();
		boolean b = sServ.addSkill(sk);
		out.println("<div id='addskills'>");
		if(b)
			out.println("Skill added");
		else
			out.println("Skill Not Added");
		out.println("</div>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
