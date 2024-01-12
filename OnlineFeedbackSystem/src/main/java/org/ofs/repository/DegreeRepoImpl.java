package org.ofs.repository;

import java.util.ArrayList;
import java.util.List;

import org.ofs.model.Degree;

public class DegreeRepoImpl extends DBConfigure implements DegreeRepository{

	List<Degree>list;
	@Override
	public boolean addDegree(Degree degree) {
		try {
			pst = con.prepareStatement("insert into qualification values ('0',?)");
			pst.setString(1, degree.getName());
			int val = pst.executeUpdate();
			return val>0 ? true : false;
		}catch(Exception ex) {
			System.out.println("Error in addDegree "+ex);
			return false;
		}
	}

	@Override
	public List<Degree> getDegrees() {
		list = new ArrayList<>();
		try {
			pst = con.prepareStatement("select * from qualification");
			rs = pst.executeQuery();
			while(rs.next()) {
				Degree d = new Degree();
				d.setDid(rs.getInt(1));
				d.setName(rs.getString(2));
				list.add(d);
			}
			return list!=null ? list : null;
		}catch(Exception ex) {
			System.out.println("Error in getDegrees "+ex);
			return null;
		}
	}
}
