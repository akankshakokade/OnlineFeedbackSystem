package org.ofs.services;

import java.util.List;

import org.ofs.model.Admin;
import org.ofs.model.Questions;
import org.ofs.repository.AdminRepository;
import org.ofs.repository.AdminRepositoryImpl;

public class AdminServicesImpl implements AdminServices{

	AdminRepository repo = new AdminRepositoryImpl();

	@Override
	public boolean isValid(Admin model) {
		// TODO Auto-generated method stub
		return repo.isValid(model);
	}

	@Override
	public Admin getAdmin(String id) {
		// TODO Auto-generated method stub
		return repo.getAdmin(id);
	}

	@Override
	public void addQuestion(String qtn) {
		// TODO Auto-generated method stub
		repo.addQuestion(qtn);
	}

	@Override
	public List<Questions> getQuestions() {
		// TODO Auto-generated method stub
		return repo.getQuestions();
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		repo.deleteQuestion(id);
	}
}
