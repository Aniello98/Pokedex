package com.example.demo.enums;

public enum FuntranslationsLanguageEnum {
    YODA("yoda"),
    SHAKESPEARE("shakespeare");
    private final String language;

    FuntranslationsLanguageEnum(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
