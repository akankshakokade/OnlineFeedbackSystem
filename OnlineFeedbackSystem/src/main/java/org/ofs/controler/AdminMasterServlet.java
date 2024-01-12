package org.ofs.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ofs.model.Admin;
import org.ofs.services.AdminServices;
import org.ofs.services.AdminServicesImpl;

@WebServlet("/adminmasterservlet")
public class AdminMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	//	out.println("");
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Admin Panel</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"CSS/adminmaster.css\"/>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"nav\">\r\n"
				+ "        <div class=\"title\">\r\n"
				+ "            <h2>Feedback-System</h2>\r\n"
				+ "        </div>\r\n"
				+ "        <ul>\r\n"
				+ "            <li><a href='logout'>Log-Out</a></li>\r\n"
				+ "            <li class=\"dropdown-btn\">Profile\r\n");
				HttpSession session = request.getSession();
				String id = (String) session.getAttribute("email");
				AdminServices aServ = new AdminServicesImpl();
				Admin admin = aServ.getAdmin(id);

				if(admin!=null) {
					out.println("      <div class=\"profile-dropdown\">\r\n"
							+ "                    <p><h3>"+admin.getAid()+"</h3></p>\r\n"
							+ "                    <p><h3>"+admin.getName()+"</h3></p>\r\n"
							+ "                    <p><h3>"+admin.getEmail()+"</h3></p>\r\n"
							+ "                    <p><h3>"+admin.getContact()+"</h3></p>\r\n"
							+ "                    <p><a href=\"adminprofile\">View Profile</a></p>\r\n"
							+ "        </div>\r\n");
				}

				out.println("  </li>\r\n"
				+ "            <li><a href=\"adminmasterservlet\">Home</a></li>\r\n"
				+ "        </ul>\r\n"
				+ "    </div>\r\n"
				+ "    <div class=\"menu\">\r\n"
				+ "        <div class=\"branding\">\r\n"
				+ "            <center><h1>SoftTech</h1></center>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"submenu\">\r\n"
				+ "            <ul>\r\n"
				+ "                <li class=\"dropdown-btn\"><h4>Subject</h4>\r\n"
				+ "                    <div class=\"dropdown-container\">\r\n"
				+ "                        <p><a href=\"addsubject\">Add New Subject</a></p>\r\n"
				+ "                        <p><a href=\"allsubject\">View All Subjects</a></p>\r\n"
				+ "                        <p><a href=\"updatesubject\">Update  Subject</a></p>\r\n"
				+ "                        <p><a href=\"subjectstatus\">Subject status</a></p>\r\n"
				+ "                    </div>	\r\n"
				+ "                </li>\r\n"
				+ "                <li class=\"dropdown-btn\"><h4>Trainer</h4>\r\n"
				+ "                     <div class=\"dropdown-container\">\r\n"
				+ "                        <p><a href=\"../OnlineFeedbackSystem/registertrainer\">Add Trainer</a></p>\r\n"
				+ "                        <p><a href=\"../OnlineFeedbackSystem/viewalltrainer\">All Trainers</a></p>\r\n"
				+ "                        <p><a href=\"../OnlineFeedbackSystem/updatetrainer\">Update Trainer</a></p>\r\n"
				+ "                     </div>\r\n"
				+ "                </li>\r\n"
				+ "                <li class=\"dropdown-btn\"><h4>Student</h4>\r\n"
				+ "                    <div class=\"dropdown-container\">\r\n"
				+ "                        <p><a href='registerstudent'>Add Student</a></p>\r\n"
				+ "                        <p><a href='viewstudents'>Edit Student</a></p>"
				+ "                    </div>\r\n"
				+ "                </li>\r\n"
				+ "                <li class=\"dropdown-btn\"><h4>Allocation</h4>\r\n"
				+ "                    <div class=\"dropdown-container\">\r\n"
				+ "                        <p><a href='allocatesubjecttotrainer'>Trainer to Subject</a></p>\r\n"
				+ "                        <p><a href='allocatesubjecttostudent'>Student to Subject</a></p>\r\n"
				+ "                </div></li>\r\n"
				+ "                <li class=\"dropdown-btn\"><h4>FeedBack Form</h4>\r\n"
				+ "                    <div class=\"dropdown-container\">\r\n"
				+ "                        <p><a href='feedbackquestions'>Add Quetions</a></p>\r\n"
				+ "                </div></li>\r\n"
				+ "                <li class=\"dropdown-btn\"><h4>Reports</h4>\r\n"
				+ "                    <div class=\"dropdown-container\">\r\n"
				+ "                        <p><a href='subjectwisetrainer'>Subject wise trainer</a></p>\r\n"
				+ "                        <p><a href='subjectwisestudent'>Subject wise student</a></p>\r\n"
				+ "                        <p><a href=\"#\">Subject wise student count</a></p>\r\n"
				+ "                        <p><a href=\"#\">Subject wise trainer count</a></p>\r\n"
				+ "                        <p><a href=\"#\">Trainer wise review</a></p>\r\n"
				+ "                        <p><a href=\"#\">Trainer wise negative review</a></p>\r\n"
				+ "                        <p><a href=\"#\">Trainer wise positive review</a></p>\r\n"
				+ "                        <p><a href=\"#\">Student wise review</a></p>\r\n"
				+ "                        <p><a href=\"#\">Details</a></p>\r\n"
				+ "                </div></li>\r\n"
				+ "            </ul>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "    <!--- <div class=\"port\">\r\n"
				+ "        \r\n"
				+ "    </div> --->\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
