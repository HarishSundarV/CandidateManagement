package com.gotham.batman;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
//import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gotham.batman.dao.CandidateDAO;
import com.gotham.batman.models.Candidate;
import com.gotham.batman.models.LocationCount;
import com.gotham.batman.service.CandidateService;

@SpringBootTest
class CandidateManagementApplicationTests  {
	@Mock
	List<Candidate> CandidateList = new ArrayList<Candidate>();
	@Autowired
	private JdbcTemplate jdbc;
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
	//	Candidate o = new Candidate(1, "Harish", "Sundar", "managerEmail", "contactNumber", "location", "skills", "football");
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
	//	Candidate o = new Candidate(1, "Harish", "Sundar", "managerEmail", "contactNumber", "location", "skills", "123444");
		Candidate  b= new Candidate(1, "Sundar", "veidt", "Email", "contactNumber", "location", "skills", "123444");
		service.addCandidate(b);
		
		verify(repository,times(1)).save(b);
	
	}
	
	
	// DAO layer tests 
	
	@Test
	public void getDaoLocationCountTest() {

		when(repository.getLocation())
				.thenReturn(Stream.of(new LocationCount("bangalore", 2),new LocationCount("chennai", 8)).collect(Collectors.toList()));
		assertEquals(2, repository.getLocation().size());
	}
	@Test
	public void getDaoAllTest() {

		when(repository.getAllCandidates())
				.thenReturn(Stream.of(
						new Candidate(1, "Developer", "Harish", "managerEmail", "contactNumber", "location", "skills", "32"),
						new Candidate(2, "candidateName", "hiringManager", "managerEmail", "contactNumber", "location",
								"skills", "expectedDuration")).collect(Collectors.toList()));
		assertEquals(2, repository.getAllCandidates().size());
	}
//	
//	@Test
//	public void getAllCandidatesTest() {
//		Candidate c = new Candidate();
//		c.setContactNumber("9842422597");
//		c.setEmail("harish@gmail.com");
//		c.setFeedback("good");
//		c.setLocation("chennai");
//		c.setFirstName("harish");
//		c.setLastName("sundar");
//		c.setId(1);
//		
//		CandidateList.add(c);
//		Mockito.when(jdbc.query("", ArgumentMatchers.any(RowMapper.class))).thenReturn(this.CandidateList);
//		List<Candidate> list = repository.getAllCandidates();
//		assertEquals(1, list.size());
//	}
	@Test
	public void getCandidatesByLocationTest() {
		Candidate c = new Candidate();
		c.setContactNumber("9842422597");
		c.setEmail("harish@gmail.com");
		c.setFeedback("good");
		c.setLocation("chennai");
		c.setFirstName("harish");
		c.setLastName("sundar");
		c.setId(1);
		List<Candidate> CandidateList = new ArrayList<Candidate>();
		CandidateList.add(c);
		Mockito.when(jdbc.query(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class))).thenReturn(CandidateList);
		List<Candidate> list = repository.getCandidateByLocation("chennai");
		assertEquals(1, list.size());
	}
	
	
	
	// Controller tests
//	@Test
//	public void testShouldReturnMessage() throws Exception {
//	mockMvc.perform(MockMvcRequestBuilders.get("/addcandidate")).andExpect(MockMvcResultMatchers.status().is(200))
//	.andExpect(MockMvcResultMatchers.content().string("completed"))
//	.andExpect(MockMvcResultMatchers.header().string("Content-Type", "text/plain;charset=UTF-8"))
//	.andExpect(MockMvcResultMatchers.header().string("Content-Length", "11"));
//	}
    
}
