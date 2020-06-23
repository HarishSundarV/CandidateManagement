package com.gotham.batman.serviceImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gotham.batman.dao.CandidateDAO;
import com.gotham.batman.models.Candidate;
import com.gotham.batman.models.LocationCount;
import com.gotham.batman.service.CandidateService;

@Component
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateDAO dao;

	public String addCandidate(Candidate candidate) {
		String fileName="D:\\Accolite_training\\logs.log";
		 String str = "Candidate "+candidate.getFirstName()+" got added\n "; 
	      appendStrToFile(fileName, str); 
		dao.save(candidate);
		return "completed";
	}

	public List<Candidate> deleteCandidate(Integer id) {
		String fileName="D:\\Accolite_training\\logs.log";
		 String str = "Candidate "+id +" got updated\n "; 
	      appendStrToFile(fileName, str); 
		dao.deleteById(id);
		return dao.getAllCandidates();
	}

	public static void appendStrToFile(String fileName, String str) {
		try {

			BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
			out.write(str);
			out.close();
		} catch (IOException e) {
			System.out.println("exception occoured" + e);
		}
	}

	public List<Candidate> getCandidateById(Integer id) {

		Optional<Candidate> optionalEntity = dao.findById(id);
		Candidate candidate = optionalEntity.get();
		List<Candidate> candidates = new ArrayList<>();
		candidates.add(candidate);
		return candidates;
	}

	public Candidate getUserById(Integer id) {

		Optional<Candidate> optionalEntity = dao.findById(id);
		Candidate candidate = optionalEntity.get();
		return candidate;
	}

	public List<Candidate> getAllCandidates() {
		return dao.getAllCandidates();
	}

	public List<Candidate> getCandidateByLocation(String location_choice) {
		return dao.getCandidateByLocation(location_choice);
	}

	public List<Candidate> updateCandidate(Candidate candidate) {
		String fileName="D:\\Accolite_training\\logs.log";
		 String str = "Candidate"+ candidate.getId()+", "+candidate.getFirstName()+" got updated\n "; 
	      appendStrToFile(fileName, str); 
		dao.save(new Candidate(candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
				candidate.getEmail(), candidate.getLocation(), candidate.getFeedback(), candidate.getJobDescription(),
				candidate.getContactNumber()));
		return dao.getAllCandidates();
	}

	public List<LocationCount> getLocation() {
		
		return dao.getLocation();
	}
	public List<LocationCount> getJob() {
		
		return dao.getJobCount();
	}
	
	public List<LocationCount> getSkill()
	{
		List<LocationCount> count=new ArrayList<>();
		count.add(new LocationCount("C",dao.getSkillCount("C")));
		count.add(new LocationCount("Java",dao.getSkillCount("Java")));
		count.add(new LocationCount("Spring",dao.getSkillCount("Spring")));
		count.add(new LocationCount("Python",dao.getSkillCount("Python")));
		return count;
		
	}
	public String checkUser(String token) {
		
		String responseString;
		if(	dao.checkUser(token))
			responseString="Login sucessfull and User is Authenticated";
		else {
			responseString="Login failed,please try again";
		}
		
		return responseString;
	}
}
