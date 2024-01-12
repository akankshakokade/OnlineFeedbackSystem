package org.ofs.repository;

import java.util.List;

import org.ofs.model.Collage;

public interface CollageRepository {
	public List<Collage>getCollages();
	public boolean addCollage(Collage collage);
}
