package org.ofs.services;

import java.util.List;

import org.ofs.model.Degree;
import org.ofs.repository.DegreeRepoImpl;
import org.ofs.repository.DegreeRepository;

public class DegreeServImpl implements DegreeServices{

	DegreeRepository dRepo = new DegreeRepoImpl();
	@Override
	public boolean addDegree(Degree degree) {
		if(degree.getName().length()>0)
			return dRepo.addDegree(degree);
		else
			return false;
	}

	@Override
	public List<Degree> getDegrees() {
		// TODO Auto-generated method stub
		return dRepo.getDegrees();
	}

}
