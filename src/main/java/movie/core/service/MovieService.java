package movie.core.service;

import lombok.RequiredArgsConstructor;
import movie.core.dto.movieDto.MovieRequestDto;
import movie.core.dto.movieDto.MovieRequestForUpdateDto;
import movie.core.dto.movieDto.MovieResponseDto;
import movie.core.mapper.MovieMapper;
import movie.core.model.Movie;
import movie.core.repository.MovieRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final MovieMapper mapper = Mappers.getMapper(MovieMapper.class);

    @Transactional
    public MovieResponseDto saveMovie(MovieRequestDto dto) {
        Movie entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public MovieResponseDto getMovieById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Transactional
    public String updateMovie(MovieRequestForUpdateDto dto) {
        Movie movie = repository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        movie.setTitle(dto.getTitle());
        movie.setRate(dto.getRate());
        movie.setDescribe(dto.getDescribe());
        repository.save(movie);
        return String.format("%s was successful changed", dto.getTitle());
    }

    @Transactional
    public boolean deleteMovie(Long id) {
        repository.deleteMovieById(id);
        return true;
    }

    @Transactional
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }


}
