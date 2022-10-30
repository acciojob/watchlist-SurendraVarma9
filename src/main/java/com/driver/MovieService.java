package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

     void addmovie(Movie movie){
         movieRepository.addtomovies(movie);
     }

     void adddirector(Director director){
         movieRepository.addtodirectors(director);
     }

     Movie getmovie(String name){
         return movieRepository.getfrommovies(name);

     }

     Director getdirector(String name){
         return movieRepository.getfromdirectors(name);
     }

     List<String> getAllmovies(){
         return movieRepository.getmovielist();
     }

     void pairdm(String director,String movie){
         movieRepository.directormovie(director,movie);
     }

     List<String> getdirectormovies(String director){
         return movieRepository.directedmovies(director);
     }

     void deletemovies(String name){
         movieRepository.deletedirectormovies(name);
     }

     void deletedirectors(){
         movieRepository.deletealldirectors();
     }

}
