package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Questions;
import org.ofs.services.AdminServices;
import org.ofs.services.AdminServicesImpl;

@WebServlet("/deletefeedbackquestion")
public class DeleteFeedbackQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int qtn = Integer.parseInt(request.getParameter("qtn"));

		AdminServices aServ = new AdminServicesImpl();
		aServ.deleteQuestion(qtn);
		List <Questions> list = aServ.getQuestions();
		out.println(  "<div id='question'>"
				+ "<table>"
				+ "<thead>"
				+ "<tr><th>Sr .N0</th><th>Questions</th><th>Delete</th></tr>"
				+ "</thead>"
				+ "<tbody>");
		int count = 1;
		for(Questions str : list) {
			out.println(  "<tr><td>"+(count++)+"</td><td>"+str.getQuestion()+"</td><td><button onClick='deleteQuestion("+str.getId()+")'>Delete</button></td></tr>");
		}
		out.println(  "</tbody>"
				+ "</table>"
				+ "</div>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
