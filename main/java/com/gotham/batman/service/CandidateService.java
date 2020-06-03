package com.gotham.batman.service;

import java.util.List;

import com.gotham.batman.models.Candidate;

public interface CandidateService {
	public void addCandidate(Candidate candidate) ;
	public void deleteCandidate(Integer id) ;
	public List<Candidate> getAllCandidates();
	public List<Candidate> getCandidateById(Integer id);
	public List<Candidate> getCandidateByLocation(String location);
	public void updateCandidate(Candidate candidate);
	public Integer getLocationCount(String location);
}
