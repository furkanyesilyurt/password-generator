package com.fyesilyurt.passwordgenerator.constant;

public enum AllCharacters {

    upperCase("QWERTYUIOPĞÜASDFGHJKLŞİZXCVBNMÖÇ"),
    lowerCase("qwertyuıopğüasdfghjklşizxcvbnmöç"),
    digits("1234567890"),
    punctuation(" !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");

    private final String text;

    AllCharacters(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
