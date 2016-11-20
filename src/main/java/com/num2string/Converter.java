package com.num2string;

public class Converter {

    // Initialize class attributes
    private String input, output;
    private int base;
    private int decimal;
    private NumMap numMap;

    // Constructor + import hashmap class
    public Converter(NumMap numMap){
        this.numMap = numMap;
    }

    // Getters and setters
    public String getInput(){
        return input;
    }

    public void setInput(String input){
        this.input = input;
    }

    public String getOutput(){
        return output;
    }

    private void setOutput(String output){
        this.output = output;
    }

    // Split input number into whole and decimal integers for later use
    private void Split(){
        String[] numParts = input.split("\\.");
        base = Integer.parseInt(numParts[0]);
        decimal = Integer.parseInt(numParts[1]);
    }

    // function to convert numbers of 2 digits to words
    private String ConvertTens(int decimal){
        if (decimal == 0){ // numbers between 0 and 19 can be directly mapped
            return "Zero";
        } else if (decimal < 10){
            return numMap.getOnesString(decimal % 10);
        } else if (decimal < 20){
            return numMap.getTeensString(decimal);
        } else { // numbers larger than 20 are broken down using modulus and their 10's and 1's column values are found in the hashmaps
            String tens = numMap.getTensString(decimal/10 % 10);
            String ones = numMap.getOnesString(decimal % 10);
            if (tens != "" && ones != ""){ // validation of formatting based on output
                return tens + "-" + ones;
            } else if (tens == ""){
                return ones;
            } else{
                return tens;
            }
        }
    }

    private String ConvertBase(int base){
        String result = "";
        if (base == 0){
            return "Zero";
        } else if (base < 100){ // numbers less than 100 can be processed the the 2 digit conversion function
            result = ConvertTens(base);
        } else if (base < 1000){
            // for numbers greater then 99, the function is recursive in that it calculates only the largest "demonination" on each iteration
            // after calculating the string for the largest order of magnitude, it appends the correct wording and passes the remaining values back into the function
            // this iteratively calculates the values and suffixes of each order of magnitude with minimal code
            String hundreds = numMap.getOnesString(base/100);
            String trailingResult = ConvertTens(base % 100);
            if (trailingResult == "Zero"){
                result = hundreds + " Hundred ";
            } else {
                result = hundreds + " Hundred And " + trailingResult;
            }
        } else if (base < 1000000){
            String thousands = ConvertBase(base/1000);
            String trailingResult = ConvertBase(base % 1000);
            if (trailingResult == "Zero"){
                trailingResult = "";
            }
            result = thousands + " Thousand " + trailingResult;
        } else if (base < 1000000000){
            String millions = ConvertBase(base/1000000);
            String trailingResult = ConvertBase(base % 1000000);
            if (trailingResult == "Zero"){
                trailingResult = "";
            }
            result = millions + " Million " + trailingResult;
        } else if (base < 2147483647){
            String billions = ConvertBase(base/1000000000);
            String trailingResult = ConvertBase(base % 1000000000);
            if (trailingResult == "Zero"){
                trailingResult = "";
            }
            result = billions + " Billion " + trailingResult;
        }
        return result;
    }

    // API access point to utilize all private helper functions to perform complete conversion
    public void Convert(){
        String decimalStr = "", baseStr = "";
        Split();
        decimalStr = ConvertTens(decimal);
        baseStr = ConvertBase(base);
        setOutput(baseStr + " Dollars And " + decimalStr + " Cents");
    }
}
