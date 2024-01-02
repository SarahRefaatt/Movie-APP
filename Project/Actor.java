package Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Actor {
    @Id
    @GeneratedValue
//    @SequenceGenerator(name = "actorId")
    private Integer actorId;
    private String actorName;
    private String actorImageUrl;

    private String age;

    private String height;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "acted_in",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> actorMovies;

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorImageUrl() {
        return actorImageUrl;
    }

    public void setActorImageUrl(String actorImageUrl) {
        this.actorImageUrl = actorImageUrl;
    }

    public List<Movie> getActorMovies() {
        return actorMovies;
    }

    public void setActorMovies(List<Movie> actorMovies) {
        this.actorMovies = actorMovies;
    }
}
