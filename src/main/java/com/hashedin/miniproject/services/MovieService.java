package com.hashedin.miniproject.services;

import com.hashedin.miniproject.MovieDetails;
import com.hashedin.miniproject.models.Movie;
import com.hashedin.miniproject.repositories.MovieRepository;
import com.hashedin.miniproject.repositories.MovieuploadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private static Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieuploadRepository movieuploadRepository;

    public Movie save(Movie movie){
        logger.info("save movie " + this.getClass().getName());
        return movieRepository.save(movie);
    }

    public List<Movie> saveAll(List<Movie> movieList){
        logger.info("save movies " + this.getClass().getName());
        return  movieRepository.saveAll(movieList);
    }

    public Optional<MovieDetails> findById(int id){
        logger.info("find movie by id" + this.getClass().getName());
        return movieuploadRepository.findById(String.valueOf(id));
    }

    public List<MovieDetails> findAll(){
        logger.info("findAll movies " + this.getClass().getName());
        return movieuploadRepository.findAll();
    }

    public String update(String id, Movie movie){
        logger.info("update movie " + this.getClass().getName());
        return movieRepository.update(id, movie);
    }

    public String delete(String id){
        logger.info("Edit Configurations… movie " + this.getClass().getName());
        return movieRepository.delete(id);
    }

}
