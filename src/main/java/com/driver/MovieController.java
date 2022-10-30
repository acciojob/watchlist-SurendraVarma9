package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    ResponseEntity<String> addMovie(@RequestBody()Movie movie){
          movieService.addmovie(movie);
          return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    ResponseEntity<String> addDirector(@RequestBody()Director director){
        movieService.adddirector(director);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

//    @PutMapping("/movies/add-movie-director-pair")
//    ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie name")String movie_name,@RequestParam("director name")String director_name){
//
//        return new ResponseEntity<>("success",HttpStatus.OK);
//    }
//
    @GetMapping("/movies/get-movie-by-name/{name}")
    ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){

        return new ResponseEntity<>(movieService.getmovie(name),HttpStatus.OK);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name){

        return new ResponseEntity<>(movieService.getdirector(name),HttpStatus.OK);
    }
//
//    @GetMapping("/movies/get-movies-by-director-name/{director}")
//    ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director")String director){
//
//        return new ResponseEntity<>();
//    }
//
    @GetMapping("/movies/get-all-movies")
    ResponseEntity<List<String>> findAllMovies(){

        return new ResponseEntity<>(movieService.getAllmovies(),HttpStatus.OK);
    }
//
//    @DeleteMapping("/movies/delete-director-by-name")
//    ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
//
//        return new ResponseEntity<>("success",HttpStatus.OK);
//    }
//
//    @DeleteMapping("/movies/delete-all-directors")
//    ResponseEntity<String> deleteAllDirectors(){
//
//        return new ResponseEntity<>("success",HttpStatus.OK);
//    }





}
