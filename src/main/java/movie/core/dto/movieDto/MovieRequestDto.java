package movie.core.dto.movieDto;

import lombok.Value;
import movie.core.model.Director;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    private final String describe;

}
