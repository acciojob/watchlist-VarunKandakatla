package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService service;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        service.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){

         service.addDirector(director);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        service.addMovieDirectorPair(movie,director);
        return new ResponseEntity("success",HttpStatus.CREATED);
    }
    @GetMapping("movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity(service.getMovieByName(name),HttpStatus.CREATED);
    }

    @GetMapping("movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        return new ResponseEntity(service.getDirectorByName(name),HttpStatus.CREATED);
    }
    @GetMapping("movies/get-movies-by-director-name/{name}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("name") String name){
        return new ResponseEntity<>(service.getMoviesByDirectorName(name),HttpStatus.CREATED);
    }
    @GetMapping("movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity<>(service.findAllMovies(),HttpStatus.CREATED);
    }
    @DeleteMapping("movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){
        service.deleteDirectorByName(name);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @DeleteMapping("movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        service.deleteAllDirectors();
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
