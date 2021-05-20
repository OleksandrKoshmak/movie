package movie.core.service;

import lombok.RequiredArgsConstructor;
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
public class MovieDirectorService {

    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;
    DirectorMapper directorMapper = DirectorMapper.INSTANCE;

    public Set<Movie> setDirector(Long directorId, List<Long> movies){
        Director director = directorRepository.findById(directorId)
                .orElseThrow(() -> new NoSuchElementException(String.format("Can't find director by id %s", directorId)));
        List<Movie> result = movieRepository.findDistinctByIdIn(movies);
        Set<Movie> set = new HashSet<>(result);
        director.setMovies(set);
        directorRepository.save(director);
        return director.getMovies();

    }
}
