package movie.core.dto.directorMovieDto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class SetMovieToDirectorDto {
    private final long directorId;
    private final List<Long> moviesId;
}
