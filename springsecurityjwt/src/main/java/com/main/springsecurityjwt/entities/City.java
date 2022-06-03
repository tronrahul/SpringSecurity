package com.main.springsecurityjwt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="City")
public class City {

	@Id
	@GeneratedValue
	@Column(name = "CITY_ID")
	private Integer cityId;
	
	@Column(name ="CITY_NAME")
	private String cityName;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private State state;

	public City(String cityName, State state) {
		this.cityName = cityName;
		this.state = state;
	}
	
	public City() {}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
