package org.ofs.services;

import java.util.List;

import org.ofs.model.Student;
import org.ofs.model.Subject;
import org.ofs.repository.StudentRepoImpl;
import org.ofs.repository.StudentRepository;

public class StudentServImpl implements StudentServices{

	StudentRepository sRepo = new StudentRepoImpl();
	@Override
	public boolean addStudent(Student model) {
		// TODO Auto-generated method stub
		return sRepo.addStudent(model);
	}
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return sRepo.getStudents();
	}
	@Override
	public List<Student> getStudents(String str) {
		// TODO Auto-generated method stub
		return sRepo.getStudents(str);
	}
	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return sRepo.getStudent(id);
	}
	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		sRepo.deleteStudent(id);
	}
	@Override
	public void studentStatus(int id, int status) {
		// TODO Auto-generated method stub
		sRepo.studentStatus(id, status);
	}
	@Override
	public boolean allocateSubjectToStudent(int stid, int sid) {
		// TODO Auto-generated method stub
		return sRepo.allocateSubjectToStudent(stid, sid);
	}
	@Override
	public List<Subject> getAllocatedSubjectOfStudent(int stid) {
		// TODO Auto-generated method stub
		return sRepo.getAllocatedSubjectOfStudent(stid);
	}
	@Override
	public void removeStudentSubject(int stid, int subid) {
		// TODO Auto-generated method stub
		sRepo.removeStudentSubject(stid, subid);
	}
	@Override
	public Student updateStudent(Student model) {
		// TODO Auto-generated method stub
		return sRepo.updateStudent(model);
	}
	@Override
	public Student validStudent(Student model) {
		// TODO Auto-generated method stub
		return sRepo.validStudent(model);
	}
}
