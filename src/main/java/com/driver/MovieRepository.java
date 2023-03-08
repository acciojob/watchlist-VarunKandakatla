package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    Map<String, Movie> movieMap=new HashMap<>();
    Map<String, Director> directorMap=new HashMap<>();

    Map<String,String> movieDirectorPair=new HashMap<>();
    Map<String,List<String>> directorMovieList=new HashMap<>();

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
    }

    public void addDirector(Director director)
    {
        directorMap.put(director.getName(),director);
        directorMovieList.put(director.getName(),new ArrayList<>());
    }

    public void addMovieDirectorPair(String movie,  String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director))
        {
            movieDirectorPair.put(movie,director);
            directorMovieList.get(director).add(movie);
        }
    }

    public Movie getMovieByName(String name){
        return movieMap.get(name);
    }

    public Director getDirectorByName( String name){
        return directorMap.get(name);
    }

    public List<String> getMoviesByDirectorName(String name){
        return directorMovieList.get(name);
    }

    public List<String> findAllMovies()
    {
        List<String > allmovies=new ArrayList<>();

        for(String str : movieMap.keySet())
        {
            allmovies.add(str);
        }

        return allmovies;
    }

    public void deleteDirectorByName(String name)
    {
        for(String movie : movieDirectorPair.keySet())
        {
            if(movieDirectorPair.get(movie).equals(name))
            {
                movieDirectorPair.remove(movie);
                movieMap.remove(movie);
            }
        }

        directorMap.remove(name);
        directorMovieList.remove(name);
    }

    public void deleteAllDirectors(){

        for(String name : directorMap.keySet()){
            deleteDirectorByName(name);
        }
    }
}
