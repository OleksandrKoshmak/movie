package movie.core.dto.directorDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Value
@AllArgsConstructor
public class DirectorResponseDto {
    private static String MSG = "successful saved";
    private Long id;
    private String name;
    private int personalRating;
}
