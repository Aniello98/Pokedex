package com.example.demo.client.pokemon;

import com.example.demo.client.pokemon.bean.PokemonSpecieResponseBean;
import com.example.demo.exception.PokemonSpecieNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PokemonApiClient {
    private final WebClient webClient;

    public PokemonApiClient() {
        this.webClient = WebClient.create("https://pokeapi.co/api/v2/");
    }

    public PokemonSpecieResponseBean getPokemonSpecie(String name) {
        return webClient.get()
                .uri("pokemon-species/" + name)
                .retrieve()
                .onStatus(
                        status -> status.value() == 404,
                        clientResponse -> Mono.error(new PokemonSpecieNotFoundException())
                )
                .bodyToMono(PokemonSpecieResponseBean.class)
                .block()
                ;
    }
}
