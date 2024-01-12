package org.ofs.repository;

import java.util.List;

import org.ofs.model.Admin;
import org.ofs.model.Questions;

public interface AdminRepository {

	public boolean isValid(Admin model);
	public Admin getAdmin(String id);
	public void addQuestion(String qtn);
	public List<Questions> getQuestions();
	public void deleteQuestion(int id);
}
