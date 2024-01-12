package org.ofs.repository;

import java.util.ArrayList;
import java.util.List;

import org.ofs.model.Skill;

public class SkillRepoImpl extends DBConfigure implements SkillRepository{
	List<Skill>list ;
	@Override
	public boolean addSkill(Skill skill) {
		try {
			pst = con.prepareStatement("insert into skill values('0',?)");
			pst.setString(1, skill.getName());
			int val = pst.executeUpdate();
			return val>0 ? true : false;
		}catch(Exception ex) {
			System.out.println("error in addSkill "+ex);
			return false;
		}
	}

	@Override
	public List<Skill> getSkills() {
		list = new ArrayList<>();
		try {
			pst = con.prepareStatement("select * from skill");
			rs = pst.executeQuery();
			while(rs.next()) {
				Skill s = new Skill();
				s.setSkid(rs.getInt(1));
				s.setName(rs.getString(2));
				list.add(s);
			}
			return list!=null ? list : null;
		}catch(Exception ex) {
			System.out.println("error in getSkills "+ex);
			return null;
		}
	}
	@Override
	public List<Skill> getTrainerSkill(int id) {
			list = new ArrayList<>();
		try {
			pst = con.prepareStatement("select t.tid,s.skid,s.name from trainer t inner join trainerskilljoin ts on t.tid=ts.tid inner join skill s on s.skid=ts.skid having t.tid=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				Skill sk = new Skill();
				sk.setSkid(rs.getInt(2));
				sk.setName(rs.getString(3));
				list.add(sk);
			}
			return list!=null ? list : null;
		}catch(Exception ex) {
			System.out.println("Error in getTrainerSkill "+ex);
			return null;
		}
	}
}
