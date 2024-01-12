package org.ofs.services;

import java.util.List;

import org.ofs.model.Collage;
import org.ofs.repository.CollageRepoImpl;
import org.ofs.repository.CollageRepository;

public class CollageServImpl implements CollageServices{

	CollageRepository crepo = new CollageRepoImpl();
	@Override
	public List<Collage> getCollages() {
		// TODO Auto-generated method stub
		return crepo.getCollages();
	}

	@Override
	public boolean addCollage(Collage collage) {
		// TODO Auto-generated method stub
		return crepo.addCollage(collage);
	}

}
