package io.kadevl.movieinfoservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kadevl.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@RequestMapping("{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Inglourious Basterds");
	}
	
}
