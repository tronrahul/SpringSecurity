package com.main.springsecurityjwt.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.springsecurityjwt.entities.City;
import com.main.springsecurityjwt.entities.User;
import com.main.springsecurityjwt.models.AuthenticationRequest;
import com.main.springsecurityjwt.models.AuthenticationResponse;
import com.main.springsecurityjwt.save.SaveLogic;
import com.main.springsecurityjwt.service.MyUserDetailsService;
import com.main.springsecurityjwt.util.JwtUtil;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Resource {
	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	SaveLogic saveLogic;
	
	@GetMapping("/user")
	public String user() {
		return "Hello User";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Hello Admin";
	}
	
	@GetMapping("/cities")
	public void add()
	{
		saveLogic.save();
	}
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		return userDetailsService.getAll();
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody User user) {
		return userDetailsService.insert(user);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteUserById(@PathVariable("id") int id) {
		return userDetailsService.deleteUserById(id);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody User user) {
		return userDetailsService.update(user);
	}
	
	@GetMapping("/getById/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userDetailsService.getUserById(id);
//		return null;
	}
	
	@RequestMapping(value ="/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
					);
		}
		catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		String USER_ROLE =userDetails.getAuthorities().toString().replaceAll("[\\[\\]]", "");
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt,USER_ROLE));
				
	}
}
