package movie.demo.mapper;

import movie.demo.dto.MovieRequestDto;
import movie.demo.dto.MovieResponseDto;
import movie.demo.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieResponseDto toDto(Movie movie);

    Movie toEntity(MovieRequestDto movie);

}

