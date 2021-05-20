package movie.core.repository;

import movie.core.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    void deleteMovieById(Long id);

    List<Movie> findDistinctByIdIn (List<Long> listId);
}
