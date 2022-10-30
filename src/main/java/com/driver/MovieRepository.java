package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {


    HashMap<String,Movie> movies=new HashMap<>();

    HashMap<String,Director> directors=new HashMap<>();



    void addtomovies(Movie movie){
        movies.put(movie.getName(),movie);
    }

    void addtodirectors(Director director){
        directors.put(director.getName(),director);
    }

    Movie getfrommovies(String name){
        return movies.get(name);
    }

    Director getfromdirectors(String name){
        return directors.get(name);
    }

    List<String> getmovielist(){
        List<String> movielist=new ArrayList<>();

        for(Movie m:movies.values()){
            movielist.add(m.getName());
        }
        return movielist;
    }

}
