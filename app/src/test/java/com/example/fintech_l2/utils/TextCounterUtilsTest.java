package com.example.fintech_l2.utils;

import com.example.fintech_l2.exception.LengthCalculationException;

import org.junit.Assert;
import org.junit.Test;

public class TextCounterUtilsTest {

    @Test (expected = LengthCalculationException.class)
    public void calculateCharsShouldFailAndThrowExceptionGivenNull() {
        // execute
        TextCounterUtils.calculateChars(null);
    }

    @Test
    public void calculateCharsShouldReturnZeroGivenEmptyString(){
        // setup
        String input = "";

        // execute
        int result = TextCounterUtils.calculateChars(input);

        // verify
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculateCharsShouldReturnLengthGivenNonEmptyString(){
        // setup
        String input = "69420";

        // execute
        int result = TextCounterUtils.calculateChars(input);

        // verify
        Assert.assertEquals(5, result);
    }

    @Test (expected = LengthCalculationException.class)
    public void calculateWordsShouldFailAndThrowExceptionGivenNull(){
        // execute
        TextCounterUtils.calculateWords(null);
    }

    @Test
    public void calculateWordsShouldReturnZeroGivenEmptyString(){
        // setup
        String input = "";

        // execute
        int result = TextCounterUtils.calculateWords(input);

        // verify
        Assert.assertEquals(0, result);
    }


    @Test
    public void calculateWordsShouldReturnWordsCountGivenNonEmptyString(){
        // setup
        String input = "hello this is a test";

        // execute
        int result = TextCounterUtils.calculateWords(input);

        // verify
        Assert.assertEquals(5, result);
    }

    @Test
    public void calculateWordsShouldReturnZeroGivenStringIsOnlyWhitespaces(){
        // setup
        String input = " \n \t \r \b \f     ";

        // execute
        int result = TextCounterUtils.calculateWords(input);

        // verify
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculateWordsShouldReturnWordCountGivenStringIsWithWhitespaces(){
        // setup
        String input = "\n  this is  \t  full  \r off \f  trash   unlucky   ";

        // execute
        int result = TextCounterUtils.calculateWords(input);

        // verify
        Assert.assertEquals(6, result);
    }
}