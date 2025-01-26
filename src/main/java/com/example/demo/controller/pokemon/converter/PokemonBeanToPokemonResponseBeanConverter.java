package com.example.demo.controller.pokemon.converter;

import com.example.demo.controller.pokemon.bean.PokemonResponseBean;
import com.example.demo.service.pokemon.PokemonBean;
import org.springframework.stereotype.Component;

@Component
public class PokemonBeanToPokemonResponseBeanConverter {

    public PokemonResponseBean convert(PokemonBean source){
        return new PokemonResponseBean(
                source.name(),
                source.description(),
                source.habitat(),
                source.isLegendary()
        );
    }
}
