package com.gotham.batman.dao;

import java.util.List;

import com.gotham.batman.models.Candidate;

public interface CandidateDAOCustom {
	List<Candidate> getAllCandidates();
	public List<Candidate> getCandidateByLocation(String location_choice);
}
