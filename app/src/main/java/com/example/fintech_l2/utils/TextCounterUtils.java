package com.example.fintech_l2.utils;

import com.example.fintech_l2.exception.LengthCalculationException;

public class TextCounterUtils {
    private TextCounterUtils(){

    }

    public static int calculateChars(String input) throws LengthCalculationException {

        try {
            return input.length();
        }
        catch (Throwable cause){
            throw new LengthCalculationException("An error occurred while trying to calculate number of chars",
                    cause);
        }

    }

    public static int calculateWords(String input) throws LengthCalculationException{
        // split by whitespace
        try {
            return input.split("\\s+").length;
        }
        catch (Throwable cause){
            throw new LengthCalculationException("An error occured while trying to calculate words count",
                    cause);
        }

    }
}
