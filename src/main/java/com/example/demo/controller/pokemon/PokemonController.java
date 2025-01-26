package com.example.demo.controller.pokemon;

import com.example.demo.controller.pokemon.bean.PokemonResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PokemonController {
    private static Logger logger = LoggerFactory.getLogger(PokemonController.class);

    private final PokemonGetDelegate getDelegate;

    @Autowired
    public PokemonController(PokemonGetDelegate getDelegate) {
        this.getDelegate = getDelegate;
    }

    @GetMapping("pokemon/{name}")
    public PokemonResponseBean getPokemon(@PathVariable("name") String name) {
        logger.info("calling get pokemon controller with param {} ", name);
        return getDelegate.getPokemon(name);
    }

    @GetMapping("pokemon/translated/{name}")
    public PokemonResponseBean getTranslatedPokemon(@PathVariable("name") String name) {
        logger.info("calling get translated pokemon controller with param {} ", name);
        return getDelegate.getTranslatedPokemon(name);
    }
}
