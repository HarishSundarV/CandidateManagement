package com.gotham.batman;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.gotham.batman.models.Candidate;

public class TestRest extends AbstractTest{
	@Test
	public void getCandidates() throws Exception {
	   String uri = "/getallcandidates";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Candidate[] candidates = super.mapFromJson(content, Candidate[].class);
	   assertTrue(candidates.length > 0);
	}
}
