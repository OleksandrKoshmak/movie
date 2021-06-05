package movie.core.mapper;

import movie.core.dto.actorDto.ActorRequestDto;
import movie.core.dto.actorDto.ActorResponseDto;
import movie.core.model.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorMapper {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    ActorResponseDto toDto(Actor actor);

    Actor toEntity(ActorRequestDto dto);


}
