package movie.demo.controller;

import lombok.RequiredArgsConstructor;
import movie.demo.dto.MovieRequestDto;
import movie.demo.dto.MovieResponseDto;
import movie.demo.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @RequestMapping("/get")
    public MovieResponseDto getMovieById(@RequestParam("id") int id) {
        return movieService.getMovieById(id);
    }

    @PostMapping("/add")
    public MovieResponseDto addMovie(@RequestBody MovieRequestDto dto) {
        return movieService.saveMovie(dto);

    }

}
