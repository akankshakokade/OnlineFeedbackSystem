package org.ofs.services;

import java.util.List;

import org.ofs.model.Admin;
import org.ofs.model.Questions;

public interface AdminServices {

	public boolean isValid(Admin model);
	public Admin getAdmin(String id);
	public void addQuestion(String qtn);
	public List<Questions> getQuestions();
	public void deleteQuestion(int id);
}
