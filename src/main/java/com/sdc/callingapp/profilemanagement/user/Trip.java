package com.sdc.callingapp.profilemanagement.user;

import java.util.Date;
import java.util.List;

public class Trip {
	
	private String id;
	
	private Date requestTime;
	private Date startTime;
	private Date endTime;
	private Date cancelTime;
	
	private String pickupLocation;
	private List<String> destinations;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public List<String> getDestinations() {
		return destinations;
	}
	public void setDestinations(List<String> destinations) {
		this.destinations = destinations;
	}
	
	
	
}
