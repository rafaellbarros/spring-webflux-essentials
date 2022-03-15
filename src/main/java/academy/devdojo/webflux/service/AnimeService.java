package academy.devdojo.webflux.service;

import academy.devdojo.webflux.domain.Anime;
import academy.devdojo.webflux.repository.AnimeRepository;
import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
                .switchIfEmpty(this.monoResponseStatusNotFoundException())
                .log("findById()");
    }

    public <T> Mono<T> monoResponseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found"));
    }

    public Mono<Anime> save(final Anime anime) {
        return animeRepository.save(anime)
                .log("save()");
    }

    @Transactional
    public Flux<Anime> saveAll(final List<Anime> animes) {
        return animeRepository.saveAll(animes)
                .doOnNext(this::throwResponseStatusExceptionWhenEmptyName);
    }

    private void throwResponseStatusExceptionWhenEmptyName(final Anime anime) {
        if (StringUtil.isNullOrEmpty(anime.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid_name");
        }
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
                .log("delete()");
    }
}
