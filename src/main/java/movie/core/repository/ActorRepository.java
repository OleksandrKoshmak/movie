package movie.core.repository;

import movie.core.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
