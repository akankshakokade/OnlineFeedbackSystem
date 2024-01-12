package org.ofs.services;

import java.util.List;

import org.ofs.model.Collage;

public interface CollageServices {
	public List<Collage>getCollages();
	public boolean addCollage(Collage collage);
}
