package com.virtunexa;

public class FactorialCalculator {

    public static int calculateFactorialRecursively(int fac){
        if(fac < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if(fac == 0 || fac == 1) return 1;
        return fac * calculateFactorialRecursively(fac-1);
    }

    public static int calculateFactorialIteratively(int fac) {
        int ans=1;
        for(int i=1; i<=fac; i++) {
            ans*= i;
        }
        return ans;
    }

}
