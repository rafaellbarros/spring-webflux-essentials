package academy.devdojo.webflux.repository;

import academy.devdojo.webflux.domain.Anime;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * created by:
 *
 * @author rafael for DevDusCorre on 28/12/2021
 */
public interface AnimeRepository  extends ReactiveCrudRepository<Anime, Integer> {
}
