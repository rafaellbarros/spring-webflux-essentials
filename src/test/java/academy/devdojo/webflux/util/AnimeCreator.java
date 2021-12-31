package academy.devdojo.webflux.util;

import academy.devdojo.webflux.domain.Anime;

/**
 * created by:
 *
 * @author rafael for DevDusCorre on 31/12/2021
 */
public class AnimeCreator {

    public static Anime createAnimeToBeSaved() {
        return Anime.builder()
                .name("Tensei Shitara Slime Datta Ken")
                .build();
    }

    public static Anime createValidAnime() {
        return Anime.builder()
                .id(1)
                .name("Tensei Shitara Slime Datta Ken")
                .build();
    }

    public static Anime createValidUpdatedAnime() {
        return Anime.builder()
                .id(1)
                .name("Tensei Shitara Slime Datta Ken Updated")
                .build();
    }
}
