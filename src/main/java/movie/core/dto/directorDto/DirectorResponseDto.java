package movie.core.dto.directorDto;

import lombok.AllArgsConstructor;
import lombok.Value;
import movie.core.model.Movie;

import java.util.Set;

@Value
@AllArgsConstructor
public class DirectorResponseDto {
    private static String MSG = "successful saved";
    private Long id;
    private String name;
    private int rate;
    private Set<Movie> movies;
}
