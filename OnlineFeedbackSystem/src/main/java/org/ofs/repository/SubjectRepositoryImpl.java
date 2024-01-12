package org.ofs.repository;

import java.util.ArrayList;
import java.util.List;

import org.ofs.model.Student;
import org.ofs.model.Subject;
import org.ofs.model.TrainerReg;

public class SubjectRepositoryImpl extends DBConfigure implements SubjectRepository{

	List <Subject>list;
	List <TrainerReg> tlist;
	List <Student> slist;
	@Override
	public boolean addSubject(Subject model) {
		try{
			pst = con.prepareStatement("insert into subject(subid,name)values(?,?)");
			pst.setInt(1, model.getSubid());
			pst.setString(2, model.getName());
			int val = pst.executeUpdate();

			return val>0 ? true : false;

		}catch(Exception ex) {
			System.out.println("Error in addsubject "+ex);
			return false;
		}
	}

	@Override
	public int getSubId() {
		try{
			pst = con.prepareStatement("select max(subid)from subject");
			rs = pst.executeQuery();
			//System.out.println(rs.getInt(1));
			if(rs.next()) {
//				System.out.println("done");
				int total = rs.getInt(1);
				++total;
				return total;
			}
			else {
//				System.out.println("not done");
				return 0;
			}
		}catch(Exception ex) {
			System.out.println("Error in getsubid "+ex);
			return 0;
		}
	}

	@Override
	public List<Subject> getSubjects() {
		list =new ArrayList<>();
		try {
			pst = con.prepareStatement("select * from subject");
			rs = pst.executeQuery();
			while(rs.next()) {
				Subject sub = new Subject();
				sub.setSubid(rs.getInt(1));
				sub.setName(rs.getString(2));
				sub.setStatus(rs.getInt(3));
				list.add(sub);
			}
			return list;
		}catch(Exception ex) {
			System.out.println("Error in getSubjects "+ex);
			return null;
		}
	}

	@Override
	public List<Subject> getSubjects(String str) {
		list =new ArrayList<>();
		try {
			pst = con.prepareStatement("select * from subject where name like '%"+str+"%'");
			rs = pst.executeQuery();
			while(rs.next()) {
				Subject sub = new Subject();
				sub.setSubid(rs.getInt(1));
				sub.setName(rs.getString(2));
				sub.setStatus(rs.getInt(3));
				list.add(sub);
			}
			return list;
		}catch(Exception ex) {
			System.out.println("Error in getSubjects "+ex);
			return null;
		}
	}

	@Override
	public boolean updateSubject(Subject model) {
		try{
			pst = con.prepareStatement("update subject set name=? where subid=?");
			pst.setString(1, model.getName());
			pst.setInt(2, model.getSubid());
			int val = pst.executeUpdate();

			return val>0 ? true : false;

		}catch(Exception ex) {
			System.out.println("Error in addsubject "+ex);
			return false;
		}
	}

	@Override
	public boolean subjectStatus(Subject model) {
		try{
			pst = con.prepareStatement("update subject set status=? where subid=?");
			pst.setInt(1, model.getStatus());
			pst.setInt(2, model.getSubid());
			int val = pst.executeUpdate();

			return val>0 ? true : false;

		}catch(Exception ex) {
			System.out.println("Error in addsubject "+ex);
			return false;
		}
	}

	@Override
	public List<TrainerReg> getSubjectWiseTrainer(int id) {
		try {
			tlist = new ArrayList<>();
			pst = con.prepareStatement("select t.tid,t.name,t.email,t.contact from trainer t inner join allocatesubtrainer a on t.tid=a.tid inner join subject s on s.subid=a.subid where s.subid=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				TrainerReg tr = new TrainerReg();
				tr.setId(rs.getInt(1));
				tr.setName(rs.getString(2));
				tr.setEmail(rs.getString(3));
				tr.setContact(rs.getString(4));
				tlist.add(tr);
			}
			return tlist!= null ? tlist: null;
		}catch(Exception ex) {
			System.out.println("Error in getSubjectWiseTrianer "+ex);
			return null;
		}
	}

	@Override
	public List<Student> getSubjectWiseStudnet(int id) {
		try {
			slist = new ArrayList<>();
			pst = con.prepareStatement("select s.sid,s.name,s.email,s.contact from student s inner join allocatesubstud a on s.sid=a.sid inner join subject sb on sb.subid=a.subid where sb.subid=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				s.setSid(rs.getInt(1));
				s.setStuname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setContact(rs.getString(4));
				slist.add(s);
			}
			return slist!= null ? slist: null;
		}catch(Exception ex) {
			System.out.println("Error in getSubjectWiseTrianer "+ex);
			return null;
		}
	}
}
