package repositories;

import org.springframework.data.jpa.repository.JpaRepository;



import Entity.Actor;
public interface ActorRepository extends JpaRepository<Actor,Integer> {


}