package com.main.springsecurityjwt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.springsecurityjwt.entities.City;

@Component
public class CityDao2 
{
	@Autowired
	CityDao cityDao;
	
	public void saveAll(List<City> ccc)
	{
		cityDao.saveAll(ccc);
	}
}
