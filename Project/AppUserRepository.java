package repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);

//    List<Movie> findUserFavourites(Integer Id);


    //AppUser findByUsername(String username);
}