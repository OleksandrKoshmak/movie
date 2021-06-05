package movie.core.service;

import lombok.RequiredArgsConstructor;
import movie.core.dto.actorDto.ActorRequestDto;
import movie.core.dto.actorDto.ActorResponseDto;
import movie.core.exception.EmptyFieldException;
import movie.core.mapper.ActorMapper;
import movie.core.model.Actor;
import movie.core.model.Movie;
import movie.core.repository.ActorRepository;
import movie.core.repository.MovieRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper = ActorMapper.INSTANCE;
    private final MovieRepository movieRepository;


    public ActorResponseDto saveActor(ActorRequestDto actorRequestDto) {
        if (actorRequestDto.getName().equals("")) {
            throw new EmptyFieldException();
        }
        Actor actor = actorMapper.toEntity(actorRequestDto);
        actorRepository.save(actor);
        return actorMapper.toDto(actor);
    }

    public Set<Actor> getAllActors() {
        return (Set<Actor>) actorRepository.findAll();
    }

    public ActorResponseDto getActorById(Long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return actorMapper.toDto(actor);
    }

    public ActorResponseDto setMoviesToActor(Long actorId, List<Long> moviesId) {
        Actor actor = actorRepository.findById(actorId)
                .orElseThrow(EntityNotFoundException::new);
        Set<Movie> movies = new HashSet<>(movieRepository
                .findDistinctByIdIn(moviesId));
        actor.getMovies().addAll(movies);
        return actorMapper.toDto(actor);
    }

}
