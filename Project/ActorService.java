package services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Actor;
import Entity.Movie;
import repositories.ActorRepository;
import repositories.MovieRepository;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addActor(Actor actor){
        List<Integer> moviesIds = actor.getActorMovies().stream().map(Movie::getMovieId).collect(Collectors.toList());
        List<Movie> movies = movieRepository.findMoviesByMovieIdIn(moviesIds);
        actor.setActorMovies(movies);
        actorRepository.save(actor);
    }

    public void addActors(List<Actor> actors){
        for(Actor actor : actors){
            addActor(actor);
        }

    }

    public Actor getActor(int id){
        return actorRepository.findById(id).get();

    }

    public List<Actor> getActors(){
        return actorRepository.findAll();

    }

    public void deleteActor(int id){
         actorRepository.deleteById(id);

    }



}
