package movie.core.controller;

import lombok.RequiredArgsConstructor;
import movie.core.dto.directorDto.DirectorRequestDto;
import movie.core.dto.directorDto.DirectorResponseDto;
import movie.core.dto.directorMovieDto.SetMovieToDirectorDto;
import movie.core.service.DirectorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/director")
public class DirectorController {

    private final DirectorService directorService;

    @PostMapping("/add")
    public DirectorResponseDto saveDirector(@RequestBody DirectorRequestDto dto) {
        return directorService.saveDirector(dto);
    }

    @GetMapping("/get")
    public DirectorResponseDto getDirector(@RequestParam("id") Long directorId) {
        return directorService.getDirectorById(directorId);
    }

    @PostMapping("/setMovies")
    public DirectorResponseDto setMovies(@RequestBody SetMovieToDirectorDto dto) {
        return directorService.setMovies(dto.getDirectorId(), dto.getMoviesId());
    }
}
