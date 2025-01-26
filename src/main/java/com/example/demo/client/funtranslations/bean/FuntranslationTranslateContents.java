package com.example.demo.client.funtranslations.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FuntranslationTranslateContents {
    @JsonProperty("translated")
    private final String translated;

    public FuntranslationTranslateContents(String translated) {
        this.translated = translated;
    }

    public String getTranslated() {
        return translated;
    }
}
