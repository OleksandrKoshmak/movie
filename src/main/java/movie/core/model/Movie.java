package movie.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "movie")

public class Movie {
    @Id
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "rate")
    private double rate;

    @ManyToMany
    @JoinTable(name = "actor_movies",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    Set<Actor> actors;

    @Column(name = "describe")
    private String describe;


}
