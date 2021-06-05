package movie.core.dto.directorDto;

import lombok.Value;

@Value
public class DirectorRequestDto {
    private final String name;
    private final int rate;
}

