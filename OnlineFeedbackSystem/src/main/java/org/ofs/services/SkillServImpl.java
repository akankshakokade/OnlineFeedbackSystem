package org.ofs.services;

import java.util.List;

import org.ofs.model.Skill;
import org.ofs.repository.SkillRepoImpl;
import org.ofs.repository.SkillRepository;

public class SkillServImpl implements SkillServices{

	SkillRepository sRepo = new SkillRepoImpl();
	@Override
	public boolean addSkill(Skill skill) {
		if(skill.getName().length()>0)
			return sRepo.addSkill(skill);
		else
			return false;
	}

	@Override
	public List<Skill> getSkills() {
		// TODO Auto-generated method stub
		return sRepo.getSkills();
	}

	@Override
	public List<Skill> getTrainerSkill(int id) {
		// TODO Auto-generated method stub
		return sRepo.getTrainerSkill(id);
	}

}
