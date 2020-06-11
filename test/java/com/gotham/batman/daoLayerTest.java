package com.gotham.batman;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.gotham.batman.dao.CandidateDAOCustom;
import com.gotham.batman.models.Candidate;
@RunWith(SpringRunner.class)
@SpringBootTest
public class daoLayerTest {
	@Autowired
	private JdbcTemplate jdbc;
@MockBean
CandidateDAOCustom dao;
@Autowired
private MockMvc mockMvc;
//
//@Test
//public void getCandidatesByLocationTest() {
//	Candidate c = new Candidate();
//	c.setContactNumber("9842422597");
//	c.setEmail("harish@gmail.com");
//	c.setFeedback("good");
//	c.setLocation("chennai");
//	c.setFirstName("harish");
//	c.setLastName("sundar");
//	c.setId(1);
//	List<Candidate> CandidateList = new ArrayList<Candidate>();
//	CandidateList.add(c);
//	Mockito.when(jdbc.query(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class))).thenReturn(CandidateList);
//	List<Candidate> list =dao.getCandidateByLocation("chennai");
//	assertEquals(1, list.size());
//}
@Test
public void testShouldReturnMessage() throws Exception {
mockMvc.perform(MockMvcRequestBuilders.get("/addcandidate")).andExpect(MockMvcResultMatchers.status().is(200))
.andExpect(MockMvcResultMatchers.content().string("completed"))
.andExpect(MockMvcResultMatchers.header().string("Content-Type", "text/plain;charset=UTF-8"))
.andExpect(MockMvcResultMatchers.header().string("Content-Length", "11"));
}
}
