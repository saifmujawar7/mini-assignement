package com.hashedin.miniproject.controller;

import com.hashedin.miniproject.MovieDetails;
import com.hashedin.miniproject.models.Movie;
import com.hashedin.miniproject.repositories.MovieuploadRepository;
import com.hashedin.miniproject.services.MovieService;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParserSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.univocity.parsers.csv.CsvParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private static Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieuploadRepository movieuploadRepository;

    @PostMapping("/upload")
    public String uploadData(@RequestParam("file") MultipartFile file) throws Exception{
        List<MovieDetails> movieList = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record->{
            MovieDetails movie = new MovieDetails();
            movie.setImdb_title_id(record.getString("imdb_title_id"));
            movie.setTitle(record.getString("title"));
            movie.setYear(record.getInt("year"));
            movie.setBudget(record.getString("budget"));
            movie.setReviews_from_users(record.getString("reviews_from_users"));
            movie.setCountry(record.getString("country"));
            movie.setGenre(record.getString("genre"));
            movie.setDuration(record.getInt("duration"));
            movie.setDirector(record.getString("director"));
            movieList.add(movie);
        });
        movieuploadRepository.saveAll(movieList) ;
        return "Upload Successfull!!";
    }

    @PostMapping
    public Movie save(@RequestBody Movie movie){
        logger.info("save movie " + this.getClass().getName());
        return movieService.save(movie);
    }

    @GetMapping("/{year}")
    public Optional<MovieDetails> findById(@PathVariable(value = "year") int year){
        logger.info("find movie by year" + this.getClass().getName());
        return movieService.findById(year);
    }

    @GetMapping
    public List<MovieDetails> findAll(){
        logger.info("findAll movies " + this.getClass().getName());
        return movieService.findAll();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable(value = "id") String id,
    @RequestBody Movie movie){
        logger.info("update movie " + this.getClass().getName());
        return movieService.update(id, movie);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") String id){
        logger.info("Edit Configurations… movie " + this.getClass().getName());
        return movieService.delete(id);
    }
}