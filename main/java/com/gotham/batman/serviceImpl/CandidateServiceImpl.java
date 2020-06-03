package com.gotham.batman.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gotham.batman.dao.CandidateDAO;
import com.gotham.batman.models.Candidate;
import com.gotham.batman.service.CandidateService;

@Component
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateDAO dao;
	public void addCandidate(Candidate candidate)
	{
		dao.save(candidate);
	}
	public void deleteCandidate(Integer id)
	{
		dao.deleteById(id);
	}
//	public List<Candidate> getAllCandidates()
//	{
//		List<Optional<Candidate>> optionalEntity =  dao.findAll();
//		 RoomEntity roomEntity = optionalEntity.get();
//		List<Candidate> candidates=
//		return dao.findAll();
//	}
	
	public List<Candidate> getCandidateById(Integer id)
	{
		
		Optional<Candidate> optionalEntity =  dao.findById(id);
		 Candidate candidate = optionalEntity.get();
		 List<Candidate> candidates=new ArrayList<>();
		 candidates.add(candidate);
		return candidates;
	}
	public List<Candidate> getAllCandidates()
	{
		return dao.getAllCandidates();
	}
	public List<Candidate> getCandidateByLocation(String location_choice)
	{
		return dao.getCandidateByLocation(location_choice);
	}
	public void updateCandidate(Candidate candidate)
	{
		dao.save(new Candidate(candidate.getId(),candidate.getFirstName(),candidate.getLastName(),candidate.getEmail(),candidate.getLocation(),candidate.getFeedback(),candidate.getJobDescription(),candidate.getContactNumber()));
	}
	public Integer getLocationCount(String location)
	{
		 return dao.getCountByLocation(location);
	}
}
