package com.example.fintech_l2.utils;

public class TextCounterUtils {
    private TextCounterUtils(){

    }

    public static int calculateChars(String input){
        return input.length();
    }

    public static int calculateWords(String input){
        // split by whitespace
        return input.split("\\s+").length;
    }
}
