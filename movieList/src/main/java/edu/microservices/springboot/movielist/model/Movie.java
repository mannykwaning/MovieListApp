package edu.microservices.springboot.movielist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Emmanuel Aboah
 * */

@Entity
public class Movie
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 3, max = 25)
	private String title;

	@NotNull
	@Min(1900)
	private String year;

	@NotNull
	@Size(min = 3, max = 25)
	private String director;

	@NotNull
	@Size(min = 3, max = 25)
	private String star;

	@NotNull
	@Size(min = 3, max = 25)
	private String viewer;

	@NotNull
	@Size(min = 0, max = 255)
	private String description;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	public String getDirector()
	{
		return director;
	}

	public void setDirector(String director)
	{
		this.director = director;
	}

	public String getStar()
	{
		return star;
	}

	public void setStar(String star)
	{
		this.star = star;
	}

	public String getViewer()
	{
		return viewer;
	}

	public void setViewer(String viewer)
	{
		this.viewer = viewer;
	}

	@Override
	public String toString()
	{
		return "Movie [id= " + id + ", Title= " + title + ", Year= " + year + ", Director= " + director
				+ ", Strarring: " + star + ", Description= " + description + "]";
	}

}
