package org.megaja;

// Model from MVC
public class Calculator {

    // Store current value
    private int current=0;

    // Function to calculate current value
    public int get(String x){
        // first number in String
        int first = 0;
        // second number in String
        int second = 0;
        // operation character in String
        char action = 0;

        // find numbers and operation in String
        for( int i=0;i<x.length();i++){
            if (!Character.isDigit(x.charAt(i))){
                action = x.charAt(i);
                first = Integer.parseInt(x.substring(0,i));
                second = Integer.parseInt(x.substring(i+1));
            }
        }

        // depending on operation character use appropriate function
        if (action=='+') current = add(first,second);
        if (action=='-') current = minus(first,second);
        if (action=='*') current = multiply(first,second);
        if (action=='/') current = divide(first,second);

        return current;
    }

    // Function to clear display
    public int clear(){
        current=0;
        return current;
    }

    // Functions for operations character
    private int add(int x, int y){
        return x+y;
    }
    private int minus(int x,int y){
        return x-y;
    }
    private int multiply(int x,int y){
        return x*y;
    }
    private int divide(int x, int y){
        if (y == 0) return 0;
        else return x/y;
    }

}
