package edu.microservices.springboot.movielist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;

import edu.microservices.springboot.movielist.model.Movie;
import edu.microservices.springboot.movielist.repository.MovieListRepository;

@Service
public class MovieServiceImpl implements MovieService
{
	@Autowired
	private MovieListRepository movieRepository;

	@Override
	public List<Movie> findAll()
	{
		return movieRepository.findAll();
	}

	@Override
	public Movie saveMovie(Movie movie)
	{
		return movieRepository.save(movie);
	}
	
}
