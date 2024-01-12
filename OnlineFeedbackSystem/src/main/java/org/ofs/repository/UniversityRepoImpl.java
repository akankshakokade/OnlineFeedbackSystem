package org.ofs.repository;

import java.util.ArrayList;
import java.util.List;

import org.ofs.model.University;

public class UniversityRepoImpl extends DBConfigure implements UniversityRepository{

	List<University> list;
	@Override
	public boolean addUniversiity(University uni) {
		try {
			pst = con.prepareStatement("insert into University values('0',?)");
			pst.setString(1, uni.getName());
			int val = pst.executeUpdate();
			return val>0 ? true : false;
		}catch(Exception ex) {
			System.out.println("Error in addUni "+ex);
			return false;
		}
	}

	@Override
	public List<University> getUniversitys() {
		list = new ArrayList<>();
		try {
			pst = con.prepareStatement("select * from university");
			rs = pst.executeQuery();
			while(rs.next()) {
				University uni = new University();
				uni.setUid(rs.getInt(1));
				uni.setName(rs.getString(2));
				list.add(uni);
			}
			return list != null ? list : null;
		}catch(Exception ex) {
			System.out.println("Error in getUniversity "+ex);
			return null;
		}
	}
}
