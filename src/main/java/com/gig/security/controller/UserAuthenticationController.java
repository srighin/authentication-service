package com.gig.security.controller;

import com.gig.security.entity.Role;
import com.gig.security.entity.User;
import com.gig.security.exception.BadRequestException;
import com.gig.security.exception.EmailAlreadyExistsException;
import com.gig.security.exception.UsernameAlreadyExistsException;
import com.gig.security.model.SignUpRequest;
import com.gig.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@Slf4j
public class UserAuthenticationController {
	
	@GetMapping("/v1/authenticate")
	public String verifyAuthentication() {
		return "You are successfully Authenticated!!";
	}

	@Autowired
	private UserService userService;

	@PostMapping(value = "/v1/signup", produces = MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@Valid @RequestBody SignUpRequest payload) {
		log.info("creating user {}", payload.getUsername());

		User user = User
				.builder()
				.firstName(payload.getFirstName())
				.firstName(payload.getLastName())
				.username(payload.getUsername())
				.email(payload.getEmail())
				.password(payload.getPassword())
				.mfa(false)
				.roles(Collections.singleton(Role.builder().id(1l).name("USER").build()))
				.build();


		User saved;
		try {
			saved = userService.registerUser(user);
		} catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
			throw new BadRequestException(e.getMessage());
		}
		if(saved != null){
			return "User is created Successfully";
		}
		throw new RuntimeException("Issue creating users");

	}

}
