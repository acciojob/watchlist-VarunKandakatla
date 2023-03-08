package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
@Service
public class MovieService {
    @Autowired
    MovieRepository repo;

    public ResponseEntity addMovie( Movie movie){
        repo.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

    public ResponseEntity addDirector( Director dir){
        repo.addDirector(dir);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }

    public ResponseEntity addMovieDirectorPair(String movie,  String director){

       repo.addMovieDirectorPair(movie,director);
        return new ResponseEntity("success",HttpStatus.ACCEPTED);
    }

    public ResponseEntity getMovieByName(String name){

        return new ResponseEntity(repo.getMovieByName(name),HttpStatus.CREATED);
    }

    public ResponseEntity getDirectorByName( String name){
        return new ResponseEntity<>(repo.getDirectorByName( name),HttpStatus.CREATED);
    }

    public ResponseEntity getMoviesByDirectorName(String name){

       return new ResponseEntity<>(getMoviesByDirectorName(name), HttpStatus.CREATED);

    }

    public ResponseEntity findAllMovies(){
       return new ResponseEntity<>(repo.findAllMovies(),HttpStatus.CREATED);
    }

    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){

        repo.deleteDirectorByName(name);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);

    }

    public ResponseEntity deleteAllDirectors(){
        repo.deleteAllDirectors();
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }
}
