package movie.core.service;

import lombok.RequiredArgsConstructor;
import movie.core.dto.directorDto.DirectorRequestDto;
import movie.core.dto.directorDto.DirectorResponseDto;
import movie.core.mapper.DirectorMapper;
import movie.core.model.Director;
import movie.core.repository.DirectorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository repository;
    private final DirectorMapper mapper = DirectorMapper.INSTANCE;

    public DirectorResponseDto saveDirector(DirectorRequestDto dto){
        Director director = mapper.toEntity(dto);
        repository.save(director);
        return mapper.toDto(director);
    }

}
