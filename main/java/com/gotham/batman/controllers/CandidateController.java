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
	
	public String addCandidate(@RequestBody Candidate candidate,@RequestHeader("Authorization") String token)
	{
		if(candidateService.checkUser(token)=="Login sucessfull and User is Authenticated") {
		LOGGER.log(Level.INFO, "Candidate Added	"); 
		candidateService.addCandidate(candidate);
		return "completed";
		}
		return null;
	}
	
	@DeleteMapping("/deletecandidate/{Id}")
	public List<Candidate> deleteCandidate(@PathVariable Integer Id,@RequestHeader("Authorization") String token)
	{
		if(candidateService.checkUser(token)=="Login sucessfull and User is Authenticated") {
		LOGGER.log(Level.INFO, "Candidate Deleted	");
		candidateService.deleteCandidate(Id);
		return candidateService.getAllCandidates();
		}
		return null;
	}
	
	@GetMapping("/getcandidatebyid/{Id}")
	public List<Candidate> getCandidateById(@PathVariable Integer Id,@RequestHeader("Authorization") String token)
	{
		if(candidateService.checkUser(token)=="Login sucessfull and User is Authenticated") {
		return candidateService.getCandidateById(Id);
		}
		return null;
	}
	@GetMapping("/getuserbyid/{Id}")
	public Candidate getUserById(@PathVariable Integer Id,@RequestHeader("Authorization") String token)
	{
		if(candidateService.checkUser(token)=="Login sucessfull and User is Authenticated") {
		return candidateService.getUserById(Id);
		}
		return null;
	}
	
	@GetMapping("/getcandidatebylocation/{location}")
	public List<Candidate> getCandidateByLoc(@PathVariable String location,@RequestHeader("Authorization") String token)
	{
		if(candidateService.checkUser(token)=="Login sucessfull and User is Authenticated") {
		return candidateService.getCandidateByLocation(location);
		}
		return null;
	}
	
	@GetMapping("/getallcandidates")
	public List<Candidate> getAllCandidates(@RequestHeader("Authorization") String token)
	{
		if(candidateService.checkUser(token)=="Login sucessfull and User is Authenticated") {
		return candidateService.getAllCandidates();
		}
		return null;
	}
	
	@GetMapping("/getlocationcount")
	public List<LocationCount> getLocationCount(@RequestHeader("Authorization") String token)
	{if(candidateService.checkUser(token)=="Login sucessfull and User is Authenticated") {
		return candidateService.getLocation();
	}
	return null;
	}
	@PostMapping("/updatecandidate/{id}")
	public List<Candidate> updateCandidate(@RequestBody Candidate candidate,@PathVariable Integer id,@RequestHeader("Authorization") String token)
	{
		if(candidateService.checkUser(token)=="Login sucessfull and User is Authenticated") {
		LOGGER.log(Level.INFO, "Candidate Updated	");
		candidateService.updateCandidate(new Candidate(id,candidate.getFirstName(),candidate.getLastName(),candidate.getEmail(),candidate.getLocation(),candidate.getFeedback(),candidate.getJobDescription(),candidate.getContactNumber()));
		return candidateService.getAllCandidates();
		}
		return null;
	}
	@GetMapping("/users")
	String checkUser(@RequestHeader("Authorization") String token)
	{
			return candidateService.checkUser(token);
	}
}
