package com.gotham.batman.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gotham.batman.dao.CandidateDAOCustom;
import com.gotham.batman.models.Candidate;
import com.gotham.batman.models.LocationCount;

public class CandidateDAOImpl implements CandidateDAOCustom{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String CHECK_USER = "SELECT count(*) FROM user WHERE id = ?";
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
	
			 String sql="select * from candidate where location like '%"+location_choice+"%'";
			return jdbcTemplate.query(sql,
			 //           "select * from candidate where location like '%'?'%'",new Object[]{location_choice},
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
	public List<LocationCount> getLocation()
	{
		
		
			return jdbcTemplate.query(
			            "select location,count(*) as count from candidate group by location",
			            (rs, rowNum) ->
			                    new LocationCount(rs.getString("location"), rs.getInt("count")   )   	                      
			                    
			    );
		
	}
	public int getSkillCount(String skill) {
	   
	    String sql = "SELECT count(*) FROM candidate WHERE last_name like '%"+skill+"%'";

	    Integer count = (Integer) jdbcTemplate.queryForObject(sql, Integer.class);

	    return count;
	}
	public List<LocationCount> getJobCount()
	{
		
		
			return jdbcTemplate.query(
			            "select job_description,count(*) as count from candidate group by job_description;",
			            (rs, rowNum) ->
			                    new LocationCount(rs.getString("job_description"), rs.getInt("count")   )   	                      
			                    
			    );
		
	}
public boolean checkUser(String token) {
		
		if (jdbcTemplate.queryForObject(CHECK_USER, new Object[] { token }, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
