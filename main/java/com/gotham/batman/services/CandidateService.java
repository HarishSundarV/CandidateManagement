package com.gotham.batman.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.gotham.batman.dao.CandidateDAO;
import com.gotham.batman.models.Candidate;

public class CandidateService {
	@Autowired
	CandidateDAO dao;
	public void addCandidate(Candidate candidate)
	{
		dao.save(candidate);
	}
}
