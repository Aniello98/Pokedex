package com.example.demo.client.funtranslations.bean;

public class FuntranslationTranslateRequestBean {
    private final String text;

    public FuntranslationTranslateRequestBean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
