package com.gotham.batman.dao;

import java.util.List;

import com.gotham.batman.models.Candidate;
import com.gotham.batman.models.LocationCount;

public interface CandidateDAOCustom {
	List<Candidate> getAllCandidates();
	public List<Candidate> getCandidateByLocation(String location_choice);
	public List<LocationCount> getLocation();
	public boolean checkUser(String token);
}
