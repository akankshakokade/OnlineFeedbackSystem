package org.ofs.services;

import java.util.List;

import org.ofs.model.Student;
import org.ofs.model.Subject;
import org.ofs.model.TrainerReg;
import org.ofs.repository.SubjectRepository;
import org.ofs.repository.SubjectRepositoryImpl;

public class SubjectServiceImpl implements SubjectServices{

	SubjectRepository srepo = new SubjectRepositoryImpl();
	@Override
	public boolean addSubject(Subject model) {
		// TODO Auto-generated method stub
		return srepo.addSubject(model);
	}

	@Override
	public int getSubId() {
		// TODO Auto-generated method stub
		return srepo.getSubId();
	}

	@Override
	public List<Subject> getSubjects() {
		// TODO Auto-generated method stub
		return srepo.getSubjects();
	}

	@Override
	public List<Subject> getSubjects(String str) {
		// TODO Auto-generated method stub
		return srepo.getSubjects(str);
	}

	@Override
	public boolean updateSubject(Subject model) {
		// TODO Auto-generated method stub
		return srepo.updateSubject(model);
	}

	@Override
	public boolean subjectStatus(Subject model) {
		// TODO Auto-generated method stub
		return srepo.subjectStatus(model);
	}

	@Override
	public List<TrainerReg> getSubjectWiseTrainer(int id) {
		// TODO Auto-generated method stub
		return srepo.getSubjectWiseTrainer(id);
	}

	@Override
	public List<Student> getSubjectWiseStudnet(int id) {
		// TODO Auto-generated method stub
		return srepo.getSubjectWiseStudnet(id);
	}
}
