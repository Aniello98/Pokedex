package com.example.demo.client.pokemon.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonSpecieResponseBean {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("habitat")
    private final PokemonHabitatResponseBean habitat;
    @JsonProperty("is_legendary")
    private final boolean isLegendary;
    @JsonProperty("flavor_text_entries")
    private final List<PokemonFlavorTextEntryResponseBean> flavorTextEntries;

    public PokemonSpecieResponseBean(String name, PokemonHabitatResponseBean habitat, boolean isLegendary, List<PokemonFlavorTextEntryResponseBean> flavorTextEntries) {
        this.name = name;
        this.habitat = habitat;
        this.isLegendary = isLegendary;
        this.flavorTextEntries = flavorTextEntries;
    }

    public PokemonHabitatResponseBean getHabitat() {
        return habitat;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public List<PokemonFlavorTextEntryResponseBean> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public String getName() {
        return name;
    }

}
