package repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    List<Movie> findByMovieCategory(String category);

    List<Movie> findMoviesByMovieIdIn(List<Integer> moviesIds);

    List<Movie> findMoviesByMovieNameContains(String word);

}