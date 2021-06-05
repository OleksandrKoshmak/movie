package movie.core.dto.actorDto;

import lombok.Value;
import movie.core.model.Movie;

import java.util.Set;

@Value
public class ActorResponseDto {
    private final long id;
    private final String name;
    private final int rate;
    private final Set<Movie> movies;
}
