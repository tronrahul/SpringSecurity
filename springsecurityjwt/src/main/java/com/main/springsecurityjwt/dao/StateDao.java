package com.main.springsecurityjwt.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.springsecurityjwt.entities.State;

public interface StateDao extends JpaRepository<State, Integer>{

	List<State> findByCountryCountryId(Integer id);
}
