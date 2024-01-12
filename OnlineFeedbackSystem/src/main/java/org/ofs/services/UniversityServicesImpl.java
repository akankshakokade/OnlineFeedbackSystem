package org.ofs.services;

import java.util.List;

import org.ofs.model.University;
import org.ofs.repository.UniversityRepoImpl;
import org.ofs.repository.UniversityRepository;

public class UniversityServicesImpl implements UniversityServices{

	UniversityRepository repo = new UniversityRepoImpl();
	@Override
	public boolean addUniversiity(University uni) {
		if(uni.getName().length()>0)
			return repo.addUniversiity(uni);
		else
			return false;
	}
	@Override
	public List<University> getUniversitys() {
		// TODO Auto-generated method stub
		return repo.getUniversitys();
	}

}
