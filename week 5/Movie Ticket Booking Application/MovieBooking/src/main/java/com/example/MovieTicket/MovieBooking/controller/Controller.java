package com.example.MovieTicket.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieTicket.MovieBooking.Exceptions.MovieBodyInvalidException;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class Controller {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	

	@PostMapping("/movie")
	public void generateTicket(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new MovieBodyInvalidException("Movie parameters doesn't passes the validation");
		}
		System.out.println(movie);
		movieService.generateMovie(movie);
	}
	
	@GetMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable String id) {
		return movieService.getMovieById(id);
	}
	
	@DeleteMapping("/movie/{id}")
	public void removeMovieById(@PathVariable String id) {
		movieService.deleteMovie(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateMovieById(@PathVariable String id,@Valid @RequestBody Movie movie , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new MovieBodyInvalidException("Movie Parameter doesn't passes the validation");
		}
		movieService.updateMovie(id, movie);
	}
}
