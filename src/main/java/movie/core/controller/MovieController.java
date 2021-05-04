package movie.core.controller;

import lombok.RequiredArgsConstructor;
import movie.core.dto.movieDto.MovieRequestDto;
import movie.core.model.Movie;
import movie.core.service.MovieService;
import movie.core.dto.movieDto.MovieRequestForUpdateDto;
import movie.core.dto.movieDto.MovieResponseDto;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @RequestMapping("/get")
    public MovieResponseDto getMovieById(@RequestParam("id") Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping("/add")
    public MovieResponseDto addMovie(@RequestBody MovieRequestDto dto) {
        return movieService.saveMovie(dto);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String editMovie(@RequestBody MovieRequestForUpdateDto dto) {
        return movieService.updateMovie(dto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean deleteMovie(@Param("id") Long id) {
        return movieService.deleteMovie(id);
    }

    @RequestMapping("/getAll")
    public List<Movie> getAllMovies() {
      return movieService.getAllMovies();
    }

}
