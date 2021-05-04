package movie.demo.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import movie.demo.dto.movieDto.MovieRequestDto;
import movie.demo.dto.movieDto.MovieRequestForUpdateDto;
import movie.demo.dto.movieDto.MovieResponseDto;
import movie.demo.model.Movie;
import movie.demo.service.MovieService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String editMovie(@RequestBody MovieRequestForUpdateDto dto) {
        return movieService.updateMovie(dto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean deleteMovie(@Param("id") Integer id) {
        return movieService.deleteMovie(id);
    }

    @RequestMapping("/getAll")
    public List<Movie> getAllMovies() {
      return movieService.getAllMovies();
    }

}
