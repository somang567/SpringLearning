package com.learning.springlearning.controller;

import com.learning.springlearning.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ConcurrentModificationException;
import java.util.List;

@RestController
public class CountryController {

	@GetMapping("/france")
	public ResponseEntity<Country> france(){
		Country country = Country.of("France" , 63);

		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.header("continent" , "Europe")
				.header("capital" , "Paris")
				.header("favorite_food" , "cheese and wine")
				.body(country);
	}

	@GetMapping("/all")
	public List<Country> countries(){
		Country c1 = Country.of("France" , 67);
		Country c2 = Country.of("Spain" , 47);

		return List.of(c1 , c2);
	}
}
