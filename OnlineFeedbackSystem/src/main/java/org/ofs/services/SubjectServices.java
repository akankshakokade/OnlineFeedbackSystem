package org.ofs.services;

import java.util.List;

import org.ofs.model.Student;
import org.ofs.model.Subject;
import org.ofs.model.TrainerReg;
public interface SubjectServices {

	public boolean addSubject(Subject model);
	public int getSubId();
	public List<Subject> getSubjects();
	public List<Subject> getSubjects(String str);
	public boolean updateSubject(Subject model);
	public boolean subjectStatus(Subject model);
	public List<TrainerReg> getSubjectWiseTrainer(int id);
	public List<Student> getSubjectWiseStudnet(int id);

}
