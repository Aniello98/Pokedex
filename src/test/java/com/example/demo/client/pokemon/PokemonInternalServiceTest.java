package com.example.demo.client.pokemon;

import com.example.demo.client.pokemon.bean.PokemonFlavorTextEntryResponseBean;
import com.example.demo.client.pokemon.bean.PokemonHabitatResponseBean;
import com.example.demo.client.pokemon.bean.PokemonSpecieResponseBean;
import com.example.demo.client.pokemon.converter.PokemonSpecieResponseBeanToPokemonBeanConverter;
import com.example.demo.exception.PokemonSpecieNotFoundException;
import com.example.demo.service.pokemon.PokemonBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class PokemonInternalServiceTest {
    @InjectMocks
    private PokemonInternalService sut;
    @Mock
    private PokemonApiClient pokemonApiClient;
    @Spy
    private PokemonSpecieResponseBeanToPokemonBeanConverter converter;

    @Test
    void should_getPokemon(){
        // given
        String name = "test_name";
        PokemonSpecieResponseBean response = new PokemonSpecieResponseBean(
                "name",
                new PokemonHabitatResponseBean("habitatName"),
                true,
                List.of(new PokemonFlavorTextEntryResponseBean("description"))
        );

        when(pokemonApiClient.getPokemonSpecie(name)).thenReturn(response);
        //when
        PokemonBean result = sut.getPokemon(name);
        //then
        assertEquals(result.name(), response.getName());
        assertEquals(result.habitat(), response.getHabitat().getName());
        assertEquals(result.description(), response.getFlavorTextEntries().get(0).getFlavorText());
        assertEquals(result.isLegendary(), response.isLegendary());
    }

    @Test
    void should_returnNull_whenNoPokemonSpecie(){
        // given
        String name = "test_name";
        when(pokemonApiClient.getPokemonSpecie(name)).thenThrow(PokemonSpecieNotFoundException.class);
        //when
        PokemonBean result = sut.getPokemon(name);
        //then
        assertNull(result);
    }

}