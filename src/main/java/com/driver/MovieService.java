package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository repo;

    public void addMovie( Movie movie){
        repo.addMovie(movie);

    }

    public void addDirector( Director dir){
        repo.addDirector(dir);

    }

    public void addMovieDirectorPair(String movie,  String director){

       repo.addMovieDirectorPair(movie,director);

    }

    public Movie getMovieByName(String name){

//        return new ResponseEntity(repo.getMovieByName(name),HttpStatus.CREATED);
        return repo.getMovieByName(name);
    }

    public Director getDirectorByName( String name){
//        return new ResponseEntity<>(repo.getDirectorByName( name),HttpStatus.CREATED);
        return repo.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String name){

     return repo.getMoviesByDirectorName(name);

    }

    public List<String> findAllMovies(){
       return repo.findAllMovies();
    }

    public void deleteDirectorByName(@RequestParam("name") String name){

        repo.deleteDirectorByName(name);


    }

    public void deleteAllDirectors(){
        repo.deleteAllDirectors();

    }
}
