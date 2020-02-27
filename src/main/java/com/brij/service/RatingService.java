package com.brij.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brij.dao.RatingRepository;
import com.brij.model.Rating;

@Service
public class RatingService {
	
	@Autowired
	RatingRepository ratingRepo;
	
	public Rating createRating(Rating rat) {
		
		return ratingRepo.save(rat);
		
	}
	
	public Rating updateRating(Rating rat) {
		
		Rating old = findRatingById(rat.getRatingId());
		old = rat;
		return ratingRepo.save(old);
		
	}
	
	public void deleteRating(int id) {
		
		ratingRepo.deleteById(id);
		
	}
	
	public Rating findRatingById(int id) {
		
		return ratingRepo.findById(id).get();
		
	}
	
	public List<Rating> findAllRatings() {
		return (List<Rating>) ratingRepo.findAll();
	}
	
	
}
