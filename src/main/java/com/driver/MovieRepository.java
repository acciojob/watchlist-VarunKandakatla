package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
@Repository
public class MovieRepository {
    LinkedHashSet<Movie> watchList;
    HashMap<Director, List<Movie>> directorWork;
    HashMap<String, String> pair;

   public MovieRepository() {
      this.watchList = new LinkedHashSet<>();
      this.directorWork = new HashMap<>();
      this.pair = new HashMap<>();
   }
}
