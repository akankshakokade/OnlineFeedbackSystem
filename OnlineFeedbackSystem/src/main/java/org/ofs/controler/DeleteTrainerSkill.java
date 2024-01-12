package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Skill;
import org.ofs.services.SkillServImpl;
import org.ofs.services.SkillServices;
import org.ofs.services.TrainerServices;
import org.ofs.services.TrainerServicesImpl;


@WebServlet("/deletetrainerskill")
public class DeleteTrainerSkill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int tid = Integer.parseInt(request.getParameter("tid"));
		int skid = Integer.parseInt(request.getParameter("skid"));
		TrainerServices tServ = new TrainerServicesImpl();
		tServ.deleteTrainerSkill(tid, skid);

		SkillServices sServ = new SkillServImpl();
		List<Skill> slist = sServ.getTrainerSkill(tid);
		out.println("<DIV id='skillcontainer'>");
		out.println("<TABLE>");
		out.println("<caption><h2>Trainer-Skills</h2></caption>");
		int count=0;
		for(Skill sk : slist) {
			out.println("<TR>");
				out.println("<TD class='update-tr'>"+(++count)+"</TD>"
						+ "<TD class=''>"+sk.getName()+"</TD>"
						+ "<TD class='update-tr'><input type='button' onclick='deleteSkill("+tid+","+sk.getSkid()+")' value='Delete'></TD>");
			out.println("</TR>");
		}
		out.println("</TABLE>");
		out.println("</DIV>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
