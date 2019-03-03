package edu.microservices.springboot.movielist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.microservices.springboot.movielist.model.Movie;
import edu.microservices.springboot.movielist.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieListRestController 
{
	@Autowired
	private MovieService movieService;
	
	/*GET to retrieve a movie by title*/
	@RequestMapping(value = "/attributes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> getMoviesbyTitle(@RequestParam(value = "year", required = true) String year) {
		List<Movie> movies = movieService.findAll();
		if (movies.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	/*Path variable*/
	@RequestMapping(value="/{movieId}", method = RequestMethod.GET)
	public ResponseEntity<Movie> getMovieById(@PathVariable("MovieId") Long movieId)
	{
		Movie movie = new Movie();
		movie.setId(movieId);
		movie.setTitle("If Beele Street could talk");
		movie.setDirector("Steven Spielberg");
		movie.setStar("Idris Alba");
		
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
	
	/*PUT to update a movie in database*/
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie)
	{
		System.out.println("Updatng Movie with: " + movie);		
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
	
	/*POST a movie to database*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewMovie(@RequestBody Movie movie)
	{
		System.out.println("Adding a movie: " + movie);
		return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
	}
	
	/*Remove/DELETE a movie*/
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> removeMovie()
	{
		return new ResponseEntity<String>("Movie was removed successfully", HttpStatus.OK);
	}
	
}
