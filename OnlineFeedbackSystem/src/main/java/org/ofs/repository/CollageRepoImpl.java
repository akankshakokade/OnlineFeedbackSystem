package org.ofs.repository;

import java.util.ArrayList;
import java.util.List;

import org.ofs.model.Collage;

public class CollageRepoImpl extends DBConfigure implements CollageRepository{

	List <Collage>list;
	@Override
	public List<Collage> getCollages() {

		list = new ArrayList<>();
		try {
			pst = con.prepareStatement("select * from collage");
			rs = pst.executeQuery();
			while(rs.next()) {
				Collage clg = new Collage();
				clg.setClgid(rs.getInt(1));
				clg.setName(rs.getString(2));
				clg.setUid(rs.getInt(3));
				list.add(clg);
			}
			return list!=null ? list : null;
		}catch(Exception ex) {
			System.out.println("Error in getCollages "+ex);
			return null;
		}
	}

	@Override
	public boolean addCollage(Collage collage) {
		try {
			pst = con.prepareStatement("insert into collage values('0',?,?)");
			pst.setString(1, collage.getName());
			pst.setInt(2, collage.getUid());
			int val = pst.executeUpdate();
			return val>0 ? true : false;

		}catch(Exception ex) {
			System.out.println("Error in getCollages "+ex);
			return false;
		}
	}

}
