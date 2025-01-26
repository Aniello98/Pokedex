package com.example.demo.controller.pokemon.bean;

public class PokemonResponseBean {
    private final String name;
    private final String description;
    private final String habitat;
    private final boolean isLegendary;


    public PokemonResponseBean(String name, String description, String habitat, boolean isLegendary) {
        this.name = name;
        this.description = description;
        this.habitat = habitat;
        this.isLegendary = isLegendary;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getHabitat() {
        return habitat;
    }

    public boolean getIsLegendary() {
        return isLegendary;
    }
}
