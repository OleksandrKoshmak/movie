package movie.core.dto.movieDto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class MovieResponseDto {
    private Integer id;
    private String title;
    private double rate;
}
