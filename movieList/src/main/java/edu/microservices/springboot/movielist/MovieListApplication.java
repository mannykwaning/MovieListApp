package edu.microservices.springboot.movielist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan("edu.microservices.springboot.movielist")
public class MovieListApplication extends WebMvcConfigurerAdapter
{

	public static void main(String[] args) 
	{
		SpringApplication.run(MovieListApplication.class, args);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) 
	{
		registry.addRedirectViewController("/", "/movieList");
	}

}

