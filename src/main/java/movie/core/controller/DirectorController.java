package movie.core.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import movie.core.dto.directorDto.DirectorRequestDto;
import movie.core.dto.directorDto.DirectorResponseDto;
import movie.core.service.DirectorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/director")
public class DirectorController {

    private final DirectorService service;

    @PostMapping("/add")
    public DirectorResponseDto saveDirector(@RequestBody DirectorRequestDto dto){
       return service.saveDirector(dto);
    }
}
