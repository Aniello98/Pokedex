package com.example.demo.service.pokemon;

import com.example.demo.client.funtranslations.FuntranslationsInternalService;
import com.example.demo.enums.FuntranslationsLanguageEnum;
import com.example.demo.service.pokemon.bean.PokemonBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonTranslateServiceTest {
    @InjectMocks
    private PokemonTranslateService sut;
    @Mock
    private FuntranslationsInternalService funtranslationsInternalService;

    @Test
    void should_returnTranslatedYodaDescriptionPokemon_when_isLegendary(){
        //given
        PokemonBean pokemon = new PokemonBean("name", "description", "habitat", true);
        String translatedDescription = "Yoda Description";
        when(funtranslationsInternalService.getTranslation(any(), eq(FuntranslationsLanguageEnum.YODA))).thenReturn(translatedDescription);

        //when
        PokemonBean result = sut.getTranslatedPokemon(pokemon);

        //then
        assertEquals(result.description(), translatedDescription);
    }

    @Test
    void should_returnTranslatedYodaDescriptionPokemon_when_isCaveHabitant(){
        //given
        PokemonBean pokemon = new PokemonBean("name", "description", "cave", false);
        String translatedDescription = "Yoda Description";
        when(funtranslationsInternalService.getTranslation(any(), eq(FuntranslationsLanguageEnum.YODA))).thenReturn(translatedDescription);

        //when
        PokemonBean result = sut.getTranslatedPokemon(pokemon);

        //then
        assertEquals(result.description(), translatedDescription);
    }

    @Test
    void should_returnTranslatedShakespearDescriptionPokemon_when_isNotLegendaryOrCaveHabitant(){
        //given
        PokemonBean pokemon = new PokemonBean("name", "description", "no cave", false);
        String translatedDescription = "Shakespeare Description";
        when(funtranslationsInternalService.getTranslation(any(), eq(FuntranslationsLanguageEnum.SHAKESPEARE))).thenReturn(translatedDescription);

        //when
        PokemonBean result = sut.getTranslatedPokemon(pokemon);

        //then
        assertEquals(result.description(), translatedDescription);
    }

    @Test
    void should_returnInput_when_translationNull(){
        //given
        PokemonBean pokemon = new PokemonBean("name", "description", "habitat", true);
        when(funtranslationsInternalService.getTranslation(any(),any())).thenReturn(null);

        //when
        PokemonBean result = sut.getTranslatedPokemon(pokemon);

        //then
        assertEquals(result, pokemon);
    }

    @Test
    void should_returnInput_when_noDescription(){
        //given
        PokemonBean pokemon = new PokemonBean("name", null, "habita", true);
        //when
        PokemonBean result = sut.getTranslatedPokemon(pokemon);
        //then
        assertEquals(result, pokemon);
    }

}