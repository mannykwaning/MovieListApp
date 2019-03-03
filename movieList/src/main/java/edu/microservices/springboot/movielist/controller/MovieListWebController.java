package edu.microservices.springboot.movielist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.microservices.springboot.movielist.model.Movie;
import edu.microservices.springboot.movielist.service.MovieService;

@Controller
@RequestMapping("/movieList")
public class MovieListWebController
{

	private MovieService movieService;
	//private String year;

	@Autowired
	public MovieListWebController(MovieService movieService) {
		this.movieService = movieService;
	}

	@PostMapping
	public String addToMovies(Movie movie) {
		//year = movie.getYear();
		movieService.saveMovie(movie);
		return "redirect:/movieList";
	}

	@GetMapping
	public String getMoviesByYear(Model model) {
		List<Movie> movies = movieService.findAll();
		if (movies != null) {
			model.addAttribute("movies", movies);
		}
		return "movieList";
	}
	
}
