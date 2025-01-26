package com.example.demo.service.pokemon;

import com.example.demo.client.pokemon.PokemonInternalService;
import com.example.demo.exception.InvalidInputException;
import com.example.demo.exception.PokemonNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {
    @InjectMocks
    private PokemonService sut;
    @Mock
    private PokemonInternalService pokemonInternalService;

    @Test
    void should_throwExceptionOnEmptyString_when_validateAndSanitize() {
        //given
        String name = null;
        //when - then
        assertThrows(InvalidInputException.class, () -> sut.validateAndSanitize(name));
    }

    @Test
    void should_throwExceptionOnNullParameter_when_validateAndSanitize() {
        //given
        String name = "  ";
        //when - then
        assertThrows(InvalidInputException.class, () -> sut.validateAndSanitize(name));
    }

    @Test
    void should_returnCleanedName_when_validateAndSanitize() {
        //given
        String name = "  cleanedName  ";
        //when
        String result = sut.validateAndSanitize(name);
        //then
        assertEquals(result, "cleanedName");
    }

    @Test
    void should_returnPokemon_when_getPokemonByName() {
        //given
        String name = "name";
        PokemonBean pokemonBean = new PokemonBean(name, "description", "habitat", true);
        when(pokemonInternalService.getPokemon(name)).thenReturn(pokemonBean);

        //when
        PokemonBean result = sut.getPokemonByName(name);
        //then
        assertEquals(result, pokemonBean);
    }

    @Test
    void should_throwExceptionOnNullResult_when_getPokemonByName() {
        //given
        String name = "name";
        when(pokemonInternalService.getPokemon(name)).thenReturn(null);

        //when - then
        assertThrows(PokemonNotFoundException.class, () -> sut.getPokemonByName(name));
    }

}