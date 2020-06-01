package com.gotham.batman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gotham.batman.models.Candidate;
import com.gotham.batman.service.CandidateService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {
	@Autowired
	private CandidateService candidateService;
	@RequestMapping(value="/addcandidate", method=RequestMethod.POST)

	public String addCandidate(@RequestBody Candidate candidate)
	{
		//System.out.println(candidate.toString());
		//candidateService.addCandidate(new Candidate("harish","sundar","harish@gmail.com","cadvd","sdsd","vvewv","wewre"));
		candidateService.addCandidate(candidate);
		return "completed";
	}
	@DeleteMapping("/deletecandidate/{Id}")
	public List<Candidate> deleteCandidate(@PathVariable Integer Id)
	{
		candidateService.deleteCandidate(Id);
		return candidateService.getAllCandidates();
	}
	
	@GetMapping("/getcandidatebyid/{Id}")
	public Candidate getCandidateById(@PathVariable Integer Id)
	{
		return candidateService.getCandidateById(Id);
	}
	
	@GetMapping("/getcandidatebylocation/{location}")
	public List<Candidate> getCandidateById(@PathVariable String location)
	{
		return candidateService.getCandidateByLocation(location);
	}
	
	@GetMapping("/getallcandidates")
	public List<Candidate> getAllCandidates()
	{
		return candidateService.getAllCandidates();
	}

}
