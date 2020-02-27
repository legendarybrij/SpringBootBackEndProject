package com.brij.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brij.model.Rating;
import com.brij.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	RatingService rService;
	
	@PostMapping(path="/newRating")
	public Rating createRating(@RequestBody Rating r){
		
		return rService.createRating(r);
	}
	
	@PostMapping(path="/updateRating")
	public Rating updateRating(@RequestBody Rating r){
		
		return rService.updateRating(r);
	}
	
	@PostMapping(path="/deleteRating", consumes={"application/json"})
	public void deleteRating(@RequestBody Rating r) {
		rService.deleteRating(r.getRatingId());
	}
	
	@GetMapping(path="/findRatingById")
	public Rating findRatingById(@RequestBody Rating r) {
		return rService.findRatingById(r.getRatingId());
	}
	
	@GetMapping(path="/findAllRatings")
	public List<Rating> findAllRatings() {
		return rService.findAllRatings();
	}
	
	
	
}
