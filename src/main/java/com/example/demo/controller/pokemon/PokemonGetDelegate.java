package com.example.demo.controller.pokemon;

import com.example.demo.controller.pokemon.bean.PokemonResponseBean;
import com.example.demo.controller.pokemon.converter.PokemonBeanToPokemonResponseBeanConverter;
import com.example.demo.exception.InvalidInputException;
import com.example.demo.exception.PokemonNotFoundException;
import com.example.demo.service.pokemon.PokemonService;
import com.example.demo.service.pokemon.bean.PokemonBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PokemonGetDelegate {
    private final static Logger logger = LoggerFactory.getLogger(PokemonGetDelegate.class);
    private final PokemonService pokemonService;
    private final PokemonBeanToPokemonResponseBeanConverter toResponseBean;

    @Autowired
    public PokemonGetDelegate(PokemonService pokemonService, PokemonBeanToPokemonResponseBeanConverter toResponseBean) {
        this.pokemonService = pokemonService;
        this.toResponseBean = toResponseBean;
    }

    public PokemonResponseBean getPokemon(String name) {
        return fetchPokemon(name, pokemonService::getPokemon);
    }

    public PokemonResponseBean getTranslatedPokemon(String name) {
        return fetchPokemon(name, pokemonService::getTranslatedPokemon);
    }

    private PokemonResponseBean fetchPokemon(String name, Function<String, PokemonBean> serviceCall) {
        try {
            PokemonBean result = serviceCall.apply(name);
            return toResponseBean.convert(result);
        } catch (InvalidInputException ex) {
            logger.error("invalid input on getPokemon: {} ", name, ex);
            throw ex;
        } catch (PokemonNotFoundException ex) {
            logger.error("pokemon with name {} not found ", name, ex);
            throw ex;
        } catch (Exception ex) {
            logger.error("generic error while getting pokemon ", ex);
            throw ex;
        }
    }
}
