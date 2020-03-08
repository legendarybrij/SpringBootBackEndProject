package com.brij.jwtauthentication.controller;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brij.jwtauthentication.message.request.LoginForm;
import com.brij.jwtauthentication.message.request.SignUpForm;
import com.brij.jwtauthentication.message.response.JwtResponse;
import com.brij.jwtauthentication.message.response.ResponseMessage;
import com.brij.jwtauthentication.model.Role;
import com.brij.jwtauthentication.model.RoleName;
import com.brij.jwtauthentication.model.User;
import com.brij.jwtauthentication.repository.RoleRepository;
import com.brij.jwtauthentication.repository.UserRepository;
import com.brij.jwtauthentication.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	JwtProvider jwtProvider;
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "pm":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);
		sendEmail(user.getEmail());
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
	
	void sendEmail(String email) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("weathmatrix@weathmatrix.com");
		msg.setTo(email);
		msg.setSubject("Welcome to Weath Matrix");
		msg.setText("You have been successfully registered to Wealth Matrix");
		javaMailSender.send(msg);
	}
	
//	void sendEmailWithAttachment() throws MessagingException, IOException {
//		MimeMessage msg=javaMailSender.createMimeMessage();
//		//true= multipart message
//		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
//		helper.setTo("1@gmail.com");
//		helper.setSubject("Testing from SpringBoot");
//		//default = text/plain
//		//helper.setText("Check attachment for image!");
//		//true = text/html
//		helper.setText("<h1>Check attachemnt for image!<h1>", true);
//		
//		//FileSystemResource file= new FileSystemResource(new File("classpath:android.png"))
//		
//		//Resource resource = new ClassPathResource("android.png");
//		//InputStream input = resource.getInputStream();
//		//ResourceUtils.getFile("classpath:android.png");
//		helper.addAttachment("test.jpg", new ClassPathResource("test.jpg"));
//		
//		javaMailSender.send(msg);
//	}
}