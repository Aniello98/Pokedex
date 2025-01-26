package com.example.demo.client.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonHabitatResponseBean {
    @JsonProperty("name")
    private final String name;

    public PokemonHabitatResponseBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
