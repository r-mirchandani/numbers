package com.num2string;

public class Converter {

    private String input, output;
    private int base;
    private int decimal;
    private NumMap numMap;

    public Converter(NumMap numMap){
        this.numMap = numMap;
    }

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

    private void Split(){
        String[] numParts = input.split("\\.");
        base = Integer.parseInt(numParts[0]);
        decimal = Integer.parseInt(numParts[1]);
    }

    private String ConvertTens(int decimal){
        if (decimal == 0){
            return "Zero";
        } else if (decimal < 10){
            return numMap.getOnesString(decimal % 10);
        } else if (decimal < 20){
            return numMap.getTeensString(decimal);
        } else {
            String tens = numMap.getTensString(decimal/10 % 10);
            String ones = numMap.getOnesString(decimal % 10);
            if (tens != "" && ones != ""){
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
            return result;
        } else if (base < 100){
            result = ConvertTens(base);
        } else if (base < 1000){
            String hundreds = numMap.getOnesString(base/100);
            String trailingResult = ConvertTens(base % 100);
            result = hundreds + " Hundred And " + trailingResult;
        } else if (base < 1000000){
            String thousands = ConvertBase(base/1000);
            String trailingResult = ConvertBase(base % 1000);
            result = thousands + " Thousand " + trailingResult;
        } else if (base < 1000000000){
            String millions = ConvertBase(base/1000000);
            String trailingResult = ConvertBase(base % 1000000);
            result = millions + " Million " + trailingResult;
        } else if (base < 2147483647){
            String billions = ConvertBase(base/1000000000);
            String trailingResult = ConvertBase(base % 1000000000);
            result = billions + " Billion " + trailingResult;
        }
        return result;
    }

    public void Convert(){
        String decimalStr = "", baseStr = "";
        Split();
        decimalStr = ConvertTens(decimal);
        baseStr = ConvertBase(base);
        setOutput(baseStr + " Dollars And " + decimalStr + " Cents");
    }
}
