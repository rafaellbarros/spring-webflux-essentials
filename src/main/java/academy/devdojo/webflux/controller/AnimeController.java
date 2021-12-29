package academy.devdojo.webflux.controller;

import academy.devdojo.webflux.domain.Anime;
import academy.devdojo.webflux.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * created by:
 *
 * @author rafael for DevDusCorre on 28/12/2021
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("animes")
public class AnimeController {

    private final AnimeService animeService;

    @GetMapping
    public Flux<Anime> listAll() {
        return animeService.listAll();
    }

    @GetMapping(path = "{id}")
    public Mono<Anime> findById(@PathVariable final int id) {
        return animeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Anime> save(@Valid @RequestBody Anime anime){
        return animeService.save(anime);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<Anime> update(@Valid @RequestBody Anime anime){
        return animeService.update(anime);
    }
}
