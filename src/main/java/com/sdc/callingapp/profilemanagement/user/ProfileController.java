package com.sdc.callingapp.profilemanagement.user;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	//send verification mail to GUC mail
	@RequestMapping(method=RequestMethod.POST, value="/verify")
	public Map<String, String> verifyAccount(@RequestBody Profile user) {

		return Collections.singletonMap("message", profileService.verifyAccount(user));

	}

	//confirm guc mail
	@RequestMapping(method=RequestMethod.GET, value="/confirm/{token}")
	public Profile confirmToken(@PathVariable String token) {
		System.out.println(token);
		return profileService.confirmToken(token);

	}
	
	//get all profiles
	@RequestMapping(method=RequestMethod.GET, value="/find/all")
	public List<Profile> getAllProfiles() {

		return profileService.findAll();

	}
	
	




}
