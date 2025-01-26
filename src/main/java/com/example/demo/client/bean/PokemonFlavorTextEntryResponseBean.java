package com.example.demo.client.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonFlavorTextEntryResponseBean {
    @JsonProperty("flavor_text")
    private final String flavorText;

    public PokemonFlavorTextEntryResponseBean(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getFlavorText() {
        return flavorText;
    }
}
