package com.num2string;
import java.util.HashMap;

public class NumMap {

    // Initialize hashmaps
    HashMap<Integer, String>  onesMap= new HashMap<Integer, String>();
    HashMap<Integer, String>  tensMap = new HashMap<Integer, String>();
    HashMap<Integer, String>  teensMap = new HashMap<Integer, String>();

    public NumMap() { // Populate hashmaps
        onesMap.put(0, "");
        onesMap.put(1, "One");
        onesMap.put(2, "Two");
        onesMap.put(3, "Three");
        onesMap.put(4, "Four");
        onesMap.put(5, "Five");
        onesMap.put(6, "Six");
        onesMap.put(7, "Seven");
        onesMap.put(8, "Eight");
        onesMap.put(9, "Nine");

        tensMap.put(0, "");
        tensMap.put(2, "Twenty");
        tensMap.put(3, "Thirty");
        tensMap.put(4, "Forty");
        tensMap.put(5, "Fifty");
        tensMap.put(6, "Sixty");
        tensMap.put(7, "Seventy");
        tensMap.put(8, "Eighty");
        tensMap.put(9, "Ninety");

        teensMap.put(10, "Ten");
        teensMap.put(11, "Eleven");
        teensMap.put(12, "Twelve");
        teensMap.put(13, "Thirteen");
        teensMap.put(14, "Fourteen");
        teensMap.put(15, "Fifteen");
        teensMap.put(16, "Sixteen");
        teensMap.put(17, "Seventeen");
        teensMap.put(18, "Eighteen");
        teensMap.put(19, "Nineteen");
    }

    // Getters (setters not required)
    public String getOnesString(int digit){
        return onesMap.get(digit);
    }

    public String getTensString(int digit){
        return tensMap.get(digit);
    }

    public String getTeensString(int digit){
        return teensMap.get(digit);
    }
}
