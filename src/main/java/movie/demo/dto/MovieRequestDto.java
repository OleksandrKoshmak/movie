package movie.demo.dto;

import lombok.Value;
import movie.demo.model.Director;
import movie.demo.model.GenreEntity;

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
    private final String describe;

}
