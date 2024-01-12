package org.ofs.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBConfigure {
	protected Statement stmt;
	protected PreparedStatement pst;
	protected ResultSet rs;
	protected Connection con;

	DBConfigure(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefeedbacksystem","root","Tushar");

			if(con!=null) {
				System.out.println("Connected");
			}
			else {
				System.out.println("Not Connected");
			}
		} catch (Exception ex) {
			System.out.println("Error is "+ex);
		}
	}

}
