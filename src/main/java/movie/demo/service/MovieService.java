package movie.demo.service;

import lombok.RequiredArgsConstructor;
import movie.demo.dto.movieDto.MovieRequestDto;
import movie.demo.dto.movieDto.MovieRequestForUpdateDto;
import movie.demo.dto.movieDto.MovieResponseDto;
import movie.demo.mapper.MovieMapper;
import movie.demo.model.Movie;
import movie.demo.repository.MovieRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

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

    public String updateMovie (MovieRequestForUpdateDto dto){
        Movie movie = repository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        movie.setTitle(dto.getTitle());
        movie.setRate(dto.getRate());
        movie.setDescribe(dto.getDescribe());
        repository.save(movie);
        return String.format("%s was successful changed", dto.getTitle());
    }

    @Transactional
    public boolean deleteMovie (Integer id){
        repository.deleteMovieById(id);
        return true;
    }

}
