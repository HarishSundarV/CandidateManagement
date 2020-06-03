package com.gotham.batman.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gotham.batman.dao.CandidateDAOCustom;
import com.gotham.batman.models.Candidate;

public class CandidateDAOImpl implements CandidateDAOCustom{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Candidate> getAllCandidates()
	{
		 return jdbcTemplate.query(
	                "select * from candidate",
	                (rs, rowNum) ->
	                        new Candidate(
	                        		 rs.getInt("id"),
	                        	 rs.getString("first_name"),
	                                rs.getString("last_name"),
	                               rs.getString("email"),
	                               rs.getString("location"),
	                               rs.getString("feedback"),
	                               rs.getString("job_description"),
	                               rs.getString("contact_number")                        
	                        )
	        );
	}
	public List<Candidate> getCandidateByLocation(String location_choice)
	{
		 return jdbcTemplate.query(
	                "select * from candidate where location=?",new Object[]{location_choice},
	                (rs, rowNum) ->
	                        new Candidate(
	                        		 rs.getInt("id"),
	                        	 rs.getString("first_name"),
	                                rs.getString("last_name"),
	                               rs.getString("email"),
	                               rs.getString("location"),
	                               rs.getString("feedback"),
	                               rs.getString("job_description"),
	                               rs.getString("contact_number")                        
	                        )
	        );
	}
	public Integer getCountByLocation(String location_choice)
	{
		String sql="SELECT COUNT(*) FROM CANDIDATE WHERE LOCATION ='"+location_choice+"'";
		System.out.println(sql);
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
}
