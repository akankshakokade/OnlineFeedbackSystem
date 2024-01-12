package org.ofs.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.ofs.model.Skill;
import org.ofs.model.Subject;
import org.ofs.model.TrainerReg;

public class TrainerRepoImpl extends DBConfigure implements TrainerRepository{

	List <TrainerReg> tlist;
	List <Skill> slist;
	List<Subject> sublist;
	Vector<Object[]>v;
	@Override
	public int addTrainer(TrainerReg trainer) {
		try {
			pst = con.prepareStatement("insert into trainer values('0',?,?,?,?,?,?,?)");
			pst.setString(1,trainer.getName());
			pst.setString(2, trainer.getEmail());
			pst.setString(3, trainer.getContact());
			String date = trainer.getDob();
			Date dob= Date.valueOf(date);
			pst.setDate(4, dob);
			pst.setInt(5, trainer.getExp());
			pst.setString(6, trainer.getPass());
			pst.setInt(7, trainer.getStatus());
			int val = pst.executeUpdate();

			if(val>0) {
				pst = con.prepareStatement("select tid from trainer where email=?");
				pst.setString(1, trainer.getEmail());
				rs = pst.executeQuery();
				int id=0;
				while(rs.next()) {
					id = rs.getInt(1);
				}
				return id;
			}else {
				return 0;
			}
		}catch(Exception ex) {
			System.out.println("Error in addtrainer "+ex);
			return 0;
		}
	}
	@Override
	public boolean addTrainerQualification(int tid, int clgid, int dgid) {
		try {
			pst= con.prepareStatement("select * from tqcujoin where tid=? and qid=? and clgid=?");
			pst.setInt(1, tid);
			pst.setInt(2, dgid);
			pst.setInt(3, clgid);
			rs = pst.executeQuery();

			if(rs.next()) {
				return false;
			}else {
				pst = con.prepareStatement("insert into tqcujoin values(?,?,?)");
				pst.setInt(1, tid);
				pst.setInt(2, dgid);
				pst.setInt(3, clgid);
				int	val = pst.executeUpdate();
				return val>0 ? true : false;
			}
		}catch(Exception ex){
			System.out.println("Error in addTrainerQuali "+ex);
			return false;
		}
	}
	@Override
	public List<TrainerReg> getTrainer(){
		tlist = new ArrayList<>();
		try {
			pst = con.prepareStatement("Select tid,name,Email,contact,dob,exp,status from trainer");
			rs = pst.executeQuery();
			while(rs.next()) {
				TrainerReg tr = new TrainerReg();
				tr.setId(rs.getInt(1));
				tr.setName(rs.getString(2));
				tr.setEmail(rs.getString(3));
				tr.setContact(rs.getString(4));
				String date = rs.getDate(5).toString();
				tr.setDob(date);
				tr.setExp(rs.getInt(6));
				tr.setStatus(rs.getInt(7));
				tlist.add(tr);
			}
			return tlist != null ? tlist : null;
		}catch(Exception ex) {
			System.out.println("Error in getTrainer = "+ex);
			return null;
		}
	}
	@Override
	public List<TrainerReg> getTrainer(String str,String searchBy) {
		tlist = new ArrayList<>();
		try {
			pst = con.prepareStatement("Select tid,name,Email,contact,dob,exp,status from trainer where "+searchBy+" like '%"+str+"%'");
			rs = pst.executeQuery();
			while(rs.next()) {
				TrainerReg tr = new TrainerReg();
				tr.setId(rs.getInt(1));
				tr.setName(rs.getString(2));
				tr.setEmail(rs.getString(3));
				tr.setContact(rs.getString(4));
				String date = rs.getDate(5).toString();
				tr.setDob(date);
				tr.setExp(rs.getInt(6));
				tr.setStatus(rs.getInt(7));
				tlist.add(tr);
			}
			return tlist != null ? tlist : null;
		}catch(Exception ex) {
			System.out.println("Error in getTrainer = "+ex);
			return null;
		}
	}
	@Override
	public TrainerReg getTrainer(int id) {
		try {
			pst = con.prepareStatement("Select tid,name,Email,contact,dob,exp,status from trainer where tid = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				TrainerReg tr = new TrainerReg();
				tr.setId(rs.getInt(1));
				tr.setName(rs.getString(2));
				tr.setEmail(rs.getString(3));
				tr.setContact(rs.getString(4));
				String date = rs.getDate(5).toString();
				tr.setDob(date);
				tr.setExp(rs.getInt(6));
				tr.setStatus(rs.getInt(7));
				return tr;
			}else {
				return null;
			}
		}catch(Exception ex) {
			System.out.println("Error in getTrainer = "+ex);
			return null;
		}
	}
	@Override
	public boolean addTrainerSkills(int tid, List<Integer> al) {
		try {
			Iterator<Integer> i = al.iterator();
			while(i.hasNext()){
				int skill = i.next();
				pst = con.prepareStatement("select * from trainerskilljoin where tid=? and skid=?");
				pst.setInt(1, tid);
				pst.setInt(2, skill);
				rs = pst.executeQuery();
				if(rs.next()) {
					i.remove();
	//				System.out.println("remove ="+skill);
				}
			}
			if(al.size()>0) {
				int val=0;
				for(int skid : al) {
					pst = con.prepareStatement("insert into trainerskilljoin values(?,?)");
					pst.setInt(1, tid);
					pst.setInt(2, skid);
					val = pst.executeUpdate();
				}
				return val>0 ? true : false;
			}else {
				return false;
			}
		}catch(Exception ex) {
			System.out.println("Error in addTrainerSkills "+ex);
			return false;
		}
	}
	@Override
	public void setTrainerStatus(int tid,int status) {
		try {
			pst = con.prepareStatement("update trainer set status=? where tid=?");
			pst.setInt(1, status);
			pst.setInt(2, tid);
			int val = pst.executeUpdate();
			if(val>0)
				System.out.println("updated");
			else
				System.out.println("Not Updated");
		}catch(Exception ex) {
			System.out.println("Error in addTrainerSkills "+ex);
		}
	}
	@Override
	public void deleteTrainer(int id) {
		try {
			pst = con.prepareStatement("delete from trainer where tid=?");
			pst.setInt(1, id);
			int val = pst.executeUpdate();
			if(val>0)
				System.out.println("deleted");
			else
				System.out.println("Not deleted");
		}catch(Exception ex) {
			System.out.println("Error in addTrainerSkills "+ex);
		}
	}
	@Override
	public Vector<Object[]> getTrainerQualification(int id) {
		v = new Vector<>();
		try {
			pst = con.prepareStatement("select t.tid,q.qid,q.name,c.clgid,c.name,u.name from trainer t inner join tqcujoin tc "
					+ "on t.tid=tc.tid inner join qualification q on q.qid=tc.qid inner join collage c on c.clgid=tc.clgid inner"
					+ " join university u on c.uid=u.uid having t.tid=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				Object QulClgUni[] = new Object[5];
				QulClgUni[0]=rs.getInt(2);
				QulClgUni[1]=rs.getString(3);
				QulClgUni[2]=rs.getInt(4);
				QulClgUni[3]=rs.getString(5);
				QulClgUni[4]=rs.getString(6);
				v.add(QulClgUni);
			}
			return v!=null ? v : null;
		}catch(Exception ex) {
			System.out.println("Error in getTrainerQualification "+ex);
			return null;
		}
	}
	@Override
	public boolean updateTrainer(TrainerReg model) {
		try {
			pst = con.prepareStatement("update trainer set name=?,email=?,contact=?,dob=?,exp=?,status=? where tid=?");
			pst.setString(1, model.getName());
			pst.setString(2, model.getEmail());
			pst.setString(3, model.getContact());
			Date date = Date.valueOf(model.getDob());
			pst.setDate(4,date);
			pst.setInt(5, model.getExp());
			pst.setInt(6, model.getStatus());
			pst.setInt(7, model.getId());
			int val = pst.executeUpdate();
			return val>0 ? true : false;
		}catch(Exception ex) {
			System.out.println("Error in updateTrainer "+ex);
			return false;
		}
	}
	@Override
	public void deleteTrainerSkill(int tid, int skid) {
		try {
			pst = con.prepareStatement("delete from trainerskilljoin where tid=? and skid=?");
			pst.setInt(1, tid);
			pst.setInt(2, skid);
			int val = pst.executeUpdate();
			if(val>0)
				System.out.println("deleted");
			else
				System.out.println("Not deleted");
		}catch(Exception ex) {
			System.out.println("Error in addTrainerSkills "+ex);
		}
	}
	@Override
	public boolean deleteTrainerQualification(int tid, int did, int clgid) {
		try {
			pst = con.prepareStatement("delete from tqcujoin where tid=? and qid=? and clgid=?");
			pst.setInt(1, tid);
			pst.setInt(2, did);
			pst.setInt(3, clgid);
			int val = pst.executeUpdate();
			if(val>0)
				return true;
			else
				return false;
		}catch(Exception ex) {
			System.out.println("Error in deleteTrainerQualification = "+ex);
			return false;
		}
	}
	@Override
	public boolean allocateSubjectToTrainer(int tid, int sid) {
		try {
			pst = con.prepareStatement("select * from allocatesubtrainer");
			rs = pst.executeQuery();
			boolean b = false;
			while(rs.next()) {
				if(rs.getInt(1)==tid && rs.getInt(2)==sid) {
					b = true;
					break;
				}
			}
			if(!b) {
				pst = con.prepareStatement("insert into allocatesubtrainer values(?,?)");
				pst.setInt(1, tid);
				pst.setInt(2, sid);
				int val = pst.executeUpdate();
				return val>0 ? true : false;
			}else {
				return false;
			}
		}catch(Exception ex) {
			System.out.println("Error in allocateSubjectToTrainer "+ex);
			return false;
		}
	}
	@Override
	public List<Subject> getAllocatedSubject(int tid) {
		sublist = new ArrayList<>();
		try {
			pst = con.prepareStatement("select t.name,s.subid,s.name from trainer t inner join allocatesubtrainer a on t.tid=a.tid inner join subject s on s.subid=a.subid where t.tid= ?");
			pst.setInt(1, tid);
			rs = pst.executeQuery();
			while(rs.next()) {
				Subject s = new Subject();
				s.setSubid(rs.getInt(2));
				s.setName(rs.getString(3));
				sublist.add(s);
			}
			return sublist!=null ? sublist : null;
		}catch(Exception ex) {
			System.out.println("Error in getAllocatedSubject "+ex);
			return null;
		}
	}
	@Override
	public void removeTrainerSubject(int tid, int subid) {
		try {
			pst = con.prepareStatement("delete from allocatesubtrainer where tid = ? and subid = ?");
			pst.setInt(1, tid);
			pst.setInt(2, subid);
			int val = pst.executeUpdate();
			System.out.println(val>0 ? "Subject Removed" : "Subject Not Removed");
		}catch(Exception ex) {
			System.out.println("Error in removeTrainerSubject "+ex);
		}
	}
}