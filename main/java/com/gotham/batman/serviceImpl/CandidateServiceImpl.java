package com.gotham.batman.serviceImpl;

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
//		return dao.findAll();
//	}
//	public Candidate getCandidateById(Integer id)
//	{
//		Candidate candidate=(Candidate)dao.findById(id);
//		return candidate;
//	}
}
