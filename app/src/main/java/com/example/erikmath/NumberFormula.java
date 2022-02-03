package com.example.erikmath;

import java.util.Random;

public class NumberFormula {

    int firstNumber;
    int secondNumber;

    public NumberFormula() {
        firstNumber =0;
        secondNumber =0;
    }

    public int getFirstNumber(){
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public String getResult() {
        int sum = firstNumber+secondNumber;
        return String.format("%d", sum);
    }


    protected String generateNumbers() {
        Random r;
        int max=10;
        int min = 0;
        String generatedString = "";
        r = new Random();
        do {
            firstNumber = r.nextInt((max - min) +1) + min;
            secondNumber = r.nextInt((max - min) +1) + min;
        } while (firstNumber + secondNumber > 10);

        generatedString = firstNumber + " + " + secondNumber + " = ";

        return generatedString;
    }
}
