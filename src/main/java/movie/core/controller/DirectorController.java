package movie.core.controller;

import lombok.RequiredArgsConstructor;
import movie.core.dto.directorDto.DirectorRequestDto;
import movie.core.dto.directorDto.DirectorResponseDto;
import movie.core.dto.directorMovieDto.SetMovieToDirectorDto;
import movie.core.model.Movie;
import movie.core.service.DirectorService;
import movie.core.service.MovieDirectorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/director")
public class DirectorController {

    private final DirectorService service;
   private final MovieDirectorService movieDirectorService;

    @PostMapping("/add")
    public DirectorResponseDto saveDirector(@RequestBody DirectorRequestDto dto){
       return service.saveDirector(dto);
    }

    @PostMapping("/setMovies")
    public Set<Movie> setMovies(@RequestBody SetMovieToDirectorDto dto) {
        return movieDirectorService.setDirector(dto.getDirectorId(), dto.getMoviesId());
    }
}
