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

import Entity.AppUser;
import Entity.Movie;
import services.AppUserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/Users")
public class AppUserController {
    @Autowired
    AppUserService appUserService;


    @GetMapping("/allusers")
    public List<AppUser> returnUsers(){

        return appUserService.returnUsers();
    }

//    @CrossOrigin
    @PostMapping("/register")
    public void addUser(@RequestBody AppUser user){
        appUserService.addUser(user);
    }

//    @PostMapping("/register")
//    public void register(@RequestParam("username") String username,
//                         @RequestParam("email") String email,
//                         @RequestParam("password") String password ){
//        appUserService.register(username,email,password);
//    }

//    @CrossOrigin
    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable int id){
        appUserService.deleteUser(id);

    }

//    @CrossOrigin
    @PostMapping("/login")
    public AppUser login(@RequestBody AppUser user) {
        return appUserService.login(user);
    }

    @CrossOrigin
    @GetMapping("/getfavourites/{userId}")
    public List<Movie> getFavourites(@PathVariable Integer userId){

        return appUserService.getFavourites(userId);

    }

    @CrossOrigin
    @PostMapping("addtofavourites/{userId}/{movieId}")
    public void addToFavourites(@PathVariable("userId") Integer userId,@PathVariable("movieId") Integer movieId) {
        appUserService.addToFavourites(userId, movieId);

    }
    @CrossOrigin
    @DeleteMapping("/removefavourite/{userId}/{movieId}")
    public void removeFavourites(@PathVariable Integer userId,@PathVariable Integer movieId) {
        appUserService.removeFavourites(userId,movieId);
    }
    }