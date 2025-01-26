package com.example.demo.client.pokemon;

import com.example.demo.client.pokemon.bean.PokemonSpecieResponseBean;
import com.example.demo.client.pokemon.converter.PokemonSpecieResponseBeanToPokemonBeanConverter;
import com.example.demo.exception.PokemonSpecieNotFoundException;
import com.example.demo.service.pokemon.bean.PokemonBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonInternalService {
    private final static Logger logger = LoggerFactory.getLogger(PokemonInternalService.class);
    private final PokemonApiClient client;
    private final PokemonSpecieResponseBeanToPokemonBeanConverter toPokemonBean;

    @Autowired
    public PokemonInternalService(PokemonApiClient client, PokemonSpecieResponseBeanToPokemonBeanConverter toPokemonBean) {
        this.client = client;
        this.toPokemonBean = toPokemonBean;
    }

    public PokemonBean getPokemon(String name) {
        try {
            logger.info("retrieving pokemon specie of {} ", name);
            PokemonSpecieResponseBean response = client.getPokemonSpecie(name);
            return toPokemonBean.convert(response);
        } catch (PokemonSpecieNotFoundException ex) {
            return null;
        }
    }
}
