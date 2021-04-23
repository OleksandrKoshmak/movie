package movie.demo.repository;

import movie.demo.model.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Integer> {


}
