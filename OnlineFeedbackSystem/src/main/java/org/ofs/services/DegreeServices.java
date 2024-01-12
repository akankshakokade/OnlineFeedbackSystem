package org.ofs.services;

import java.util.List;

import org.ofs.model.Degree;

public interface DegreeServices {
	public boolean addDegree(Degree degree);
	public List<Degree> getDegrees();
}
