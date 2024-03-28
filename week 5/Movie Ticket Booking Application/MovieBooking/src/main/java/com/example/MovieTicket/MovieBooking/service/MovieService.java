package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.MovieTicket.MovieBooking.Exceptions.MovieAlreadyExistsException;
import com.example.MovieTicket.MovieBooking.Exceptions.MovieNotFoundException;
import com.example.MovieTicket.MovieBooking.Model.Movie;

@Service
public class MovieService implements TIcketService {

	public List<Movie> movieList =  new ArrayList<>();
	public Map<String, Movie> movieMap = new HashMap<>();
	
	@Override
	public void generateMovie(Movie movie) {
		if(! ObjectUtils.isEmpty(movieMap.get(movie.getId()))) {
			throw new MovieAlreadyExistsException("The movie already exist in the list");
		}
		movieList.add(movie);
		movieMap.put(movie.getId(), movie);

	}

	@Override
	public List<Movie> getAllMovies() {	
		return this.movieList;
	}

	@Override
	public Movie getMovieById(String id) {
		if(ObjectUtils.isEmpty(movieMap.get(id))) {
			throw new MovieNotFoundException("The Movie Does Not exist in the list");
		}
		return movieMap.get(id);
	}

	@Override
	public void deleteMovie(String id) {
		if(ObjectUtils.isEmpty(movieMap.get(id))) {
			throw new MovieNotFoundException("The Movie Does Not exist in the list");
		}
		Movie movie = movieMap.get(id);
		movieList.remove(movie);
		movieMap.remove(id);

	}

	@Override
	public void updateMovie(String id, Movie movie) {
		
		Movie movieOld = movieMap.get(id);
		movieList.remove(movieOld);
		movieMap.remove(id);
		movieList.add(movie);
		movieMap.put(id, movie);

	}

}
