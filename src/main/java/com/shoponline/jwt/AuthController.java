package com.shoponline.jwt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;
	
	@Autowired 
	private jwtUtils jwtUtils;
	
	
	@GetMapping("/all")
	public String all() {
		return "Duc thao";
	}
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody LoginRequest jwtRequest) throws Exception {

	    try{
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        jwtRequest.getUsername(),
	                        jwtRequest.getPassword()
	                )
	        );
	    } catch (BadCredentialsException e) {
	        throw new Exception("Invalid Credentials", e);
	    }
 
	    final UserDetails userDetails
	            = detailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());

	    final String token =
	    		jwtUtils.generateToken(userDetails);

	    return new JwtResponse(token);
	}
    

}
