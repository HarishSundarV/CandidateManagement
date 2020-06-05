package com.gotham.batman.models;

public class LocationCount {
	String location;
	int count;
	public LocationCount() {}
	public LocationCount(String location,int count) {
		this.location = location;
		this.count = count;
	}
	@Override
	public String toString() {
		return "LocationCount [location=" + location + ", count=" + count + "]";
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
