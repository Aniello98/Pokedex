package com.example.demo.client.pokemon.converter;

import com.example.demo.client.pokemon.bean.PokemonSpecieResponseBean;
import com.example.demo.service.pokemon.bean.PokemonBean;
import org.springframework.stereotype.Component;

@Component
public class PokemonSpecieResponseBeanToPokemonBeanConverter {

    public PokemonBean convert(PokemonSpecieResponseBean source){
        return new PokemonBean(
                source.getName(),
                source.getFlavorTextEntries().get(0).getFlavorText(),
                source.getHabitat().getName(),
                source.isLegendary()
        );
    }
}
