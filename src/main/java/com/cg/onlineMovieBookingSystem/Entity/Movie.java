package com.cg.onlineMovieBookingSystem.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Movie")
@OnDelete(action=OnDeleteAction.CASCADE)
public class Movie {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="movieId")
	private int movieId;
	
	@Column(name="movieName")
	private String movieName;
	
	@Column(name="movieGenre")
	private String movieGenre;
	
	@Column(name="movieDirector")
	private String movieDirector;
	
	@Column(name="movieLength")
	private int movieLength;
	
	@ElementCollection
	private List<String> languages;
	
	@Column(name="movieReleaseDate")
	private Date movieReleaseDate;

	public Movie() {
		
	}

	public Movie(int movieId, String movieName, String movieGenre, String movieDirector, int movieLength,
			List<String> languages, Date movieReleaseDate) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieDirector = movieDirector;
		this.movieLength = movieLength;
		this.languages = languages;
		this.movieReleaseDate = movieReleaseDate;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieString(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	
	
}
