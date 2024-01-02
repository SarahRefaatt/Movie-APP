package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Movie;
import services.MovieService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/Movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/addmovie")
    public void addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);

    }

    @CrossOrigin
    @GetMapping("/getmovies")
    public List<Movie> getMovies(){

        return movieService.getMovies();
    }

    @DeleteMapping("/deletemovie/{id}")
    public void deleteMovie(@PathVariable int id){
        movieService.deleteMovie(id);

    }
    @PostMapping("/addmovies")
    public void addMovies(@RequestBody List<Movie> movies){
        movieService.addMovies(movies);

    }

    @GetMapping("/findbycategory/{category}")
        public List<Movie> findByCategory(@PathVariable String category ) {

            return movieService.findByCategory(category);
        }


}