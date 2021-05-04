package movie.core.dto.movieDto;

import lombok.Data;
import lombok.Value;
import movie.core.model.Director;
import movie.core.model.GenreEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Value
public class MovieRequestDto {
    @NotNull
    private final int id;
    @NotNull
    @Min(1)
    @Max(50)
    private final String title;
    private final double rate;
    private final Director director;
    private Set<GenreEntity> genre;
    private final String describe;

}
