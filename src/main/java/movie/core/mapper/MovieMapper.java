package movie.core.mapper;

import movie.core.dto.movieDto.MovieRequestDto;
import movie.core.dto.movieDto.MovieResponseDto;
import movie.core.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieResponseDto toDto(Movie movie);

    Movie toEntity(MovieRequestDto dto);

}
