package io.kadevl.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kadevl.ratingsdataservice.models.Rating;
import io.kadevl.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating("M01", 10);
	}
	
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings =  Arrays.asList(new Rating("M01", 10), new Rating("M02", 6));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
	
}
