package org.ofs.repository;

import java.util.List;

import org.ofs.model.University;

public interface UniversityRepository {
	public boolean addUniversiity(University uni);
	public List<University> getUniversitys();
}
