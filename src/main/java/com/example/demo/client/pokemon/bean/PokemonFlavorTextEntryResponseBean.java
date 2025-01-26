package com.example.demo.client.pokemon.bean;

import com.example.demo.utils.CleanStringDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PokemonFlavorTextEntryResponseBean {
    @JsonProperty("flavor_text")
    @JsonDeserialize(using = CleanStringDeserializer.class)
    private final String flavorText;

    public PokemonFlavorTextEntryResponseBean(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getFlavorText() {
        return flavorText;
    }
}
