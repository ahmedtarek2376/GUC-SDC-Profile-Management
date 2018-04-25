package com.sdc.callingapp.profilemanagement.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {
	
	public Profile findByGmail(String googleMail);
	public Profile findByGucMail(String gucMail);
	public Profile findByConfirmationToken(String confirmationToken);
}
