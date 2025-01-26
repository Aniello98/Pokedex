package com.example.demo.service.pokemon;

import com.example.demo.client.pokemon.PokemonInternalService;
import com.example.demo.exception.InvalidInputException;
import com.example.demo.exception.PokemonNotFoundException;
import com.example.demo.service.pokemon.bean.PokemonBean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PokemonService {
    private final PokemonInternalService pokemonInternalService;
    private final PokemonTranslateService translateService;

    public PokemonService(PokemonInternalService pokemonInternalService, PokemonTranslateService translateService) {
        this.pokemonInternalService = pokemonInternalService;
        this.translateService = translateService;
    }

    public PokemonBean getTranslatedPokemon(String name) {
        PokemonBean pokemon = getPokemon(name);
        return translateService.getTranslatedPokemon(pokemon);
    }

    public PokemonBean getPokemon(String name) {
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
