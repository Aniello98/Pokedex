package com.example.demo.client.funtranslations.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FuntranslationTranslateResponseBean {
    @JsonProperty("contents")
    private final FuntranslationTranslateContents contents;

    public FuntranslationTranslateResponseBean(FuntranslationTranslateContents contents) {
        this.contents = contents;
    }

    public FuntranslationTranslateContents getContents() {
        return contents;
    }
}
