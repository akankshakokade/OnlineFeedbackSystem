package org.ofs.repository;

import java.util.List;

import org.ofs.model.Skill;

public interface SkillRepository {
	public boolean addSkill(Skill skill);
	public List<Skill> getSkills();
	public List<Skill> getTrainerSkill(int id);
}
