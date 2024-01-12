package org.ofs.repository;

import java.util.List;
import java.util.Vector;

import org.ofs.model.Subject;
import org.ofs.model.TrainerReg;

public interface TrainerRepository {
	public int addTrainer(TrainerReg trainer);
	public boolean addTrainerQualification(int tid,int clgid,int dgid);
	public boolean addTrainerSkills(int tid,List<Integer> al);
	public List<TrainerReg> getTrainer();
	public List<TrainerReg> getTrainer(String str,String searchBy);
	public TrainerReg getTrainer(int id);
	public void setTrainerStatus(int tid,int status);
	public void deleteTrainer(int id);
	public Vector<Object[]> getTrainerQualification(int id);
	public boolean updateTrainer(TrainerReg model);
	public void deleteTrainerSkill(int tid,int skid);
	public boolean deleteTrainerQualification(int tid,int did,int clgid);
	public boolean allocateSubjectToTrainer(int tid,int sid);
	public List<Subject> getAllocatedSubject(int tid);
	public void removeTrainerSubject(int tid,int subid);
}
