package com.gotham.batman;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.gotham.batman.controllers.CandidateController;
import com.gotham.batman.models.Candidate;
import com.gotham.batman.models.LocationCount;
import com.gotham.batman.service.CandidateService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTests {
	
@MockBean
CandidateService service;
@Autowired
CandidateController controller;
public static Candidate createCandidateForTest()
{
	Candidate c = new Candidate();
	c.setContactNumber("9842422597");
	c.setEmail("harish@gmail.com");
	c.setFeedback("good");
	c.setLocation("chennai");
	c.setFirstName("harish");
	c.setLastName("sundar");
	c.setId(1);
	return c;
}
@Test
public void getCandidateControllerTest() {
	when(service.getAllCandidates()).thenReturn(Stream.of(
			new Candidate(1, "Developer", "Harish", "managerEmail", "contactNumber", "location", "skills", "32"),
			new Candidate(2, "candidateName", "hiringManager", "managerEmail", "contactNumber", "location",
					"skills", "expectedDuration"))
			.collect(Collectors.toList()));
	assertEquals(2, controller.getAllCandidates().size());
}

@Test
public void getCandidateByLocationControllerTest() {
	when(service.getCandidateByLocation("chennai")).thenReturn(Stream.of(
			new Candidate(1, "Developer", "Harish", "managerEmail", "chennai", "location", "skills", "32"))
			.collect(Collectors.toList()));
	assertEquals(1, controller.getCandidateByLoc("chennai").size());
}
@Test
public void getCandidateByIdControllerTest() {
	when(service.getCandidateById(1)).thenReturn(Stream.of(
			new Candidate(1, "Developer", "Harish", "managerEmail", "contactNumber", "location", "skills", "32"))
			.collect(Collectors.toList()));
	assertEquals(1, controller.getCandidateById(1).size());
}
@Test
public void getUserByIdControllerTest() {
	Candidate candidate =  createCandidateForTest();
	when(service.getUserById(1)).thenReturn(candidate);
	assertEquals(candidate, controller.getUserById(1));
}
@Test
public void getLocationCountTest() {

	when(service.getLocation())
			.thenReturn(Stream.of(new LocationCount("chennai", 5)).collect(Collectors.toList()));
	assertEquals(1, controller.getLocationCount().size());
}

@Test
public void getJobCountTest() {

	when(service.getJob())
			.thenReturn(Stream.of(new LocationCount("intern", 5)).collect(Collectors.toList()));
	assertEquals(1, controller.getJob().size());
}
@Test
public void updateCandidateTest() {
	Candidate candidate =  createCandidateForTest();
	when(service.updateCandidate(candidate)).thenReturn(Stream.of(
			new Candidate(1, "Developer", "Harish", "managerEmail", "contactNumber", "location", "skills", "32"))
			.collect(Collectors.toList()));
	assertEquals(0, controller.updateCandidate(candidate,1).size());
}
@Test
public void deleteCandidateTest() {
	
	when(service.deleteCandidate(1)).thenReturn(Stream.of(
			new Candidate(1, "Developer", "Harish", "managerEmail", "contactNumber", "location", "skills", "32"))
			.collect(Collectors.toList()));
	assertEquals(1, controller.deleteCandidate(1).size());
}
@Test
public void addCandidateTest() {
	Candidate o =  createCandidateForTest();
	when(service.addCandidate(o)).thenReturn("completed");
	assertEquals("completed", controller.addCandidate(o));
}
}
