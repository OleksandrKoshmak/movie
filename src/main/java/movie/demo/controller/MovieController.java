package movie.demo.controller;

import lombok.RequiredArgsConstructor;
import movie.demo.dto.MovieResponseDto;
import movie.demo.service.MovieService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @RequestMapping("/get")
    public MovieResponseDto getMovieById(@Param("id") int id) {
        return movieService.getMovieById(id);
    }
}
