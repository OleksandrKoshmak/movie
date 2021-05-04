package movie.core.dto.movieDto;

import lombok.Data;
import lombok.Value;
import movie.core.model.Director;
import movie.core.model.Genre;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Value
public class MovieRequestForUpdateDto {
    @NotNull
    private final long id;
    private final String title;
    private final double rate;
    private final String describe;
    private Set<Genre> genres;
    private final int director_id;
    private Director director;
}
