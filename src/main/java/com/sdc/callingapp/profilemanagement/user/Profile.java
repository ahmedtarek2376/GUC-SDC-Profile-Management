package com.sdc.callingapp.profilemanagement.user;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Profile {

	@Id
	private String id;

	private String gmail;
	
	private String gucMail;

	private boolean verified;
	
	private String confirmationGmail;
	
	@Indexed(sparse=true)
	private String confirmationToken;
	
	private List<Trip> tripHistory;
	
	private Trip currentTrip;
	
	public Profile() {
	}
	
	public Profile(String gucMail) {
		this.gucMail = gucMail;
		this.verified = false;
	}

	
	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getConfirmationGmail() {
		return confirmationGmail;
	}

	public void setConfirmationGmail(String confirmationGmail) {
		this.confirmationGmail = confirmationGmail;
	}

	public List<Trip> getTripHistory() {
		return tripHistory;
	}

	public void setTripHistory(List<Trip> tripHistory) {
		this.tripHistory = tripHistory;
	}
	
	public String getGucMail() {
		return gucMail;
	}
	
	public void setGucMail(String gucMail) {
		this.gucMail = gucMail;
	}
	
	public boolean isVerified() {
		return verified;
	}
	
	public void setVerified(boolean enabled) {
		this.verified = enabled;
	}
	
	public String getConfirmationToken() {
		return confirmationToken;
	}
	
	public void setConfirmationToken(String string) {
		this.confirmationToken = string;
	}
	
	public String getId() {
		return id;
	}

	public Trip getCurrentTrip() {
		return currentTrip;
	}

	public void setCurrentTrip(Trip currentTrip) {
		this.currentTrip = currentTrip;
	}
	
	

}
