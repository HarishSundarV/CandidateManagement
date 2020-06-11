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
		 try {
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
		} catch (DataAccessException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public List<Candidate> getCandidateByLocation(String location_choice)
	{
		 try {
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
		} catch (DataAccessException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public List<LocationCount> getLocation()
	{
		
		 try {
			return jdbcTemplate.query(
			            "select location,count(*) as count from candidate group by location",
			            (rs, rowNum) ->
			                    new LocationCount(rs.getString("location"), rs.getInt("count")   )   	                      
			                    
			    );
		} catch (DataAccessException e) {
			
			e.printStackTrace();
			return null;
		}
	}
public boolean checkUser(String token) {
		
		if (jdbcTemplate.queryForObject(CHECK_USER, new Object[] { token }, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
