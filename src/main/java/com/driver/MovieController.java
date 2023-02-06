package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService service;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        return service.addMovie(movie);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director dir){
        return service.addDirector(dir);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        return service.addMovieDirectorPair(movie,director);
    }
    @GetMapping("movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        return service.getMovieByName(name);
    }

    @GetMapping("movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        return service.getDirectorByName(name);
    }
    @GetMapping("movies/get-movies-by-director-name/{name}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("name") String name){
        return service.getMoviesByDirectorName(name);
    }
    @GetMapping("movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        return service.findAllMovies();
    }
    @DeleteMapping("movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){
        return service.deleteDirectorByName(name);
    }
    @DeleteMapping("movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        return service.deleteAllDirectors();
    }
}
