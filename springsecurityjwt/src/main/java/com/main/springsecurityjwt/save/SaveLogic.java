package com.main.springsecurityjwt.save;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.springsecurityjwt.dao.CityDao;
import com.main.springsecurityjwt.dao.CityDao2;
import com.main.springsecurityjwt.entities.City;
import com.main.springsecurityjwt.entities.Country;
import com.main.springsecurityjwt.entities.State;


@Component
public class SaveLogic 
{
	Country co;
	State s;
	City c,c2,c3,c4;
	List<City> cities = new ArrayList<City>();
	@Autowired
	CityDao2 cityDao;
	public SaveLogic()
	{
		


		
		
		
	}
	public void save()
	{
		co=new Country();
		co.setCountryName("india");
		s=new State();
		s.setStateName("MP");
		s.setCountry(co);
		c=new City();
		c.setCityName("indore");
		c.setState(s);
		cities.add(c);
		c2=new City();
		c2.setCityName("Bhopal");
		c2.setState(s);
		cities.add(c2);
		c3=new City();
		c3.setCityName("Dewas");
		c3.setState(s);
		cities.add(c3);
		c4=new City();
		c4.setCityName("Ujjain");
		c4.setState(s);
		cities.add(c4);
		cityDao.saveAll(cities);
		
		
		s=new State();
		s.setStateName("Rajsthan");
		s.setCountry(co);
		c=new City();
		c.setCityName("jaipur");
		c.setState(s);
		cities.add(c);
		c2=new City();
		c2.setCityName("udaipur");
		c2.setState(s);
		cities.add(c2);
		c3=new City();
		c3.setCityName("jaisalmer");
		c3.setState(s);
		cities.add(c3);
		c4=new City();
		c4.setCityName("bhangarh");
		c4.setState(s);
		cities.add(c4);
		cityDao.saveAll(cities);
		
		s=new State();
		s.setStateName("Chattisgarh");
		s.setCountry(co);
		c=new City();
		c.setCityName("bhilai");
		c.setState(s);
		cities.add(c);
		c2=new City();
		c2.setCityName("raipur");
		c2.setState(s);
		cities.add(c2);
		c3=new City();
		c3.setCityName("bilaspur");
		c3.setState(s);
		cities.add(c3);
		c4=new City();
		c4.setCityName("korba");
		c4.setState(s);
		cities.add(c4);
		cityDao.saveAll(cities);
		
		
		s=new State();
		s.setStateName("Gujrat");
		s.setCountry(co);
		c=new City();
		c.setCityName("surat");
		c.setState(s);
		cities.add(c);
		c2=new City();
		c2.setCityName("gandhinagar");
		c2.setState(s);
		cities.add(c2);
		c3=new City();
		c3.setCityName("Ahamdabad");
		c3.setState(s);
		cities.add(c3);
		c4=new City();
		c4.setCityName("rajkot");
		c4.setState(s);
		cities.add(c4);
		cityDao.saveAll(cities);

	}
	
	
	
}
