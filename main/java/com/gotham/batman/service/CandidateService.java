package com.gotham.batman.service;

import java.util.List;

import com.gotham.batman.models.Candidate;
import com.gotham.batman.models.LocationCount;

public interface CandidateService {
	public String addCandidate(Candidate candidate) ;
	public String deleteCandidate(Integer id) ;
	public List<Candidate> getAllCandidates();
	public List<Candidate> getCandidateById(Integer id);
	public List<Candidate> getCandidateByLocation(String location);
	public String updateCandidate(Candidate candidate);	
	public Candidate getUserById(Integer id);
	public List<LocationCount> getLocation();
	public String checkUser(String token);
}
