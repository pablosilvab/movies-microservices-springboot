package io.kadevl.moviecatalogservice.controller;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.kadevl.moviecatalogservice.model.CatalogItem;
import io.kadevl.moviecatalogservice.model.Movie;
import io.kadevl.moviecatalogservice.model.Rating;
import io.kadevl.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating ratings = restTemplate.getForObject("http://localhost:8082/ratings/users/ " + userId, UserRating.class);

		return ratings.getUserRating().stream().map(rating -> {
			// Por cada ID de pelicula, obtengo la información de aquella.
			Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
			// Retorno todo junto.
			return new CatalogItem(movie.getName(), "Description - " + movie.getName(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
