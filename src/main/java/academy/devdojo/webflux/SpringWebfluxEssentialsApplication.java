package academy.devdojo.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class SpringWebfluxEssentialsApplication {

	/*
	static {
		BlockHound.install();
	} */

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxEssentialsApplication.class, args);
	}

	@Bean
	public WebProperties.Resources getResoucers() {
		return new WebProperties.Resources();
	}

}
