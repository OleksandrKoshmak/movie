package movie.demo.service;

import lombok.RequiredArgsConstructor;
import movie.demo.dto.MovieRequestDto;
import movie.demo.dto.MovieResponseDto;
import movie.demo.mapper.MovieMapper;
import movie.demo.model.Movie;
import movie.demo.repository.MovieRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final MovieMapper mapper = Mappers.getMapper(MovieMapper.class);


    public MovieResponseDto saveMovie(MovieRequestDto dto) {
        Movie entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    public MovieResponseDto getMovieById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }


}
