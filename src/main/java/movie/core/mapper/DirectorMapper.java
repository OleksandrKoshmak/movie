package movie.core.mapper;

import movie.core.dto.directorDto.DirectorRequestDto;
import movie.core.dto.directorDto.DirectorResponseDto;
import movie.core.model.Director;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DirectorMapper {

    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    DirectorResponseDto toDto(Director director);

    Director toEntity(DirectorRequestDto dto);
}
