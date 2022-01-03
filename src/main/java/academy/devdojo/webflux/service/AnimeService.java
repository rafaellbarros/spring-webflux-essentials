package academy.devdojo.webflux.service;

import academy.devdojo.webflux.domain.Anime;
import academy.devdojo.webflux.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * created by:
 *
 * @author rafael for DevDusCorre on 28/12/2021
 */
@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;


    public Flux<Anime> findAll() {
        return animeRepository.findAll()
                .log("listAll()");
    }

    public Mono<Anime> findById(final int id) {
        return animeRepository.findById(id)
                .switchIfEmpty(monoResponseStatusNotFoundException())
                .log("findById()");
    }

    public <T> Mono<T> monoResponseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found"));
    }

    public Mono<Anime> save(final Anime anime) {
        return animeRepository.save(anime)
                .log("save()");
    }

    public Mono<Anime> update(final Anime anime) {
        return findById(anime.getId())
                .map(animeFound -> anime.withId(animeFound.getId()))
                .flatMap(animeRepository::save)
                .log("update()");
    }

    public Mono<Void> delete(int id) {
        return findById(id)
                .flatMap(animeRepository::delete)
                .onErrorResume(this::monoResponseStatusNoContentException);
    }

    private Mono<Void> monoResponseStatusNoContentException(Throwable throwable) {
        return  Mono.error(new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
}
