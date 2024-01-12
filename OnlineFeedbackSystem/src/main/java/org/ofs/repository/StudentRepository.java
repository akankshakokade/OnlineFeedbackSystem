package org.ofs.repository;

import java.util.List;

import org.ofs.model.Student;
import org.ofs.model.Subject;

public interface StudentRepository {
	public boolean addStudent(Student model);
	public List<Student> getStudents();
	public List<Student> getStudents(String str);
	public Student getStudent(int id);
	public void deleteStudent(int id);
	public void studentStatus(int id,int status);
	public boolean allocateSubjectToStudent(int stid,int sid);
	public List<Subject> getAllocatedSubjectOfStudent(int stid);
	public void removeStudentSubject(int stid,int subid);
	public Student updateStudent(Student model);
	public Student validStudent(Student model);
}
