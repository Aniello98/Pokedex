package com.example.demo.client;

import com.example.demo.client.bean.PokemonSpecieResponseBean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PokeapiClient {
    private final WebClient webClient;

    public PokeapiClient() {
        this.webClient = WebClient.create("https://pokeapi.co/api/v2/");
    }

    public PokemonSpecieResponseBean getPokemonSpecie(String name){
        return webClient.get().uri("pokemon-species/" + name).retrieve().bodyToMono(PokemonSpecieResponseBean.class).block();
    }
}
