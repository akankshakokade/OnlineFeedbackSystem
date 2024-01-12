package org.ofs.services;

import java.util.List;

import org.ofs.model.Skill;

public interface SkillServices {
	public boolean addSkill(Skill skill);
	public List<Skill> getSkills();
	public List<Skill> getTrainerSkill(int id);
}
