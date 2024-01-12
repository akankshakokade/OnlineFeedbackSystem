package org.ofs.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.ofs.model.Student;
import org.ofs.model.Subject;

public class StudentRepoImpl extends DBConfigure implements StudentRepository{

	List<Student> slist;
	List<Subject> sublist;
	@Override
	public boolean addStudent(Student model) {
		try {
			pst = con.prepareStatement("INSERT INTO STUDENT VALUES('0',?,?,?,?,?,?,?)");
			pst.setString(1, model.getStuname());
			pst.setString(2, model.getEmail());
			pst.setString(3, model.getContact());
			pst.setString(4, model.getAddress());
			java.sql.Date d = Date.valueOf(model.getDob());
			pst.setDate(5, d);
			pst.setString(6,model.getPassword());
			pst.setInt(7, model.getStatus());
			int val = pst.executeUpdate();
			return val>0 ? true : false;
		}catch(Exception ex) {
			System.out.println("Error in addStudent "+ex);
			return false;
		}
	}

	@Override
	public List<Student> getStudents() {
		slist = new ArrayList<>();
		try {
			pst = con.prepareStatement("SELECT * FROM STUDENT");
			rs = pst.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				s.setSid(rs.getInt(1));
				s.setStuname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setContact(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setDob(rs.getDate(6).toString());
				s.setPassword(rs.getString(7));
				s.setStatus(rs.getInt(8));
				slist.add(s);
			}
		return slist!=null ? slist : null ;
		}catch(Exception ex) {
			System.out.println("Error in getStudents "+ex);
			return null;
		}
	}

	@Override
	public List<Student> getStudents(String str) {
		slist = new ArrayList<>();
		try {
			pst = con.prepareStatement("SELECT * FROM STUDENT WHERE sid like '%"+str+"%' or name like '%"+str+"%' or email"
					+ " like '%"+str+"%' or contact like '%"+str+"%'");
			rs = pst.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				s.setSid(rs.getInt(1));
				s.setStuname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setContact(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setDob(rs.getDate(6).toString());
				s.setPassword(rs.getString(7));
				s.setStatus(rs.getInt(8));
				slist.add(s);
			}
		return slist!=null ? slist : null ;
		}catch(Exception ex) {
			System.out.println("Error in getStudents "+ex);
			return null;
		}
	}

	@Override
	public Student getStudent(int id) {
		try {
			pst = con.prepareStatement("SELECT * FROM STUDENT WHERE sid=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				Student s = new Student();
				s.setSid(rs.getInt(1));
				s.setStuname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setContact(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setDob(rs.getDate(6).toString());
				s.setPassword(rs.getString(7));
				s.setStatus(rs.getInt(8));
				return s;
			}
			else
				return null;
		}catch(Exception ex) {
			System.out.println("Error in getStudents "+ex);
			return null;
		}
	}

	@Override
	public void deleteStudent(int id) {
		try {
			pst = con.prepareStatement("DELETE FROM STUDENT WHERE sid=?");
			pst.setInt(1, id);
			int val = pst.executeUpdate();
			if(val>0)
				System.out.println("Student Delete");
			else
				System.out.println("Student Not Delete");
		}catch(Exception ex) {
			System.out.println("Error in deleteStudents"+ex);
		}
	}

	@Override
	public void studentStatus(int id, int status) {
		// TODO Auto-generated method stub
		try {
			pst = con.prepareStatement("UPDATE STUDENT SET status=? WHERE sid=?");
			pst.setInt(1, status);
			pst.setInt(2, id);
			int val = pst.executeUpdate();
			if(val>0)
				System.out.println("status changed");
			else
				System.out.println("Status Not changed");
		}catch(Exception ex) {
			System.out.println("Error in deleteStudents"+ex);
		}
	}

	@Override
	public boolean allocateSubjectToStudent(int stid, int sid) {
		try {
			pst = con.prepareStatement("select * from allocatesubstud where sid=? and subid = ?");
			pst.setInt(1, stid);
			pst.setInt(2, sid);
			rs = pst.executeQuery();
			boolean b = true;
			if(rs.next()) {
				b = false;
			}
			if(b) {
				pst = con.prepareStatement("insert into allocatesubstud values(?,?)");
				pst.setInt(1, stid);
				pst.setInt(2, sid);
				int val = pst.executeUpdate();
				return val>0 ? true : false;
			}else {
				return false;
			}
		}catch(Exception ex) {
			System.out.println("Error in allocateSubjectToStudent"+ex);
			return false;
		}
	}

	@Override
	public List<Subject> getAllocatedSubjectOfStudent(int stid) {
		try {
			sublist = new ArrayList<>();
			pst = con.prepareStatement("select s.subid,s.name,s.status from student st inner join allocatesubstud a on st.sid=a.sid inner join subject s on s.subid=a.subid where st.sid=?");
			pst.setInt(1, stid);
			rs = pst.executeQuery();
			while(rs.next()) {
				Subject s = new Subject();
				s.setSubid(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setStatus(rs.getInt(3));
				sublist.add(s);
			}
			return sublist!=null ? sublist : null;
		}catch(Exception ex) {
			System.out.println("Error in getAllocatedSubjectOfStudent "+ex);
			return null;
		}
	}

	@Override
	public void removeStudentSubject(int stid, int subid) {
		try {
			pst = con.prepareStatement("delete from allocatesubstud where sid = ? and subid = ?");
			pst.setInt(1, stid);
			pst.setInt(2, subid);
			int val = pst.executeUpdate();
			if(val>0)
				System.out.println("Subject removed from student");
			else
				System.out.println("Subject Not removed From Student");
		}catch(Exception ex) {
			System.out.println("Error in removeStudentSubject "+ex);
		}
	}

	@Override
	public Student updateStudent(Student model) {
		try {
			pst = con.prepareStatement("update student set name=?,email=?,contact=?,address=?,dob=?,status=? where sid=?;");
			pst.setString(1, model.getStuname());
			pst.setString(2, model.getEmail());
			pst.setString(3, model.getContact());
			pst.setString(4, model.getAddress());
			java.sql.Date d = Date.valueOf(model.getDob());
			pst.setDate(5, d);
			pst.setInt(6, model.getStatus());
			pst.setInt(7, model.getSid());
			int val = pst.executeUpdate();
			return val>0 ? model : null;
		}catch(Exception ex) {
			System.out.println("Error in updateStudent "+ex);
			return null;
		}
	}

	@Override
	public Student validStudent(Student model) {
		try {
			pst = con.prepareStatement("SELECT * FROM student WHERE email=? and password=?");
			pst.setString(1, model.getEmail());
			pst.setString(2, model.getPassword());

			rs = pst.executeQuery();
			if(rs.next()) {
				Student s = new Student();
				s.setSid(rs.getInt(1));
				s.setStuname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setContact(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setDob(rs.getString(6));
				s.setStatus(rs.getInt(8));
				return s;
			}else {
				return null;
			}
		}catch(Exception ex) {
			System.out.println("Error in valideStudent"+ex);
			return null;
		}
	}
}
