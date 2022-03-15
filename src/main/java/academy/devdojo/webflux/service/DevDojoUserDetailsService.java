package academy.devdojo.webflux.service;

import academy.devdojo.webflux.repository.DevDojoUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 15/03/2022
 */

@Service
@RequiredArgsConstructor
public class DevDojoUserDetailsService implements ReactiveUserDetailsService {

    private final DevDojoUserRepository devDojoUserRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return devDojoUserRepository.findByUsername(username)
                .cast(UserDetails.class);
    }
}
