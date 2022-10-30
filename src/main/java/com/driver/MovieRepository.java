package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {


    HashMap<String,Movie> movies=new HashMap<>();

    HashMap<String,Director> directors=new HashMap<>();

    HashMap<String,List<String>>directorMovies=new HashMap<>();



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

    void directormovie(String director,String movie){
        if(directorMovies.containsKey(director)){
            directorMovies.get(director).add(movie);
        }else{
            List<String> list = new ArrayList<>();
            list.add(movie);
            directorMovies.put(director,list);
        }
    }

    List<String> directedmovies(String director){
        if(directorMovies.containsKey(director)){
            return directorMovies.get(director);
        }else{
            return new ArrayList<String>();

        }
    }

    void deletedirectormovies(String name){
        if(directorMovies.containsKey(name)){
            for(String s:directorMovies.get(name)){
                movies.remove(s);
            }
        }
        directors.remove(name);
    }

    void deletealldirectors(){
        for(String k:directors.keySet()){
          if(directorMovies.containsKey(k)) {
              for (String v : directorMovies.get(k)) {
                  movies.remove(v);
              }
          }
            directors.remove(k);
        }

    }

}
