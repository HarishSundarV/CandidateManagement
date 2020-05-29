package com.gotham.batman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gotham.batman.models.Candidate;
import com.gotham.batman.services.CandidateService;

@RestController
public class AddCandidateController {
	@Autowired
	private CandidateService candidateService;
	@RequestMapping(value="/addcandidate", method=RequestMethod.POST)
	@ResponseBody
	public void addCandidate(@RequestParam Candidate candidate)
	{
		candidateService.addCandidate(candidate);
	}
}
