package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ofs.model.Questions;
import org.ofs.services.AdminServices;
import org.ofs.services.AdminServicesImpl;


@WebServlet("/feedbackquestions")
public class FeedbackQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Update FeedBack form</TITLE>");
		out.println("<LINK rel='stylesheet' href='CSS/adddata.css'>");
		out.println("<script type='text/javascript' src='JS/Qualification.js'></script>");
		out.println("</HEAD>");
		out.println("<BODY>");
		RequestDispatcher rd = request.getRequestDispatcher("adminmasterservlet");
		rd.include(request, response);
		out.println("<div class='port'>");
		out.println("<div class='outer-container'>");
		out.println(  "<div class='inner-container'>"
					+ "<h2>Add Feedback Questions</h2>"
					+ "<textarea placeholder='Enter Questions Here..' id='qtn'></textarea>"
					+ "<input type='button' name='btn' onClick='addQuestion()' value='Add Question'>"
					+ "</div>");
		AdminServices aServ = new AdminServicesImpl();
		List <Questions> list = aServ.getQuestions();
		out.println("<div class='inner-table'>");
		out.println(  "<div id='question'>"
				+ "<table>"
				+ "<thead>"
				+ "<tr><th>Sr .N0</th><th>Questions</th><th>Delete</th></tr>"
				+ "</thead>"
				+ "<tbody>");
		int count = 1;
		for(Questions str : list) {
			out.println(  "<tr><td>"+(count++)+"</td><td>"+str.getQuestion()+"</td><td><input type='button' value='Delete' onClick='deleteQuestion("+str.getId()+")'></td></tr>");
		}
		out.println(  "</tbody>"
				+ "</table>"
				+ "</div>");
		out.println("</div>");
	    out.println("</div>");
	    out.println("</div>");
		out.println("</BODY>");
		out.println("</HTML>");
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
