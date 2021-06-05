package movie.core.controller;

import lombok.AllArgsConstructor;
import movie.core.dto.actorDto.ActorRequestDto;
import movie.core.dto.actorDto.ActorResponseDto;
import movie.core.model.Actor;
import movie.core.service.ActorService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    @PostMapping("/add")
    public ActorResponseDto addActor(@Param("name") String name, @Param("rate") int rate) {
        ActorRequestDto dto = new ActorRequestDto(name, rate);
        return actorService.saveActor(dto);
    }

    @GetMapping("/getAll")
    public Set<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/getActor")
    public ActorResponseDto getActorById(@Param("id") Long id) {
        return actorService.getActorById(id);
    }
}
