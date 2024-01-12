package org.ofs.repository;

import java.util.List;

import org.ofs.model.Degree;

public interface DegreeRepository {
	public boolean addDegree(Degree degree);
	public List<Degree> getDegrees();
}
