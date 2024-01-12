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

@WebServlet("/adminprofile")
public class AdminProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String email =(String) session.getAttribute("email");
		AdminServices aServ = new AdminServicesImpl();
		Admin admin = aServ.getAdmin(email);

		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Admin Profile</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"CSS/adminprofile.css\"/>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class='container'>\r\n"
				+ "        <form action='' method=''>\r\n"
				+ "        	<div class='form-group img'>\r\n"
				+ "      </div>\r\n"
				+ "            <div class='form-group'>\r\n"
				+ "                <h2>Update Profile</h2>\r\n"
				+ "            </div>\r\n"
				+ "            <div class='form-group'>\r\n"
				+ "                <label for='id'>ID:</label><span id=''></span>\r\n"
				+ "                <input type='text' id='id' name='id' value='"+admin.getAid()+"' disabled >\r\n"
				+ "            </div>\r\n"
				+ "            <div class='form-group'>\r\n"
				+ "                <label for='name'>Name:</label><span id=''></span>\r\n"
				+ "                <p><input type='text' id='name' name='name' value='"+admin.getName()+"' placeholder='Enter name' required><a href=''>Update</a></p>\r\n"
				+ "            </div>\r\n"
				+ "            <div class='form-group'>\r\n"
				+ "                <label for='email'>Email:</label><span id=''></span>\r\n"
				+ "                <p><input type='email' id='email' name='email' value='"+admin.getEmail()+"' placeholder='Enter email' required><a href=''>Update</a></p>\r\n"
				+ "            </div>\r\n"
				+ "            <div class='form-group'>\r\n"
				+ "                <label for='contact'>Contact:</label><span id=''></span>\r\n"
				+ "                <p><input type='contact' id='contact' name='contact' value='"+admin.getContact()+"' placeholder='Enter contact' required><a href=''>Update</a></p>\r\n"
				+ "            </div>\r\n"
				+ "            <div class='form-group'>\r\n"
				+ "                <a href=''>Change Password</a>"
				+ "				 </div>\r\n"
				+ "        </form>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
