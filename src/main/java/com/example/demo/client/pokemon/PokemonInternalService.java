package com.example.demo.client.pokemon;

import com.example.demo.client.pokemon.bean.PokemonSpecieResponseBean;
import com.example.demo.client.pokemon.converter.PokemonSpecieResponseBeanToPokemonBeanConverter;
import com.example.demo.exception.PokemonSpecieNotFoundException;
import com.example.demo.service.pokemon.PokemonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonInternalService {
    private final PokemonApiClient client;
    private final PokemonSpecieResponseBeanToPokemonBeanConverter toPokemonBean;

    @Autowired
    public PokemonInternalService(PokemonApiClient client, PokemonSpecieResponseBeanToPokemonBeanConverter toPokemonBean) {
        this.client = client;
        this.toPokemonBean = toPokemonBean;
    }

    public PokemonBean getPokemon(String name) {
        try {
            PokemonSpecieResponseBean response = client.getPokemonSpecie(name);
            return toPokemonBean.convert(response);
        } catch (PokemonSpecieNotFoundException ex) {
            return null;
        }
    }
}
