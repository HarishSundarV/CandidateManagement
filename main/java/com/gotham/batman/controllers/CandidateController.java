package com.gotham.batman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gotham.batman.models.Candidate;
import com.gotham.batman.service.CandidateService;

@RestController
public class CandidateController {
	@Autowired
	private CandidateService candidateService;
	@RequestMapping(value="/addcandidate", method=RequestMethod.POST)

	public String addCandidate(Candidate candidate)
	{
		//candidateService.addCandidate(new Candidate("harish","sundar","harish@gmail.com","cadvd","sdsd","vvewv","wewre"));
		candidateService.addCandidate(candidate);
		return "completed";
	}
	@DeleteMapping("/deletecandidate/{Id}")
	public void deleteCandidate(@PathVariable Integer Id)
	{
		candidateService.deleteCandidate(Id);
	}
	
	@GetMapping("/getcandidate/{Id}")
	public Candidate getCandidateById(@PathVariable Integer Id)
	{
		return candidateService.getCandidateById(Id);
	}
	
//	@GetMapping("/getallcandidates")
//	public List<Candidate> getAllCandidates()
//	{
//		candidateService.getAllCandidates();
//	}

}
