package com.gotham.batman.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gotham.batman.models.Candidate;
import com.gotham.batman.models.LocationCount;
import com.gotham.batman.service.CandidateService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {
	@Autowired
	private CandidateService candidateService;
	private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@RequestMapping(value="/addcandidate", method=RequestMethod.POST)
	
	public String addCandidate(@RequestBody Candidate candidate)
	{
		
		LOGGER.log(Level.INFO, "Candidate Added	"); 
		candidateService.addCandidate(candidate);
		return "completed";
	
	}

	
	@DeleteMapping("/deletecandidate/{Id}")
	public List<Candidate> deleteCandidate(@PathVariable Integer Id)
	{
	
		LOGGER.log(Level.INFO, "Candidate Deleted	");
		return candidateService.deleteCandidate(Id);
		
		
		//return candidateService.getAllCandidates();
	
	}
	
	@GetMapping("/getcandidatebyid/{Id}")
	public List<Candidate> getCandidateById(@PathVariable Integer Id)
	{	
		return candidateService.getCandidateById(Id);
		
	}
	@GetMapping("/getuserbyid/{Id}")
	public Candidate getUserById(@PathVariable Integer Id)
	{
		
		
			return candidateService.getUserById(Id);
		
	}
	
	@GetMapping("/getcandidatebylocation/{location}")
	public List<Candidate> getCandidateByLoc(@PathVariable String location)
	{
	
		return candidateService.getCandidateByLocation(location);
	
	}

	@GetMapping("/getallcandidates")
	public List<Candidate> getAllCandidates()
	{
		
		return candidateService.getAllCandidates();
		
	}
	
	@GetMapping("/getlocationcount")
	public List<LocationCount> getLocationCount()
	{
	
		return candidateService.getLocation();
	
	}
	@GetMapping("/getjob")
	public List<LocationCount> getJob()
	{
		
		return candidateService.getJob();
	
	}
	@GetMapping("/getskill")
	public List<LocationCount> getSkill()
	{
		
		return candidateService.getSkill();
	
	}
	@PostMapping("/updatecandidate/{id}")
	public List<Candidate> updateCandidate(@RequestBody Candidate candidate,@PathVariable Integer id)
	{
		
		LOGGER.log(Level.INFO, "Candidate Updated	");
		return candidateService.updateCandidate(new Candidate(id,candidate.getFirstName(),candidate.getLastName(),candidate.getEmail(),candidate.getLocation(),candidate.getFeedback(),candidate.getJobDescription(),candidate.getContactNumber()));
	//	return candidateService.getAllCandidates();
		
	}
	
}
