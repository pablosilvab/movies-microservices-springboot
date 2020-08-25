package io.kadevl.ratingsdataservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kadevl.ratingsdataservice.models.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating("M01", 10);
	}
	
}
