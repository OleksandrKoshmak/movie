package movie.core.dto.directorDto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class DirectorRequestDto {
    private final String name;
    private final int personalRating;
}

