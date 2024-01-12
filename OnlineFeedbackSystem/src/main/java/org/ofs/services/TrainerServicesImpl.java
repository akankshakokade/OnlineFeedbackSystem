package org.ofs.services;

import java.util.List;
import java.util.Vector;

import org.ofs.model.Subject;
import org.ofs.model.TrainerReg;
import org.ofs.repository.TrainerRepoImpl;
import org.ofs.repository.TrainerRepository;

public class TrainerServicesImpl implements TrainerServices{

	TrainerRepository trepo = new TrainerRepoImpl();

	@Override
	public int addTrainer(TrainerReg trainer) {
		return trepo.addTrainer(trainer);
	}

	@Override
	public boolean addTrainerQualification(int tid, int clgid, int dgid) {
		// TODO Auto-generated method stub
		return trepo.addTrainerQualification(tid, clgid, dgid);
	}

	@Override
	public List<TrainerReg> getTrainer() {
		// TODO Auto-generated method stub
		return trepo.getTrainer();
	}

	@Override
	public List<TrainerReg> getTrainer(String str,String searchBy) {
		// TODO Auto-generated method stub
		return trepo.getTrainer(str,searchBy);
	}

	@Override
	public TrainerReg getTrainer(int id) {
		// TODO Auto-generated method stub
		return trepo.getTrainer(id);
	}

	@Override
	public boolean addTrainerSkills(int tid, List<Integer> al) {
		// TODO Auto-generated method stub
		return trepo.addTrainerSkills(tid, al);
	}

	@Override
	public void setTrainerStatus(int tid,int status) {
		// TODO Auto-generated method stub
		trepo.setTrainerStatus(tid,status);
	}

	@Override
	public void deleteTrainer(int id) {
		// TODO Auto-generated method stub
		trepo.deleteTrainer(id);
	}

	@Override
	public Vector<Object[]> getTrainerQualification(int id) {
		// TODO Auto-generated method stub
		return trepo.getTrainerQualification(id);
	}

	@Override
	public boolean updateTrainer(TrainerReg model) {
		// TODO Auto-generated method stub
		return trepo.updateTrainer(model);
	}

	@Override
	public void deleteTrainerSkill(int tid, int skid) {
		// TODO Auto-generated method stub
		trepo.deleteTrainerSkill(tid, skid);
	}

	@Override
	public boolean deleteTrainerQualification(int tid, int did, int clgid) {
		// TODO Auto-generated method stub
		return trepo.deleteTrainerQualification(tid, did, clgid);
	}

	@Override
	public boolean allocateSubjectToTrainer(int tid, int sid) {
		// TODO Auto-generated method stub
		return trepo.allocateSubjectToTrainer(tid, sid);
	}

	@Override
	public List<Subject> getAllocatedSubject(int tid) {
		// TODO Auto-generated method stub
		return trepo.getAllocatedSubject(tid);
	}

	@Override
	public void removeTrainerSubject(int tid, int subid) {
		// TODO Auto-generated method stub
		trepo.removeTrainerSubject(tid, subid);
	}

}
