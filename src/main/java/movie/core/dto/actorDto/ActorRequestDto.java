package movie.core.dto.actorDto;

import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class ActorRequestDto {
    @NotNull @NotEmpty
    private final String name;
    private final int rate;
}

