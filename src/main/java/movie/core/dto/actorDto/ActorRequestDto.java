package movie.core.dto.actorDto;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class ActorRequestDto {
    @NotBlank
    private final String name;
    private final int rate;

}
