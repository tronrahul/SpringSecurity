package com.main.springsecurityjwt.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.springsecurityjwt.entities.City;
import com.main.springsecurityjwt.entities.Country;
import com.main.springsecurityjwt.entities.State;
import com.main.springsecurityjwt.service.AddressDetailService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/drop")
public class AddressController {
	
	@Autowired
	AddressDetailService addressDetailsService;
	
//	@PostMapping("/add")
//	public String add() {
//		return addressDetailsService.add();
//	}
	
//	
	@GetMapping("/getCountry")
	public List<Country> getCountry(){
		return addressDetailsService.getCountry();
	}
	
	@GetMapping("/getState/{id}")
	public List<State> findByCountryCountryId(@PathVariable("id") Integer id){
		return addressDetailsService.findByCountryCountryId(id);
	}
	
	@GetMapping("/getCity/{id}")
		public List<City> findByStateStateId(@PathVariable("id") Integer id){
		return addressDetailsService.findByStateStateId(id);
	}
}
