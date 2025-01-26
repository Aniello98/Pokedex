package com.example.demo.service.pokemon;

import com.example.demo.client.funtranslations.FuntranslationsInternalService;
import com.example.demo.enums.FuntranslationsLanguageEnum;
import com.example.demo.service.pokemon.bean.PokemonBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonTranslateService {
    private static final String CAVE_HABITAT = "cave";
    private final FuntranslationsInternalService funtranslationsInternalService;
    private final static Logger logger = LoggerFactory.getLogger(PokemonTranslateService.class);

    @Autowired
    public PokemonTranslateService(FuntranslationsInternalService funtranslationsInternalService) {
        this.funtranslationsInternalService = funtranslationsInternalService;
    }


    public PokemonBean getTranslatedPokemon(PokemonBean pokemon) {
        if (pokemon.description() == null) {
            return pokemon;
        }

        String translatedDescription;
        if (pokemon.isLegendary() || CAVE_HABITAT.equals(pokemon.habitat())) {
            translatedDescription = translate(pokemon.description(), FuntranslationsLanguageEnum.YODA);
        } else {
            translatedDescription = translate(pokemon.description(), FuntranslationsLanguageEnum.SHAKESPEARE);
        }

        if (translatedDescription == null) {
            logger.info("could not translate pokemon description, fallback to standard one ");
            return pokemon;
        }
        return new PokemonBean(
                pokemon.name(),
                translatedDescription,
                pokemon.habitat(),
                pokemon.isLegendary()
        );
    }

    String translate(String text, FuntranslationsLanguageEnum into) {
        return funtranslationsInternalService.getTranslation(text, into);
    }
}
