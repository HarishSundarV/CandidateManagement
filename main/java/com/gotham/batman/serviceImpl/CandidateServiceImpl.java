package com.gotham.batman.serviceImpl;

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
	public Candidate getCandidateById(Integer id)
	{
		Optional<Candidate> optionalEntity =  dao.findById(id);
		 Candidate candidate = optionalEntity.get();
		return candidate;
	}
}
