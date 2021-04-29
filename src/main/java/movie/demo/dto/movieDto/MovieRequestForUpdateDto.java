package movie.demo.dto.movieDto;

import lombok.Value;
import movie.demo.model.Actor;
import movie.demo.model.Director;
import movie.demo.model.Genre;
import movie.demo.model.GenreEntity;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Value
public class MovieRequestForUpdateDto {

    @NotNull
    private final int id;
    private final String title;
    private final double rate;
    private final String describe;
    private Set<Genre> genres;
    private int director_id;
    private Director director;
}
