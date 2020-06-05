package com.gotham.batman;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gotham.batman.dao.CandidateDAO;
import com.gotham.batman.models.Candidate;
import com.gotham.batman.models.LocationCount;
import com.gotham.batman.service.CandidateService;

@SpringBootTest
class CandidateManagementApplicationTests  {

	@Autowired
	private CandidateService service;
	@MockBean
	private CandidateDAO repository;
	@Test
	public void getCandidatesTest() {
		when(repository.getAllCandidates()).thenReturn(Stream.of(
				new Candidate(1, "Developer", "Harish", "managerEmail", "contactNumber", "location", "skills", "32"),
				new Candidate(2, "candidateName", "hiringManager", "managerEmail", "contactNumber", "location",
						"skills", "expectedDuration"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllCandidates().size());
	}
	@Test
	public void getUserbyAddressTest() {
		String address = "Bangalore";
		when(repository.getCandidateByLocation(address))
				.thenReturn(Stream.of(new Candidate(1, "Harish", "Sundar ", "managerEmail", "contactNumber", "location", "skills", "12344")).collect(Collectors.toList()));
		assertEquals(1, service.getCandidateByLocation(address).size());
	}
	@Test
	public void getLocationCountTest() {
		
		when(repository.getLocation())
				.thenReturn(Stream.of(new LocationCount("chennai",5)).collect(Collectors.toList()));
		assertEquals(1, service.getLocation().size());
	}
	
	@Test
	public void deletecandidateTest() {
		Candidate o = new Candidate(1, "Harish", "Sundar", "managerEmail", "contactNumber", "location", "skills", "football");
		service.deleteCandidate(1);
		verify(repository,times(1)).deleteById(1);
		
		
	}
	
	@Test
	public void addCandidateTest() {
		Candidate candidate = new Candidate(1, "Harish", "Sundar", "managerEmail", "contactNumber", "location", "skills", "12344");
	    service.addCandidate(candidate);
	  
	    verify(repository, times(1)).save(candidate);
	}
	@Test
	public void updatecandidateTest() {
		Candidate o = new Candidate(1, "Harish", "Sundar", "managerEmail", "contactNumber", "location", "skills", "123444");
		Candidate  b= new Candidate(1, "Sundar", "veidt", "Email", "contactNumber", "location", "skills", "123444");
		service.addCandidate(b);
		
		verify(repository,times(1)).save(b);
	
	}
	
}
