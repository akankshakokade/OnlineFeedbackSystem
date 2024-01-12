package org.ofs.repository;

import java.util.ArrayList;
import java.util.List;

import org.ofs.model.Admin;
import org.ofs.model.Questions;

public class AdminRepositoryImpl extends DBConfigure implements AdminRepository{

	List <Questions> list;
	@Override
	public boolean isValid(Admin model) {
		try {
			 pst = con.prepareStatement("select * from admin where email=? and password=?");
			 pst.setString(1, model.getEmail());
			 pst.setString(2, model.getPassword());
			 rs = pst.executeQuery();

			 return rs.next() ? true : false;

		}catch(Exception ex) {
			System.out.println("Admin valid Error is "+ex);
			return false;
		}
	}

	@Override
	public Admin getAdmin(String email) {
		try {
			 pst = con.prepareStatement("select * from admin where email=?");
			 pst.setString(1, email);
			 rs = pst.executeQuery();

			 if(rs.next()) {
				 Admin model = new Admin();
				 model.setAid(rs.getInt(1));
				 model.setName(rs.getString(2));
				 model.setEmail(rs.getString(3));
				 model.setContact(rs.getString(4));
				 model.setPassword(rs.getString(5));

				 return model;
			 }else {
				 return null;
			 }
		}catch(Exception ex) {
			System.out.println("Admin valid Error is "+ex);
			return null;
		}
	}

	@Override
	public void addQuestion(String qtn) {
		try {
			pst = con.prepareStatement("insert into feedback_questions values ('0',?)");
			pst.setString(1, qtn);
			int val = pst.executeUpdate();
			if(val>0) {
				System.out.println("Question Added");
			}
			else {
				System.out.println("Question Not Added");
			}
		}catch(Exception ex) {
			System.out.println("error in addQuestions"+ex);
		}
	}

	@Override
	public List<Questions> getQuestions() {
		list = new ArrayList<>();
		try {
			pst = con.prepareStatement("select * from feedback_questions");
			rs = pst.executeQuery();
			while(rs.next()) {
				Questions q = new Questions();
				q.setId(rs.getInt(1));
				q.setQuestion(rs.getString(2));
				list.add(q);
			}
			return list!=null ? list : null;
		}catch(Exception ex) {
			System.out.println("error in addQuestions"+ex);
			return null;
		}
	}

	@Override
	public void deleteQuestion(int id) {
		try {
			pst = con.prepareStatement("delete from feedback_questions where qid=?");
			pst.setInt(1, id);
			int val = pst.executeUpdate();
			if(val>0) {
				System.out.println("Question Deleted");
			}
			else {
				System.out.println("Question Not Deleted");
			}
		}catch(Exception ex) {
			System.out.println("error in deleteQuestion"+ex);
		}
	}
}
