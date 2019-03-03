package edu.microservices.springboot.movielist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.microservices.springboot.movielist.model.Movie;

public interface MovieListRepository extends JpaRepository<Movie, Long>
{
	List<Movie> findAll();
}
