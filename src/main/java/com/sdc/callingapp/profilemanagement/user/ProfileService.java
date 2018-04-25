package com.sdc.callingapp.profilemanagement.user;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private EmailService emailService;

	public String verifyAccount(Profile profile) {
		
		Profile existingProfile = profileRepository.findByGucMail(profile.getGucMail());
		
		if(existingProfile != null) {
			existingProfile.setConfirmationGmail(profile.getGmail());
			existingProfile.setConfirmationToken(profile.getGucMail() + "-" + UUID.randomUUID().toString());
			profileRepository.save(existingProfile);
			
			return sendConfirmationMail(existingProfile);
		}else {
			Profile newProfile = new Profile(profile.getGucMail());
			newProfile.setConfirmationGmail(profile.getGmail());
			newProfile.setConfirmationToken(profile.getGucMail() + "-" + UUID.randomUUID().toString());
			profileRepository.save(newProfile);
			
			return sendConfirmationMail(newProfile);
		}
		
	}
	
	public String sendConfirmationMail(Profile profile) {
		
		SimpleMailMessage registrationEmail = new SimpleMailMessage();
		registrationEmail.setTo(profile.getGucMail());
		registrationEmail.setSubject("GUC SDC Calling App Registeration Confirmation");
		registrationEmail.setText("To confirm your GUC mail address, please click the link below:\n"
				+"http://localhost:8080/profile/confirm/" + profile.getConfirmationToken());
		registrationEmail.setFrom("noreply@guc.sdc.callingapp");
		
		emailService.sendEmail(registrationEmail);
		
		return "Confirmation mail sent to " + profile.getGucMail() ;
	}

	public Profile confirmToken(String token) {
		
		Profile user = profileRepository.findByConfirmationToken(token);
		user.setGmail(user.getConfirmationGmail());
		user.setConfirmationGmail(null);
		user.setConfirmationToken(null);
		user.setVerified(true);
		
		profileRepository.save(user);
		return user;
	}

	public List<Profile> findAll() {
		
		return profileRepository.findAll();
	}
	
	
	
	
	
	
}
