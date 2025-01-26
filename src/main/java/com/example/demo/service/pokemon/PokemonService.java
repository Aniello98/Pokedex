package com.example.demo.service.pokemon;

import com.example.demo.client.pokemon.PokemonInternalService;
import com.example.demo.exception.InvalidInputException;
import com.example.demo.exception.PokemonNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PokemonService {
    private final PokemonInternalService pokemonInternalService;

    public PokemonService(PokemonInternalService pokemonInternalService) {
        this.pokemonInternalService = pokemonInternalService;
    }


    public PokemonBean getPokemonByName(String name) {
        String validName = validateAndSanitize(name);
        PokemonBean pokemon = pokemonInternalService.getPokemon(validName);
        if (pokemon == null) {
            throw new PokemonNotFoundException();
        }
        return pokemon;
    }

    String validateAndSanitize(String name) {
        String cleanedName = cleanName(name);
        if (cleanedName == null || cleanedName.isEmpty()) {
            throw new InvalidInputException();
        }
        return cleanedName;
    }

    private String cleanName(String name) {
        return StringUtils.trimAllWhitespace(name);
    }
}
