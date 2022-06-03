package com.main.springsecurityjwt.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.springsecurityjwt.entities.City;

public interface CityDao extends JpaRepository<City, Integer>{

	List<City> findByStateStateId(Integer id);
}
