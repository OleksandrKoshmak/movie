package movie.core.service;

import lombok.RequiredArgsConstructor;
import movie.core.dto.directorDto.DirectorRequestDto;
import movie.core.dto.directorDto.DirectorResponseDto;
import movie.core.mapper.DirectorMapper;
import movie.core.model.Director;
import movie.core.model.Movie;
import movie.core.repository.DirectorRepository;
import movie.core.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private static final String NOT_FOUND_DIRECTOR = "Can't find director by id ";
    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;
    DirectorMapper directorMapper = DirectorMapper.INSTANCE;

    public DirectorResponseDto saveDirector(DirectorRequestDto dto) {
        Director director = directorMapper.toEntity(dto);
        directorRepository.save(director);
        return directorMapper.toDto(director);
    }

    public DirectorResponseDto getDirectorById(Long directorId) {
        return directorMapper.toDto(directorRepository.findById(directorId)
                .orElseThrow(() -> new NoSuchElementException((NOT_FOUND_DIRECTOR + directorId))));
    }

    public DirectorResponseDto setMovies(Long directorId, List<Long> movies) {
        Director director = directorRepository.findById(directorId)
                .orElseThrow(() -> new NoSuchElementException((NOT_FOUND_DIRECTOR + directorId)));
        List<Movie> result = movieRepository.findDistinctByIdIn(movies);
        Set<Movie> set = new HashSet<>(result);
        director.setMovies(set);
        directorRepository.save(director);
        return directorMapper.toDto(director);

    }
}
