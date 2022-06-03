package com.main.springsecurityjwt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.springsecurityjwt.dao.CityDao;
import com.main.springsecurityjwt.dao.CountryDao;
import com.main.springsecurityjwt.dao.StateDao;
import com.main.springsecurityjwt.entities.City;
import com.main.springsecurityjwt.entities.Country;
import com.main.springsecurityjwt.entities.State;
import com.main.springsecurityjwt.save.SaveLogic;

@Service
public class AddressDetailService {

	@Autowired
	CountryDao countryDao;
	
	@Autowired
	StateDao stateDao;
	
	@Autowired
	CityDao cityDao;

	public List<Country> getCountry() {
		return countryDao.findAll();
	}

	public List<State> findByCountryCountryId(Integer id) {
		return stateDao.findByCountryCountryId(id);
	}

	public List<City> findByStateStateId(Integer id) {
		return cityDao.findByStateStateId(id);
	}
	
}
