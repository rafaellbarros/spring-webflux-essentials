package academy.devdojo.webflux.service;

import academy.devdojo.webflux.domain.Anime;
import academy.devdojo.webflux.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * created by:
 *
 * @author rafael for DevDusCorre on 28/12/2021
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AnimeService {

    private final AnimeRepository animeRepository;


    public Flux<Anime> listAll() {
        log.info("AnimeService::listAll");
        return animeRepository.findAll();
    }
}
