package com.main.springsecurityjwt.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.main.springsecurityjwt.entities.Country;

public interface CountryDao extends JpaRepository<Country, Integer>{
}
