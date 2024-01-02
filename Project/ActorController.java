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

import Entity.Actor;
import services.ActorService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/Actors")
public class ActorController {

    @Autowired
    ActorService actorService;

    @PostMapping("/addactor")
    public void addActor(@RequestBody Actor actor){
        actorService.addActor(actor);

    }
    @PostMapping("/addactors")
    public void addActors(@RequestBody List<Actor> actors){
        actorService.addActors(actors);

    }

@GetMapping("/getactor/{id}")
    public Actor getActor(@PathVariable int id){
        return actorService.getActor(id);

    }
    @CrossOrigin
    @GetMapping("/getactors")
    public List<Actor> getActors(){
        return actorService.getActors();

    }


    @DeleteMapping("/deleteactor/{id}")
    public void deleteActor(@PathVariable int id){
        actorService.deleteActor(id);

    }
}