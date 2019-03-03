package edu.microservices.springboot.movielist.service;

import java.util.List;

import edu.microservices.springboot.movielist.model.Movie;

public interface MovieService
{
	List<Movie> findAll();
	
	Movie saveMovie(Movie movie);
}
