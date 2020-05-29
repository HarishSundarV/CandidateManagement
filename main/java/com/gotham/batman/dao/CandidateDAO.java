package com.gotham.batman.dao;

import org.springframework.data.repository.CrudRepository;

import com.gotham.batman.models.Candidate;

public interface CandidateDAO extends CrudRepository<Candidate, Integer>{
	
}
