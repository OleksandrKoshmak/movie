package movie.core.mapper;

import movie.core.dto.actorDto.ActorRequestDto;
import movie.core.dto.movieDto.MovieResponseDto;
import movie.core.model.Actor;
import movie.core.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorMapper {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    MovieResponseDto toDto(Actor actor);

    Movie toEntity(ActorRequestDto dto);



}
