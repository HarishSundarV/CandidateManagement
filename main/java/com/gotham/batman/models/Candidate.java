package com.gotham.batman.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	
	private String lastName;
	private String email;
	private String location;
	private String feedback;
	private String jobDescription;
	private String contactNumber;
	
	public Candidate()
	{
		
	}
	public Candidate(int id,String firstName, String lastName, String email, String location, String feedback,
			String jobDescription, String contactNumber) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.feedback = feedback;
		this.jobDescription = jobDescription;
		this.contactNumber = contactNumber;
	}
	public Candidate(String firstName, String lastName, String email, String location, String feedback,
			String jobDescription, String contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.feedback = feedback;
		this.jobDescription = jobDescription;
		this.contactNumber = contactNumber;
	}
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", location=" + location + ", feedback=" + feedback + ", jobDescription=" + jobDescription
				+ ", contactNumber=" + contactNumber + "]";
	}
	
}
