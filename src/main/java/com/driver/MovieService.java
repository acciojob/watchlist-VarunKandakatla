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
//    @Autowired
    MovieRepository repo=new MovieRepository();

    public ResponseEntity addMovie( Movie movie){
        repo.watchList.add(movie);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

    public ResponseEntity addDirector( Director dir){
        repo.directorWork.put(dir,new ArrayList<>());
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }

    public ResponseEntity addMovieDirectorPair(String movie,  String director){
        boolean isMovie=false,isDirector=false;
        Movie obj=null;

        for(Movie m: repo.watchList){
            if(movie.equals(m.getName())){
                isMovie=true;
                obj=m;
                break;
            }
        }

        if(isMovie){
            for(Director dir: repo.directorWork.keySet()){
                if(dir.getName().equals(director)){
                    repo.pair.put(movie,director);
                    repo.directorWork.get(dir).add(obj);
                    isDirector=true;
                    break;
                }
            }
        }
        if(isDirector){
            return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
        }

        return new ResponseEntity("failure",HttpStatus.ACCEPTED);
    }

    public ResponseEntity getMovieByName(String name){

        for(Movie m : repo.watchList){
            if(name.equals(m.getName())){
                return new ResponseEntity<>(m,HttpStatus.ACCEPTED);
            }
        }

        return null;
    }

    public ResponseEntity getDirectorByName( String name){
        for(Director dir : repo.directorWork.keySet()){
            if(name.equals(dir.getName())){
                return new ResponseEntity<>(dir,HttpStatus.ACCEPTED);
            }
        }

        return null;
    }

    public ResponseEntity getMoviesByDirectorName(String name){

        for(Director d: repo.directorWork.keySet()){
            if(name.equals(d.getName())){
                return new ResponseEntity<>(repo.directorWork.get(d),HttpStatus.ACCEPTED);
            }
        }

        return null;

    }

    public ResponseEntity findAllMovies(){
        ArrayList<String> list=new ArrayList<>();

        for(Director d: repo.directorWork.keySet() ){
            for(Movie m: repo.directorWork.get(d)){
                list.add(m.getName());
            }
        }

        return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }

    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){

        for(Director d: repo.directorWork.keySet()){
            if(name.equals(d.getName())){
                repo.directorWork.remove(d);
            }
        }

        for(String n : repo.pair.keySet()){
            if(repo.pair.get(n).equals(name)){
                repo.pair.remove(n);

                for(Movie m : repo.watchList){
                    if(m.getName().equals(repo.pair.get(n))){
                        repo.watchList.remove(m);
                    }
                }
            }
        }

        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);

    }

    public ResponseEntity deleteAllDirectors(){
        repo.directorWork.clear();
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }
}
