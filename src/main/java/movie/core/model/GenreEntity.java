package movie.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@Getter
@Setter

public class GenreEntity {
    @Id
    private int id;

    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
